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
			}
		}
	}
}