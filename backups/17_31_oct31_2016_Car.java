//Car class
//The class defines a "car" object, which will travel throughout the grid
//given specifed directions on where it should travel

public class Car{
	//**************Instance Variables**************
	int numBlocksBeforeTurning;
	int turnDirectionCode;
	int carID;

	//**************Constructor**************
	public Car(int initialNumBlocks, int turnDirectionCode, int carID){
		this.numBlocksBeforeTurning = initialNumBlocks;
		this.turnDirectionCode = turnDirectionCode;
		this.carID = carID;
	}
}