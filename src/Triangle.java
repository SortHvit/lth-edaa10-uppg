import se.lth.cs.window.SimpleWindow;

public class Triangle extends Shape {
	private int side;
	public Triangle(int x, int y, int side) {
		super(x, y);
		this.side = side;
	}
	
	@Override
	public void draw(SimpleWindow w) {
		
		double deg = 45;
		double rad = Math.toRadians(deg);
		int detail = 4;
		//(x, y) är triangelns mitt
		//y:s längd är (side/2)^2 + y^2 = side^2 | längd = ROOT(3)side/2
		int length = (int) Math.round((Math.sqrt(3)*side)/2);
		w.moveTo(x, y - length/2);
		w.lineTo(x + side/2, y + length/2);
		w.lineTo(x - side/2, y + length/2);
		w.lineTo(x, y - length/2);
		
		
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
		return side;
	}
}
