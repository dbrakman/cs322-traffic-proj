import java.util.ArrayList;

public class TrafficTesterModelTester{
	public static void main(String[] args){
		ArrayList<Integer> al1= new ArrayList<Integer>(3);
		al1.add(0, 1);
		al1.add(1, 1);
		al1.add(2, 1);
		ArrayList<Integer> al2= new ArrayList<Integer>(3);
		al1.add(0, 2);
		al1.add(1, 2);
		al1.add(2, 2);
		ArrayList<Integer> al3= new ArrayList<Integer>(3);
		al1.add(0, 3);
		al1.add(1, 3);
		al1.add(2, 3);
		
		ArrayList< ArrayList<Integer> > test = new ArrayList< ArrayList<Integer> >(3);
		test.add(0, al1);
		test.add(1, al2);
		test.add(2, al3);

		//TrafficTesterModel model = new TrafficTesterModel(2, 2, test);

	}
}