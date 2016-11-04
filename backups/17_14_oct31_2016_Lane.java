//Lane Class
//This class defines a "Lane" object, which will hold cars.
//Lanes can be either incoming or outgoing depending on their direction in 
//in relation to intersections.
//Each lane will belong to 2 intersections: as an incoming lane for one
//and an outgoing lane for another

public class Lane{
	//**************Instance variables**************
	public Queue<Car> q;

	//**************Constructor**************
	public Lane(){
		q = new LinkedList<Car>();
	}
}