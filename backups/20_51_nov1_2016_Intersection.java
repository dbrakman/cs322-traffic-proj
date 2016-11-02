public class Intersection{
	public Lane[] inLane;
	public Lane[] outLane;

	public Intersection(Lane[] inLanes, Lane[]outLanes){
		this.inLane = inLanes;
		this.outLane = outLanes;
	}

	public void visit(){
		for (int i = 0; i <= 3; i++){
			Car c = inLane[i].get();
			if (c != null){
				int dir = c.getCurrentDirection();
				/*if (dir == 0){//straight
					outLane[i + 2].add(c);
				}
				if (dir == 1){//right
					outLane[i + 1].add(c);
				}
				if (dir == -1){
					outLane[i +]
				}*/
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

//1 = right
//straight = 0
//left = -1