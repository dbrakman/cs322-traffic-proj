public class CarLaneTester{
	public static void main(String[] args){
		Car x = new Car(1, 1, 1);
		
		//************Testing getCurrentDirection**************
		System.out.println(x.getCurrentDirection());  
		//Returns -1, because the car is not meant to turn yet.

		//************Testing update()*************************
		x.update();
		System.out.println(x.getCurrentDirection()); 
		//Returns 1, because the car is meant to turn and that is its 
		//specified turn direction.


		Lane l = new Lane();
		
		//************Testing add() and get()*******************
		l.add(x);
		Car c = l.get();
		System.out.println(c.getCurrentDirection()); 
		//Returns 1.
		//Car x is added to the lane.  It is then "polled" and put into c.
		//getCurrentDirection returns 1, because that is what was c's value for
		//turnDirectionCode
	}
	
}