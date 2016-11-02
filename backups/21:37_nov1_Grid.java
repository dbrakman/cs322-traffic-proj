import java.util.*;
import java.io.*;

public class Grid
{

	public Grid(int numRows, int numCols) 
	{
	//Constuctor
		private Intersection i[][] = new Intersection[numRows][numCols];
			//Constructs intersections =(row*col times)
		for(int j = 0; j < numRows; j++)
		{
			for(int k=0; k<numCols; k++)
			{
				i[j][k] = new Intersection();
			}
		}
			//Constructs lanes = col*(row+1) + row*(col + 1)
		for(int i = 0; i < numCols*(numRows+1) + numRows(numCols+1); i++)
		{
			Lanes[i]= new Lane();
		}



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