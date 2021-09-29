import se.lth.cs.window.SimpleWindow;
import se.lth.cs.p.ovn.turtle.Turtle;

public class D4_5 {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600,600,"Square");
		Turtle t = new Turtle(w,100,200);
		t.penDown();
		
		while (true) {
			w.waitForMouseClick();
			t.jumpTo(w.getMouseX(), w.getMouseY());
			for (int k=1; k<=4; k++) {
				t.right(90);
				t.forward(300);
			}
		}
	}
}