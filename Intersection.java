// Programmers: GOATS team: Alex David Rex Tom Zihao
// *****************************************************************************
// *****************************************************************************
// **** Intersection
// *****************************************************************************
// *****************************************************************************
// Latest Enhancement: Stage 1 style

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

    private static final int SOUTHWARD = 0;
    private static final int EASTWARD = 1;
    private static final int NORTHWARD = 2;
    private static final int WESTWARD = 3;
   
    private static final int LEFT = -1;
    private static final int RIGHT = 1;
    private static final int STRAIGHT = 0;

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



    //Looks at each lane in inLane and moves the car in that lane 
    //(if it has one) into the appropriate outLane spot
    // Print the empty/nonempty status of incoming lanes, and when cars moved
    public void visit()
    {
        // First, process cars entering from the south (inLane[NORTHWARD])
        // Second, process cars entering from the east (inLane[WESTWARD])
        // Third, process cars entering from the north (inLane[SOUTHWARD])
        // Fourth, process cars entering from the west (inLane[EASTWARD])
        for( int step = 1; step <= 4; step++ )
        {
            int srcDir = getNthProcessedLaneDirection(step);
            inLane[srcDir].update();
            if( !inLane[srcDir].isEmpty() )
            {
                System.out.print("  incoming lane having direction " +
                        TrafficTesterView.convertToLaneDirection(srcDir) +
                        " is nonempty");
                Car c = inLane[srcDir].peek();
                if( c != null )
                {
                    int destDir = getDestDir(srcDir,c.getCurrentDirection());
                    if( !outLane[destDir].isFull() )
                    {
                        System.out.println(" and");
                        System.out.println("   car#" + c.getID() + 
                            " is removed and placed into " + 
                            "outgoing lane having direction " +
                            TrafficTesterView.convertToLaneDirection(destDir));
                        inLane[srcDir].get(); // remove c from the inLane
                        c.update(); // tell c to decrement its numBlocksB4Turn
                        outLane[destDir].add(c);
                    } else {
                        System.out.println(" but");
                        System.out.println("   car#" + c.getID() + 
                            " does not move because " + 
                            "outgoing lane having direction " +
                            TrafficTesterView.convertToLaneDirection(destDir) +
                            " is full");
                    } // end if( !outLane[destDir].isFull() )
                } else {
                    System.out.println(); //Say no more than "lane is nonempty"
                } // end if( c != null );
            } else {
                System.out.println("  incoming lane having direction " +
                        TrafficTesterView.convertToLaneDirection(srcDir) +
                        " is empty");
            } // end if( !inLane[srcDir].isEmpty() )
        } // end for( int step = 1; step <= 4; step++ )
        // Lastly, print the empty/nonempty status of outgoing lanes
        for( int step = 1; step <= 4; step++ )
        {
            int outDir = getNthProcessedLaneDirection(step);
            System.out.println("  outgoing lane having direction " +
                TrafficTesterView.convertToLaneDirection(outDir) + " is " +
                (outLane[outDir].isEmpty() ? "empty" : "nonempty"));
        } 

    } // end visit()



     //Method which when passed an int of value 1-4 returns the direction
      // Clarification: Northward inlanes approach from the south,
      //  therefore the order Northward, Westward, Southward, Eastward, 
      //  corresponds to the order of processing: S-E-N-W
    private int getNthProcessedLaneDirection(int step)
    {
        if( step == 1 ){ return NORTHWARD; }
        if( step == 2 ){ return WESTWARD; }
        if( step == 3 ){ return SOUTHWARD; }
        if( step == 4 ){ return EASTWARD; }
        return -999;
    } // end getNthProcessedLaneDirection(int step)



    //When passed both a source lane direction and carTurnDir
    //  returns the direction the car would turn using SENW directions
    private int getDestDir(int sourceLaneDir, int carTurnDir)
    {
        if( sourceLaneDir == NORTHWARD )
        {
            if( carTurnDir == LEFT ){ return WESTWARD; }
            if( carTurnDir == STRAIGHT ){ return NORTHWARD; }
            if( carTurnDir == RIGHT ){ return EASTWARD; }
        } else if( sourceLaneDir == WESTWARD )
        {
            if( carTurnDir == LEFT ){ return SOUTHWARD; }
            if( carTurnDir == STRAIGHT ){ return WESTWARD; }
            if( carTurnDir == RIGHT ){ return NORTHWARD; }
        } else if( sourceLaneDir == SOUTHWARD )
        {
            if( carTurnDir == LEFT ) { return EASTWARD; }
            if( carTurnDir == STRAIGHT ){ return SOUTHWARD; }
            if( carTurnDir == RIGHT ){ return WESTWARD; }
        } else if( sourceLaneDir == EASTWARD )
        {
            if( carTurnDir == LEFT ){ return NORTHWARD; }
            if( carTurnDir == STRAIGHT ){ return EASTWARD; }
            if( carTurnDir == RIGHT ){ return SOUTHWARD; }
        } // end of if( sourceLaneDir == NORTHWARD )
        return -999;
    } // end of getDestDir(int sourceLaneDir, int carTurnDir)
           


}//end Intersection class