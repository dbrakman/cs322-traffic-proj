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

	//Looks at each lane in inLane and moves the car in that lane 
	//(if it has one) into the appropriate outLane spot
	public void visit(){
		for (int i = 0; i <= 3; i++){
			Car c = inLane[i].get();
			if (c != null){
				int dir = c.getCurrentDirection();
				if (i == 0){//North entry point
					if (dir == 0){//Straight
						outLane[2].add(c);
					}
					if (dir == 1){//right
						outLane[1].add(c);
					}    
					if (dir == -1){//left
						outLane[3].add(c);
					}
				}
				if (i == 1){//West entry point
					if (dir == 0){//Straight
						outLane[3].add(c);
					}
					if (dir == 1){//right
						outLane[2].add(c);
					}    
					if (dir == -1){//left
						outLane[0].add(c);
					}
				}
				if (i == 2){//South entry point
					if (dir == 0){//Straight
						outLane[0].add(c);
					}
					if (dir == 1){//right
						outLane[3].add(c);
					}    
					if (dir == -1){//left
						outLane[1].add(c);
					}
				}
				if (i == 3){//East entry point
					if (dir == 0){//Straight
						outLane[1].add(c);
					}
					if (dir == 1){//right
						outLane[0].add(c);
					}    
					if (dir == -1){//left
						outLane[2].add(c);
					}
				}
			}
		}
	}
}

