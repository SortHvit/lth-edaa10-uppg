

import se.lth.cs.window.SimpleWindow;

public class RaceTrack {
	private int y1, y2;
	RaceTrack(int yStart, int yFinish) {
		y1 = yStart;
		y2 = yFinish;
	}
	
	void draw(SimpleWindow w) {
		//start - grön
		w.moveTo(50, y1);
		w.lineTo(150, y1);
		
		//slut - röd
		w.moveTo(50, y2);
		w.lineTo(150, y2);
		
		//pil mot slutets riktning, för tydlighet
		w.moveTo(175, y1);
		w.lineTo(200, y2);
		w.lineTo(225, y1);
		w.lineTo(175, y1);
	}
	
	int getStart() {
		return y1;
	}
	
	int getFinish() {
		return y2;
	}
}
