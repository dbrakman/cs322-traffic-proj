import java.util.ArrayList;

public class TrafficTesterModel{
	Grid g;
	//int t;

	//************Constructor************
	public TrafficTesterModel(int numRows, int numCols, 
	ArrayList< ArrayList<Integer> > carParameters){

		//********Creating a new grid********
		Grid g = new Grid(numRows, numCols);

		//********Construct cars and add them to the grid********
		for(int i = 0; i < carParameters.size(); i++){
			ArrayList<Integer> newCar = new ArrayList<Integer>();
			newCar = carParameters.get(i);
			Car c = new Car(newCar.get(0), newCar.get(1), newCar.get(2));
			g.insertCar(newCar.get(3), newCar.get(4), newCar.get(5), c);
		}
	}
}