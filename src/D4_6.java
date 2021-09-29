import se.lth.cs.window.SimpleWindow;
import se.lth.cs.p.ovn.turtle.Turtle;
import java.util.Random;

public class D4_6 {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600,600,"Square");
		Turtle t1 = new Turtle(w,250,250);
		Turtle t2 = new Turtle(w,350,350);
		Random rand = new Random();
		int distX = 0;
		int distY = 0;
		t1.penDown();
		t2.penDown();
		
		do {
			t1.forward(rand.nextInt(10) + 1);
			t1.right(rand.nextInt(360) - 179);
			
			t2.forward(rand.nextInt(10) + 1);
			t2.right(rand.nextInt(360) - 179);
			
			SimpleWindow.delay(10);
			
			distX = t1.getX() - t2.getX();
			distY = t1.getY() - t2.getY();
		} while (Math.hypot(distX, distY) >= 50);
		System.out.println("klart");
	}
}