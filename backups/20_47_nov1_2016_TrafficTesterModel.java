import java.util.ArrayList;

public class TrafficTesterModel{
	Grid g;
	//int t;

	//************Constructor************
	public TrafficTesterModel(int numRows, int numCols, 
	ArrayList< ArrayList<Integer> > carParameters){

		Grid g = new Grid(numRows, numCols);

		for(int i = 0; i < carParameters.size(); i++){
			ArrayList<Integer> newCar = new ArrayList<Integer>();
			newCar = carParameters.get(i);
		}
	}
}