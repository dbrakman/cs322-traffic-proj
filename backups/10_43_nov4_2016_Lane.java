//Added isEmpty
//Updated add and added setIsBoundary

import java.util.Queue;
import java.util.LinkedList;

//Lane Class
//This class defines a "Lane" object, which will hold cars.
//Lanes can be either incoming or outgoing depending on their direction in 
//in relation to intersections.
//Each lane will belong to 2 intersections: as an incoming lane for one
//and an outgoing lane for another

public class Lane{
	//**************Instance Variables**************
	public Queue<Car> q;
	public boolean boundary;

	//**************Constructor**************
	public Lane(){
		q = new LinkedList<Car>();
		boundary = false;
	}

	//**************Instance Methods**************
	//Removes a car from a lane and returns it
	public Car get(){
		return q.poll();
	}

	//Adds a provided car c to the lane
	public boolean add(Car c){
		if (this.boundary == true){
			System.out.println("   car#" + c.getID() + " leaves the grid");
		}
		return q.add(c);
	}

	public boolean isEmpty(){
		return (q.peek() == null);
	}

	public void setIsBoundary(){
		this.boundary = true;
	}

}
