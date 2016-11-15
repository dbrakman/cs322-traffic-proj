// Programmers: GOATS team: Alex David Rex Tom Zihao
// *****************************************************************************
// *****************************************************************************
// **** Intersection
// *****************************************************************************
// *****************************************************************************
// Latest Enhancement: Fixed order of processing Now: S-E-N-W Was: N-W-S-E. Lanes
//                     are now checked for capacity before adding cars.

//Intersection Class
//An intersection will contain 2 Lane[]'s of size 4, for a total of 8 lanes.
//4 are for inflowing lanes, the other 4 are for outflowing lanes.
//Every car within the inLane array will be evaluated and moved to the proper
//lane within the outLane[], which will put it in the inLane[] for a different
//intersection.

public class Intersection {
    //**************Instance Variables**************
    public Lane[] inLane;
    public Lane[] outLane;

    //**************Constructor**************
    public Intersection(Lane[] inLanes, Lane[] outLanes)
    {
        this.inLane = inLanes;
        this.outLane = outLanes;
    }// end of Intersection(Lane[], Lane[]) constructor



    //**************Instance Methods**************
    // Getter methods to get references to incoming, outgoing lanes
    public Lane getInLane(int laneDir)
    {
        return inLane[laneDir]; 
    }//end of getInLane()



    public Lane getOutLane(int laneDir)
    { 
        return outLane[laneDir]; 
    }//end of getOutLane()



    //The following methods look 
    //at each lane in inLane and move the car in that lane
    //for use in visit() 
    public void fromNorth(int dir, Car c)
    {
        //If the car is coming from the North entry point
        if (dir == 0)
        {//Straight
            System.out.println("   car#" + 
                               c.getID() +
                               " is removed and placed into " + 
                               "outgoing lane having direction " +
                               TrafficTesterView.convertToLaneDirection(0));
            if(outLane[0].isFull() != true) {outLane[0].add(c);}
        }// end if(dir == 0)
        if (dir == 1)
        {//right
            System.out.println("   car#" + 
                                c.getID() +
                                " is removed and placed into " + 
                                "outgoing lane having direction " +
                                TrafficTesterView.convertToLaneDirection(3));
            if(outLane[3].isFull() != true) {outLane[3].add(c);}
        }//end if(dir == 1)    
        if (dir == -1)
        {//left
            System.out.println("   car#" + 
                                c.getID() +
                                " is removed and placed into " + 
                                "outgoing lane having direction " +
                                TrafficTesterView.convertToLaneDirection(1));
            if(outLane[1].isFull() != true) {outLane[1].add(c);}
        }//end if (dir == -1)
    }//end fromNorth()



    public void fromSouth(int dir, Car c)
    {//If the car is coming from the South entry point    
        if (dir == 0)
        {//Straight
            System.out.println("   car#" + 
                               c.getID() +
                               " is removed and placed into " + 
                               "outgoing lane having direction " +
                               TrafficTesterView.convertToLaneDirection(2));
            if(outLane[2].isFull() != true) {outLane[2].add(c);}
        }//end if(dir == 0)
        if (dir == 1)
        {//right
            System.out.println("   car#" + 
                               c.getID() +
                               " is removed and placed into " + 
                               "outgoing lane having direction " +
                               TrafficTesterView.convertToLaneDirection(1));
            if(outLane[1].isFull() != true) {outLane[1].add(c);}
        }//end if(dir == 1)    
        if (dir == -1)
        {//left
            System.out.println("   car#" + 
                              c.getID() +
                              " is removed and placed into " + 
                               "outgoing lane having direction " +
                               TrafficTesterView.convertToLaneDirection(3));
            if(outLane[3].isFull() != true) {outLane[3].add(c);}
        }//end if(dir == -1)
    }//end fromSouth()



