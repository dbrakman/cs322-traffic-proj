// Added print statement, revised comments
//////////////// 80 characters /////////////////////////////////////////////////
import java.util.ArrayList;

public class TrafficTesterModel{
	Grid g;
	//int t;

	//************Constructor************
	public TrafficTesterModel(int numRows, int numCols, 
	ArrayList< ArrayList<Integer> > carParameters){

		//********Creating a new grid********
		Grid g = new Grid(numRows, numCols);

		//********Teling the grid to make and insert cars********
		g.insertCars(carParameters);

	}

    public void run(){
        System.out.println("In TrafficTesterModel: running simulation");
    }
}
