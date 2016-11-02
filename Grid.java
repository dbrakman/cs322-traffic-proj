import java.util.*;
import java.io.*;

public class Grid
{
	private Intersection i[][];
	public Grid(int numRows, int numCols) 
	{
	//Constuctor
		
			//Constructs intersections =(row*col times)
		/*
		i = new Intersection[numRows][numCols];
		for(int j = 0; j < numRows; j++)
		{
			for(int k=0; k<numCols; k++)
			{
				inLanes = new Lane[4];
				outLanes = new Lane[4];
				if(j==1){
					if(k==1){
						for(int l=0; l<4; l++){
							inLanes[l] = new Lane();
							outLanes[l] = new Lane();
						}
					} else {
						for(int l=0; l<4; l++){
							//better information hiding would be l==Direction.WEST
							if(l==3){
								inLanes[l] = i[j][k-1].getInLane(l);
								outlanes[l] = i[j][k-1].getOutLane(l);
							} else {
								inLanes[l] = new Lane();
								outLanes[l] = new Lane();
							}
						}
					} else {
						if(k==1){
							for(int l=0; l<4; l++){
								if(l==0){
									inLanes[l] = i[j-1][k].getInLane(l);
									outlanes[l] = i[j-1][k].getOutLane(l);
								} else {
									inLanes[l] = new Lane();
									outLanes[l] = new Lane();
								}
							} else {
								for(int l=0; l<4; l++){
							//better information hiding would be l==Direction.WEST
									if(l==0){
										inLanes[l] = i[j-1][k].getInLane(l);
										outlanes[l] = i[j-1][k].getOutLane(l);
									} else if(l==3){
										inLanes[l] = i[j][k-1].getInLane(l);
										outlanes[l] = i[j][k-1].getOutLane(l);
									} else {
										inLanes[l] = new Lane();
										outLanes[l] = new Lane();
									}
								}
							}
						}

						i[j][k] = new Intersection(inLanes,outLanes);
					} 
				}
			//Constructs lanes = col*(row+1) + row*(col + 1)
				for(int i = 0; i < numCols*(numRows+1) + numRows(numCols+1); i++)
				{
					Lanes[i]= new Lane();
				}

		
				// Constructs lanes and intersection code above, populates grid accordingly*/

			}
	//public void 

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