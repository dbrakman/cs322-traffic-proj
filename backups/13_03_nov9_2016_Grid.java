// Programmers: GOATS team: Alex David Rex Tom Zihao
// *****************************************************************************
// *****************************************************************************
// **** Grid
// *****************************************************************************
// *****************************************************************************

// Latest Enhancement: Applied style rules for stage_0 (except indexing)
import java.util.*;
import java.io.*;

public class Grid
{
    public static final int SOUTHWARD = 0;
    public static final int EASTWARD = 1;
    public static final int NORTHWARD = 2;
    public static final int WESTWARD = 3;

    // Store Intersections in a 2D array:
    //   Since Java is 0-indexed, Intersection (1,2) is i[0][1]
    private Intersection i[][];
    private int numRows;
    private int numCols;
    
    //Constuctor
    public Grid(int numRows, int numCols) 
    {
        this.numRows = numRows;
        this.numCols = numCols;
        // Allocate space for numRows*numCols intersections
        // In nested for loops, construct lanes and intersections appropriately
        i = new Intersection[numRows][numCols];
        for(int rowNum = 0; rowNum < numRows; rowNum++)
        {
            for(int colNum=0; colNum<numCols; colNum++)
            {
                //System.out.print("Constructing Intersection ("+(rowNum+1)+
                    //      ","+(colNum+1)+")...");
                // Construct the right amount of lanes for each intersection
                // There's a pattern in the number of "new" lane pairs for each:
                //   3 2 2 2
                //   3 2 2 2
                //   3 2 2 2
                //   4 3 3 3
                if(rowNum==0)
                {
                    if(colNum==0)
                    {
                        // Construct 4 new lanes for Intersection [1,1]
                        shareNoLanes(rowNum, colNum);
                    } else { //rowNum==0, colNum > 0
                        // Constructs and shares lanes for the intersection at
                        // [rowNum, colNum]
                        shareLanesWithLeft(rowNum,colNum);
                    } // end of if(colNum==0)
                } else { //rowNum > 0
                    if(colNum==0)
                    {
                        shareLanesWithBelow(rowNum,colNum);
                    } else { //rowNum > 0, colNum > 0
                        shareLanesWithLeftAndBelow(rowNum,colNum);
                    } // end of if(colNum==0)
                } // end of if(rowNum==0)
                //end lane construction
                //System.out.println("Success!");
            } // end of for(int colNum=0; colNum<numCols; colNum++)
        } // end of for(int rowNum = 0; rowNum < numRows; rowNum++)
        // The above code constructs lanes and intersections, populates grid */
        setOutboundBoundaryLanes();  
    } // end of Grid(int numRows, int numCols) 

    

    public void insertCars(ArrayList< ArrayList<Integer> > carParameters)
    {
        //Constructs cars w/ carParameters
        for( ArrayList<Integer> d:carParameters )
        {
            Car c = new Car( d.get(4), d.get(5), d.get(0) );
            this.insertCar( d.get(1), d.get(2), d.get(3), c );
            //ArrayList carParameters looks like this: 
                //[0]int carID, [1]int row, [2]int col, 
                //[3]int laneDirectionCode, [4]int numBlocksBeforeTurning,
                //[5]int turnDirectionCode
        } // end of for( ArrayList<Integer> d:carParameters )
    } // end of insertCars(ArrayList< ArrayList<Integer> > carParameters)


    
    public void update()
    {
        for ( int rowNum = 0; rowNum < i.length; rowNum++ )
        {
            for ( int colNum = 0; colNum < i[0].length; colNum++ )
            {
                System.out.println("");
                System.out.println("At the intersection located at col " +
                                    (colNum+1) + " and row " + (rowNum+1));
                i[rowNum][colNum].visit();
            } // end of for( int colNum = 0; colNum < i[0].length; colNum++ )
        } // end of for( int rowNum = 0; rowNum < i.length; rowNum++ )
    } // end of update()



    private void insertCar(int row, int col, int laneDir, Car c)
    {
        (i[row-1][col-1].getInLane(laneDir)).add(c);
    } // end of insertCar(int row, int col, int laneDir, Car c)




    private void shareLanesWithLeftAndBelow(int rowNum, int colNum)
    {
        Lane[] inLanes = new Lane[4];
        Lane[] outLanes = new Lane[4];
        for(int cardinalDir=0; cardinalDir<4; cardinalDir++)
        {
            // For rows and columns > 1, lanes need to be shared
            // with the intersection at left and with the intersection
            // below
            if(cardinalDir==SOUTHWARD){
                outLanes[SOUTHWARD] = i[rowNum-1][colNum].getInLane(SOUTHWARD);
            } else if(cardinalDir==WESTWARD){
                outLanes[WESTWARD] = i[rowNum][colNum-1].getInLane(SOUTHWARD);
            } else {
                outLanes[cardinalDir] = new Lane();
            } // end of if(cardinalDir==SOUTHWARD)
        } // end of for(int cardinalDir=0; cardinalDir<4; cardinalDir++)
        for(int cardinalDir=0; cardinalDir<4; cardinalDir++)
        {
            if(cardinalDir==NORTHWARD)
            {
                inLanes[NORTHWARD] = i[rowNum-1][colNum].getOutLane(NORTHWARD);
            } else if(cardinalDir==EASTWARD){
                inLanes[EASTWARD] = i[rowNum][colNum-1].getOutLane(EASTWARD);
            } else {
                inLanes[cardinalDir] = new Lane();
            } // end of if(cardinalDir==NORTHWARD)
        } // end of for(int cardinalDir=0; cardinalDir<4; cardinalDir++)
        i[rowNum][colNum] = new Intersection(inLanes,outLanes);
   } // end of shareLanesWithLeftAndBelow(int rowNum, int colNum)



