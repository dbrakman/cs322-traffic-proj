// Added comments; made variable names more descriptive; fixed line width
//////////////// 80 characters /////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class Grid
{
	// Store Intersections in a 2D array:
    //   Since Java is 0-indexed, Intersection (1,2) is i[0][1]
    private Intersection i[][];
	
	//Constuctor
    public Grid(int numRows, int numCols) 
	{
		
		/*
        // Allocate space for numRows*numCols intersections
        // In nested for loops, construct lanes and intersections appropriately
		i = new Intersection[numRows][numCols];
		for(int rowNum = 0; rowNum < numRows; rowNum++)
		{
		  for(int colNum=0; colNum<numCols; colNum++)
		  {
            // Construct the right amount of lanes for each intersection
            // There's a pattern:
            //   3 2 2 2
            //   3 2 2 2
            //   3 2 2 2
            //   4 3 3 3
	    	inLanes = new Lane[4];
			outLanes = new Lane[4];
			if(rowNum==1){
			  if(colNum==1){
				for(int laneDir=0; l<4; l++){
				  inLanes[laneDir] = new Lane();
				  outLanes[laneDir] = new Lane();
				}
		      } else { //rowNum==1, colNum > 1
				for(int laneDir=0; l<4; l++){
				  //better information hiding would be laneDir==Direction.WEST
                  //instead of laneDir==3
			      if(laneDir==3){ //Don't construct a new lane; use i_prev's
					inLanes[laneDir] = i[rowNum][colNum-1].getInLane(l);
					outlanes[laneDir] = i[rowNum][colNum-1].getOutLane(l);
				  } else {
					inLanes[laneDir] = new Lane();
					outLanes[laneDir] = new Lane();
				  }
				}
              }
			} else { //rowNum > 1
			  if(colNum==1){
				for(int laneDir=0; l<4; l++){
				  if(laneDir==0){
					inLanes[laneDir] = i[rowNum-1][colNum].getInLane(l);
					outlanes[laneDir] = i[rowNum-1][colNum].getOutLane(l);
				  } else {
					inLanes[laneDir] = new Lane();
					outLanes[laneDir] = new Lane();
				  }
                }
			  } else { //rowNum > 1, colNum > 1
			    for(int laneDir=0; l<4; l++){
				  if(laneDir==0){ //later, Direction.SOUTH
				    inLanes[laneDir] = i[rowNum-1][colNum].getInLane(l);
					outlanes[laneDir] = i[rowNum-1][colNum].getOutLane(l);
				  } else if(laneDir==3){ //later, Direction.WEST
					  inLanes[laneDir] = i[rowNum][colNum-1].getInLane(l);
					  outlanes[laneDir] = i[rowNum][colNum-1].getOutLane(l);
				  } else {
					inLanes[laneDir] = new Lane();
					outLanes[laneDir] = new Lane();
				  }
				}
			  }
		    }
            //end lane construction

		  i[rowNum][colNum] = new Intersection(inLanes,outLanes);
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

	}

    private void insertCar(int row, int col, int laneDir, Car c)
	{

	}
}