    public void fromEast(int dir, Car c)
    {//If the car is coming from the East entry point
        if (dir == 0)
        {//Straight
            System.out.println("   car#" + 
                               c.getID() +
                               " is removed and placed into " + 
                               "outgoing lane having direction " +
                               TrafficTesterView.convertToLaneDirection(3));
            if(outLane[3].isFull() != true) {outLane[3].add(c);}
        }//end if(dir == 0)
        if (dir == 1)
        {//right
            System.out.println("   car#" + 
                               c.getID() +
                               " is removed and placed into " + 
                               "outgoing lane having direction " +
                               TrafficTesterView.convertToLaneDirection(2));
            if(outLane[2].isFull() != true) {outLane[2].add(c);}
        }//end if(dir == 1)    
        if (dir == -1)
        {//left
            System.out.println("   car#" + 
                               c.getID() +
                               " is removed and placed into " + 
                               "outgoing lane having direction " +
                               TrafficTesterView.convertToLaneDirection(0));
            if(outLane[0].isFull() != true) {outLane[0].add(c);}
        }//end if(dir == -1)
    }//end fromEast()



    public void fromWest(int dir, Car c)
    {//If the car is coming from the West entry point
        if (dir == 0)
        {//Straight
            System.out.println("   car#" + 
                               c.getID() +
                               " is removed and placed into " + 
                               "outgoing lane having direction " +
                               TrafficTesterView.convertToLaneDirection(1));
            if(outLane[1].isFull() != true){outLane[1].add(c);}
            
        }//end if(dir == 0)
        if (dir == 1)
        {//right
            System.out.println("   car#" + 
                               c.getID() +
                               " is removed and placed into " + 
                               "outgoing lane having direction " +
                               TrafficTesterView.convertToLaneDirection(0));
            if(outLane[0].isFull() != true) {outLane[0].add(c);}
        }//end if(dir == 1)    
        if (dir == -1)
        {//left
            System.out.println("   car#" + 
                               c.getID() +
                               " is removed and placed into " + 
                               "outgoing lane having direction " +
                               TrafficTesterView.convertToLaneDirection(2));
          if(outLane[2].isFull() != true) {outLane[2].add(c);}
        }//end if(dir == -1)
    }//end of fromWest()



    //Looks at each lane in inLane and moves the car in that lane 
    //(if it has one) into the appropriate outLane spot
    // Print the empty/nonempty status of incoming lanes, and when cars moved
    public void visit()
    {
    	 /*Creation of fire intersections
        for (int colNum = 0; colNum <= numCols + 1; colNum++)
        {
        Destroy the cars in these fire intersections;
        } //end of for (int colNum = 0; colNum <= numCols + 1; colNum++)
        for (int rowNum = 0; rowNum <= numRows + 1; rowNum++){
             Destroy the cars in these fire intersections;
        } //end of (for int rowNum = 0; rowNum <= numRows + 1; rowNum++)
*///implementation of fire intersections

        for (int i = 0; i <= 3; i++)
        { //Iterate through the 4 cardinal directions
            Car c = inLane[i].get();
            if (c != null)
            {
                System.out.println("  incoming lane having direction " +
                            TrafficTesterView.convertToLaneDirection(i) +
                            " is nonempty and");
                int dir = c.getCurrentDirection();
                c.update();
                if(i == 0){ fromSouth(dir, c); }
                if(i == 1){ fromEast(dir, c); }
                if(i == 2){ fromNorth(dir, c); }
                if(i == 3){ fromWest(dir, c); }
            } else {
                System.out.println("  incoming lane having direction " +
                            TrafficTesterView.convertToLaneDirection(i) +
                            " is empty");
            }//end if(c != null) 
        }//end first for()

        // Now all the incoming cars have been moved to outLanes
        // Iterate through the outgoing lanes, printing empty/nonempty
        for(int j=0; j<4; j++)
        {
            if( outLane[j].isEmpty() )
            {
                System.out.println("  outgoing lane having direction " +
                            TrafficTesterView.convertToLaneDirection(j) +
                            " is empty");
            } else {
                System.out.println("  outgoing lane having direction " +
                            TrafficTesterView.convertToLaneDirection(j) +
                            " is nonempty");
            }//end if( outLane[j].isEmpty() )
        }//end for(int j=0; j<4; j++)
    }//end visit()



}//end Intersection class