    private void shareLanesWithBelow(int rowNum, int colNum)
    {
        Lane[] inLanes = new Lane[4];
        Lane[] outLanes = new Lane[4];
        for(int cardinalDir=0; cardinalDir<4; cardinalDir++)
        {
            // For rows > 1, the leftmost column has to share
            // a pair of lanes with the intersection below it
            if(cardinalDir==SOUTHWARD){
                outLanes[SOUTHWARD] = i[rowNum-1][colNum].getInLane(SOUTHWARD);
            } else {
                outLanes[cardinalDir] = new Lane();
            } // end of if(cardinalDir==SOUTHWARD)
        } // end of for(int cardinalDir=0; cardinalDir<4; cardinalDir++)
        for(int cardinalDir=0; cardinalDir<4; cardinalDir++)
        {
            if(cardinalDir==NORTHWARD){
                inLanes[NORTHWARD] = i[rowNum-1][colNum].getOutLane(NORTHWARD);
            } else {
                inLanes[cardinalDir] = new Lane();
            } // end of if(cardinalDir==NORTHWARD)
        } // end of for(int cardinalDir=0; cardinalDir<4; cardinalDir++)
        i[rowNum][colNum] = new Intersection(inLanes,outLanes);
    } // end of shareLanesWithBelow(int rowNum, int colNum)



    private void shareLanesWithLeft(int rowNum, int colNum)
    {
        Lane[] inLanes = new Lane[4];
        Lane[] outLanes = new Lane[4];
        for(int cardinalDir=0; cardinalDir<4; cardinalDir++)
        {
            // On row 1, each intersection's westward outbound lane is the
            // westward inbound lane of the intersection in the previous column
            if(cardinalDir==WESTWARD)
            {
                outLanes[WESTWARD] = i[rowNum][colNum-1].getInLane(WESTWARD);
            } else {
                // The other 3 outbound lanes are new to this intersection
                outLanes[cardinalDir] = new Lane();
            } // end of if(cardinalDir==WESTWARD)
        } // end of for(int cardinalDir=0; cardinalDir<4; cardinalDir++)
        for(int cardinalDir=0; cardinalDir<4; cardinalDir++)
        {
            // Similarly, the eastward inbound lane (adjacent to the
            // westward outbound lane) has already been constructed
            // and assigned to the intersection in the previous col.
            if(cardinalDir==EASTWARD)
            {
                inLanes[EASTWARD] = i[rowNum][colNum-1].getOutLane(EASTWARD);
            } else {
                inLanes[cardinalDir] = new Lane();
            } // end of if(cardinalDir==EASTWARD)
        } // end of for(int cardinalDir=0; cardinalDir<4; cardinalDir++)
        i[rowNum][colNum] = new Intersection(inLanes,outLanes);
    } // end of shareLanesWithLeft(int rowNum, int colNum)



    private void shareNoLanes(int rowNum, int colNum)
    {
        Lane[] inLanes = new Lane[4];
        Lane[] outLanes = new Lane[4];
        for( int cardinalDir=0; cardinalDir<4; cardinalDir++ )
        {
            //Generate 4 new lane pairs for Intersection [1,1]
            inLanes[cardinalDir] = new Lane();
            outLanes[cardinalDir] = new Lane();
        } // end of for( int cardinalDir=0; cardinalDir<4; cardinalDir++ )
        i[rowNum][colNum] = new Intersection(inLanes,outLanes);
    } // end of shareNoLanes(int rowNum, int colNum)



    private void setOutboundBoundaryLanes()
    {
        for(int colNum=0; colNum < numCols; colNum++)
        {
            i[0][colNum].getOutLane(SOUTHWARD).setIsBoundary(); 
            //bottom row exits SOUTH
            i[numRows-1][colNum].getOutLane(NORTHWARD).setIsBoundary(); 
            //top row exits NORTH
        }
        for(int rowNum=0; rowNum < numRows; rowNum++)
        {
            i[rowNum][0].getOutLane(WESTWARD).setIsBoundary(); 
            //leftmost col exits WEST
            i[rowNum][numCols-1].getOutLane(EASTWARD).setIsBoundary(); 
            //rightmost col exits WEST
        }
    } // end of setOutboundBoundaryLanes()



}
