import java.util.ArrayList;

public class TrafficTesterModel{
	Grid g;
	//int t;

	//************Constructor************
	public TrafficTesterModel(int numRows, int numCols, 
	ArrayList< ArrayList<Integer> > carParameters){

		//********Creating a new grid********
		Grid g = new Grid(numRows, numCols);

		//********Construct cars by passing them to the grid********
		g.insertCars(carParameters);

	}

    public void run();
}
