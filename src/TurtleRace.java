

import se.lth.cs.window.SimpleWindow;

public class TurtleRace {

	public static void main(String[] args) {
		int trackStart = 50;
		int trackFinish = 500;
		SimpleWindow w = new SimpleWindow(300,600,"rejsfönster");
		RaceTrack rejs = new RaceTrack(trackStart, trackFinish);
		rejs.draw(w);
		
		Turtle t1 = new Turtle(w, 75, trackStart);
		Turtle t2 = new Turtle(w, 125, trackStart);
		t1.penDown();
		t2.penDown();
		RacingEvent rejset = new RacingEvent(rejs, t1, t2);
		rejset.setDirection();
		do {
			System.out.println(t1.getY() + " " + t2.getY() + " " + rejs.getFinish());
			w.delay(10);
		} while(rejset.compete());
		System.out.println(t1.getY() + " " + t2.getY() + " " + rejs.getFinish());
		
		System.out.println("lol");
	}

}
