// Programmers: GOATS team: Alex David Rex Tom Zihao
// *****************************************************************************
// *****************************************************************************
// **** Car 
// *****************************************************************************
// *****************************************************************************

// Latest Enhancement: Stage 1 Style
// The Car class keeps track of ID, when to turn, and turning direction of each
// instance of Car, and provides such information if needed.

public class Car{
    //**************Instance Variables**************
    int numBlocksBeforeTurning;
    int turnDirectionCode;
    int carID;
    boolean hasChangedLanes;

    //**************Constructor**************
    public Car(int initialNumBlocks, int turnDirectionCode, int carID){
        this.numBlocksBeforeTurning = initialNumBlocks;
        this.turnDirectionCode = turnDirectionCode;
        this.carID = carID;
        this.hasChangedLanes = false;
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



    //Returns hasChangedLanes
    public boolean getHasChangedLanes(){
        return this.hasChangedLanes;
    }//End of getHasChangedLanes() method



    //Sets the hasChangedLanes to change
    public void setHasChangedLanes(boolean change){
        this.hasChangedLanes = change;
    }//End of setHasChangedLanes() method

}
