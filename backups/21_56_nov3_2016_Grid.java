// Tried to fix runtime error with lanes not existing
//Added insertCar and update
//Added print statement
//////////////// 80 characters /////////////////////////////////////////////////
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
	
	//Constuctor
    public Grid(int numRows, int numCols) 
	{
        // Allocate space for numRows*numCols intersections
        // In nested for loops, construct lanes and intersections appropriately
		i = new Intersection[numRows][numCols];
        Lane inLanes[];
        Lane outLanes[];
		for(int rowNum = 0; rowNum < numRows; rowNum++)
		{
		  for(int colNum=0; colNum<numCols; colNum++)
		  {
            System.out.print("Constructing Intersection ("+(rowNum+1)+
                    ","+(colNum+1)+")...");
            // Construct the right amount of lanes for each intersection
            // There's a pattern:
            //   3 2 2 2
            //   3 2 2 2
            //   3 2 2 2
            //   4 3 3 3
	    	inLanes = new Lane[4];
			outLanes = new Lane[4];
			if(rowNum==0){
			  if(colNum==0){
				for(int cardinalDir=0; cardinalDir<4; cardinalDir++){
				  inLanes[cardinalDir] = new Lane();
				  outLanes[cardinalDir] = new Lane();
				}
		      } else { //rowNum==0, colNum > 0
				for(int cardinalDir=0; cardinalDir<4; cardinalDir++){
                    if(cardinalDir==WESTWARD){
                        outLanes[WESTWARD] = i[rowNum][colNum-1].getInLane(WESTWARD);
                    } else {
                        outLanes[cardinalDir] = new Lane();
                    }
                }
                for(int cardinalDir=0; cardinalDir<4; cardinalDir++){
                    if(cardinalDir==EASTWARD){
                        inLanes[EASTWARD] = i[rowNum][colNum-1].getOutLane(EASTWARD);
                    } else {
                        inLanes[cardinalDir] = new Lane();
                    }
                }
              }
			} else { //rowNum > 0
			  if(colNum==0){
				for(int cardinalDir=0; cardinalDir<4; cardinalDir++){
                    if(cardinalDir==SOUTHWARD){
                        outLanes[SOUTHWARD] = i[rowNum-1][colNum].getInLane(SOUTHWARD);
                    } else {
                        outLanes[cardinalDir] = new Lane();
                    }
                }
                for(int cardinalDir=0; cardinalDir<4; cardinalDir++){
                    if(cardinalDir==NORTHWARD){
                        inLanes[NORTHWARD] = i[rowNum-1][colNum].getOutLane(NORTHWARD);
                    } else {
                        inLanes[cardinalDir] = new Lane();
                    }
                }
              } else { //rowNum > 0, colNum > 0
			    for(int cardinalDir=0; cardinalDir<4; cardinalDir++){
                    if(cardinalDir==SOUTHWARD){
                        outLanes[SOUTHWARD] = i[rowNum-1][colNum].getInLane(SOUTHWARD);
                    } else if(cardinalDir==WESTWARD){
                        outLanes[WESTWARD] = i[rowNum][colNum-1].getInLane(SOUTHWARD);
                    } else {
                        outLanes[cardinalDir] = new Lane();
                    }
                }
                for(int cardinalDir=0; cardinalDir<4; cardinalDir++){
                    if(cardinalDir==NORTHWARD){
                        inLanes[NORTHWARD] = i[rowNum-1][colNum].getOutLane(NORTHWARD);
                    } else if(cardinalDir==EASTWARD){
                        inLanes[EASTWARD] = i[rowNum][colNum-1].getOutLane(EASTWARD);
                    } else {
                        inLanes[cardinalDir] = new Lane();
                    }
                }
			  }
		    }
            //end lane construction

		  i[rowNum][colNum] = new Intersection(inLanes,outLanes);
          System.out.println("Success!");
		} 
	  }
	// The above code constructs lanes and intersections, populates grid */
    }

	public void insertCars(ArrayList< ArrayList<Integer> > carParameters)
	{
		//Constructs cars w/ carParameters
		for( ArrayList<Integer> d:carParameters )
		{
			int [] temp = new int[6];
			for(int i = 0; i < d.size(); i++)
			{
				temp[i] = d.get(i);
			}
			Car c = new Car(temp[4], temp[5], temp[0]);
			this.insertCar(temp[1], temp[2], temp[3], c);
			//ArrayList carParameters looks like this: [0]int carID, [1]int row, [2]int col, 
			//[3]int laneDirectionCode, [4]int numBlocksBeforeTurning, [5]int turnDirectionCode
		}
	}
	
    public void update()
    {
    	for (int rowNum = 0; rowNum < i.length; rowNum++){
            for (int colNum = 0; colNum < i[0].length; colNum++){
    		    System.out.println("At the intersection located at col " + (colNum+1) +
                                   " and row " + (rowNum+1));
    			i[rowNum][colNum].visit();
    		}
    	}
	}

    private void insertCar(int row, int col, int laneDir, Car c)
	{
		(i[row-1][col-1].getInLane(laneDir)).add(c);
	}
}
