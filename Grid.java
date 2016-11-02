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
			Car car = new Car(c.get(4), c.get(5), c.get(0));
            insertCar(c.get(1), c.get(2), c.get(3), car);
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
