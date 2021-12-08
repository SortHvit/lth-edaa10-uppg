import se.lth.cs.window.SimpleWindow;

public class Circle extends Shape {
	private int radius;
	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}
	
	@Override
	public void draw(SimpleWindow w) {
		/* behöver vinkel
		 * (1, 0) -> (0,75², 0,25²) -> (0,5², 0,5²) -> ... -> (-(0,5²), 0,5²) -> ...
		 * (x, y) är cirkelns mitt
		 */
		double deg = 0;
		double rad = Math.toRadians(deg);
		int detail = 16;
		
		w.moveTo(x + (int) Math.round(radius*Math.cos(rad)), y + (int) Math.round(radius*Math.sin(rad)));
		for(int i = 0; i < detail; i++) {
			deg += (double) 360/detail;
			rad = Math.toRadians(deg);
			
			w.lineTo(x + (int) Math.round(radius*Math.cos(rad)), y + (int) Math.round(radius*Math.sin(rad)));
			System.out.println(deg);
		}
		
		
		//för att visa near
		deg = 45;
		detail = 4;
		w.moveTo(x + 10, y + 10);
		for(int i = 0; i < detail; i++) {
			deg += (double) 360/detail;
			rad = Math.toRadians(deg);
			
			w.lineTo(x + (int) Math.round(20*(Math.cos(rad)/Math.sqrt(2))), y + (int) Math.round(20*(Math.sin(rad)/Math.sqrt(2))));
			System.out.println("kvadrat: " + deg);
		}
	}
	
	@Override
	public int getSide() {
		return radius;
	}
}
