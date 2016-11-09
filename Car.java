// Programmers: GOATS team: Alex David Rex Tom Zihao
// *****************************************************************************
// *****************************************************************************
// **** Car 
// *****************************************************************************
// *****************************************************************************
// The Car class keeps tracks of ID, when to turn, and turning dirction of each
// instance of Car, and provide such information if needed.

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
	}//End of car constructor



	//**************Instance Methods**************
	//After a car moves from one lane to another, update() is called to 
	//decrement the numBlocksBeforeTurning 
	public void update(){
		this.numBlocksBeforeTurning--;
	}//End of update() method



	//Determines which direction a car will be moving.
	//If its numBlocksBeforeTurning is 0, the it will return the car's 
	//turnDirectinoCode.
	//Otherwise, it will return -1, which indicates it is moving straight
	public int getCurrentDirection(){
		if (this.numBlocksBeforeTurning == 0){
			return this.turnDirectionCode;
		}//end of if(this.numBlocksBeforeTurning == 0)
		else{
			return 0;
		}
	}//End of getCurrentDirection() method



	//Return the ID of a car
	public int getID(){
		return this.carID;
	}//End of getID() method
}
