// Added print statements for outgoing lanes
//////////////// 80 characters /////////////////////////////////////////////////

//Intersection Class
//An intersection will contain 2 Lane[]'s of size 4, for a total of 8 lanes.
//4 are for inflowing lanes, the other 4 are for outflowing lanes.
//Every car within the inLane array will be evaluated and moved to the proper
//lane within the outLane[], which will put it in the inLane[] for a different
//intersection.

public class Intersection{
	//**************Instance Variables**************
	public Lane[] inLane;
	public Lane[] outLane;

	//**************Constructor**************
	public Intersection(Lane[] inLanes, Lane[] outLanes){
		this.inLane = inLanes;
		this.outLane = outLanes;
	}

	//**************Instance Methods**************
    // Getter methods to get references to incoming, outgoing lanes
    public Lane getInLane(int laneDir){ return inLane[laneDir]; }
    public Lane getOutLane(int laneDir){ return outLane[laneDir]; }


	//Looks at each lane in inLane and moves the car in that lane 
	//(if it has one) into the appropriate outLane spot
    // Print the empty/nonempty status of incoming lanes, and when cars moved
	public void visit(){
		for (int i = 0; i <= 3; i++){
			Car c = inLane[i].get();
			if (c != null){
				System.out.println("  incoming lane having direction " +
					              TrafficTesterView.convertToLaneDirection(i) +
					               " is nonempty");
				int dir = c.getCurrentDirection();
				//If the car is coming from the North entry point
				if (i == 0){
					if (dir == 0){//Straight
						outLane[0].add(c);
						System.out.println("   car#" + 
							               c.getID() +
							               " is removed and placed into " + 
							               "outgoing lane having direction " +
							     TrafficTesterView.convertToLaneDirection(0));
					}
					if (dir == 1){//right
						outLane[3].add(c);
						System.out.println("   car#" + 
							               c.getID() +
							               " is removed and placed into " + 
							               "outgoing lane having direction " +
							     TrafficTesterView.convertToLaneDirection(3));
					}    
					if (dir == -1){//left
						outLane[1].add(c);
						System.out.println("   car#" + 
							               c.getID() +
							               " is removed and placed into " + 
							               "outgoing lane having direction " +
							     TrafficTesterView.convertToLaneDirection(1));
					}
				}
				//If the car is coming from the West entry point
				if (i == 1){
					if (dir == 0){//Straight
						outLane[1].add(c);
						System.out.println("   car#" + 
							               c.getID() +
							               " is removed and placed into " + 
							               "outgoing lane having direction " +
							     TrafficTesterView.convertToLaneDirection(1));
					}
					if (dir == 1){//right
						outLane[0].add(c);
						System.out.println("   car#" + 
							               c.getID() +
							               " is removed and placed into " + 
							               "outgoing lane having direction " +
							     TrafficTesterView.convertToLaneDirection(0));
					}    
					if (dir == -1){//left
						outLane[2].add(c);
						System.out.println("   car#" + 
							               c.getID() +
							               " is removed and placed into " + 
							               "outgoing lane having direction " +
							     TrafficTesterView.convertToLaneDirection(2));
					}
				}
				//If the car is coming from the South entry point
				if (i == 2){
					if (dir == 0){//Straight
						outLane[2].add(c);
						System.out.println("   car#" + 
							               c.getID() +
							               " is removed and placed into " + 
							               "outgoing lane having direction " +
							     TrafficTesterView.convertToLaneDirection(2));
					}
					if (dir == 1){//right
						outLane[1].add(c);
						System.out.println("   car#" + 
							               c.getID() +
							               " is removed and placed into " + 
							               "outgoing lane having direction " +
							     TrafficTesterView.convertToLaneDirection(1));
					}    
					if (dir == -1){//left
						outLane[3].add(c);
						System.out.println("   car#" + 
							               c.getID() +
							               " is removed and placed into " + 
							               "outgoing lane having direction " +
							     TrafficTesterView.convertToLaneDirection(3));
					}
				}
				//If the car is coming from the East entry point
				if (i == 3){
					if (dir == 0){//Straight
						outLane[3].add(c);
						System.out.println("   car#" + 
							               c.getID() +
							               " is removed and placed into " + 
							               "outgoing lane having direction " +
							     TrafficTesterView.convertToLaneDirection(3));
					}
					if (dir == 1){//right
						outLane[2].add(c);
						System.out.println("   car#" + 
							               c.getID() +
							               " is removed and placed into " + 
							               "outgoing lane having direction " +
							     TrafficTesterView.convertToLaneDirection(2));
					}    
					if (dir == -1){//left
						outLane[0].add(c);
						System.out.println("   car#" + 
							               c.getID() +
							               " is removed and placed into " + 
							               "outgoing lane having direction " +
							     TrafficTesterView.convertToLaneDirection(0));
					}
				} 
			} else {
					System.out.println("  incoming lane having direction " +
					              TrafficTesterView.convertToLaneDirection(i) +
					               " is empty");
			}
		}
        // Now all the incoming cars have been moved to outLanes
        // Iterate through the outgoing lanes, printing empty/nonempty
        for(int l=0; l<4; l++){
            if( outLane[l].isEmpty() ){
                System.out.println("  outgoing lane having direction " +
					              TrafficTesterView.convertToLaneDirection(l) +
					               " is empty");
            } else {
                System.out.println("  outgoing lane having direction " +
					              TrafficTesterView.convertToLaneDirection(l) +
                                  " is nonempty");
            }
        }
	}
}

