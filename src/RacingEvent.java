

import se.lth.cs.window.SimpleWindow;
import java.util.Random;

public class RacingEvent {
	private RaceTrack track;
	private Turtle t1, t2;
	private int direction;
	Random rand = new Random();
	
	RacingEvent(RaceTrack track, Turtle t1, Turtle t2) {
		this.track = track;
		this.t1 = t1;
		this.t2 = t2;
	}
	
	void setDirection() {
		if (track.getStart() > track.getFinish()) {
			direction = 1;
		} else {
			direction = -1;
		}
	}
	
	boolean compete() {
		if (t1.getY() < track.getFinish() && t2.getY() < track.getFinish()){
			t1.forward(rand.nextInt(3)*direction);
			t2.forward(rand.nextInt(3)*direction);
			return t1.getY() < track.getFinish() && t2.getY() < track.getFinish();
		}
		else if (t1.getY() > track.getFinish() && t2.getY() > track.getFinish()){
			t1.forward(rand.nextInt(3)*direction);
			t2.forward(rand.nextInt(3)*direction);
			System.out.println(t1.getY() + " " + t2.getY() + " " + track.getFinish());
			return t1.getY() > track.getFinish() && t2.getY() > track.getFinish();
		}
		else {
			return false;
		}
	}
}
