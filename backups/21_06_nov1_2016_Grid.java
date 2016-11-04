import java.util.*;
import java.io.*;

public class Grid
{

	public Grid(int numRows, int numCols) 
	{
	//Constuctor
	//Constructs intersections =(row*col times)
	//Constructs lanes = col*(row+1) + row*(col + 1)

	}
	//public void 
	
	public void insertCars(ArrayList< ArrayList<Integer> > carParameters)
	{
		//Constructs cars w/ carParameters
		for( c:carParameters )
		{
			int [] temp = new int[6];
			for(int i = 0; i < c.size(); i++)
			{
				temp[i] = c.get(i);
			}
			Car c = new Car(temp[4], temp[5], temp[0]);
			this.insert(temp[1], temp[2], temp[3], c);
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