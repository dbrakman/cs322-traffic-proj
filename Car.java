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

	//**************Instance Methods**************
	//After a car moves from one lane to another, update() is called to 
	//decrement the numBlocksBeforeTurning 
	public void update(){
		this.numBlocksBeforeTurning--;
	}

	//Determines which direction a car will be moving.
	//If its numBlocksBeforeTurning is 0, the it will return the car's 
	//turnDirectinoCode.
	//Otherwise, it will return -1, which indicates it is moving straight
	public int getCurrentDirection(){
		if (this.numBlocksBeforeTurning == 0){
			return this.turnDirectionCode;
		}
		else{
			return 0;
		}
	}
}
