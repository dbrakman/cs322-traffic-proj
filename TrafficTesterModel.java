// Added more print statements
//////////////// 80 characters /////////////////////////////////////////////////
import java.util.ArrayList;

public class TrafficTesterModel{
	Grid g;
	//int t;

	//************Constructor************
	public TrafficTesterModel(int numRows, int numCols, 
	ArrayList< ArrayList<Integer> > carParameters){

		System.out.println("In TrafficTesterModel(): ");
        //********Creating a new grid********
        System.out.println("  Constructing a Grid...");
		g = new Grid(numRows, numCols);

		//********Teling the grid to make and insert cars********
		System.out.println("  Telling the grid to make and insert cars...");
        g.insertCars(carParameters);

        System.out.println("Exiting TrafficTesterModel()");
	}

    public void run(){
        System.out.println("In TrafficTesterModel: running simulation");
        g.update();
    }
}
