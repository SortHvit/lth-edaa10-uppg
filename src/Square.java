import se.lth.cs.window.SimpleWindow;

public class Square extends Shape {
	private int side;
	public Square(int x, int y, int side) {
		super(x, y);
		this.side = side;
	}
	
	@Override
	public void draw(SimpleWindow w) {
		//(x, y) är kvadratens mitt
		double deg = 45;
		double rad = Math.toRadians(deg);
		int detail = 4;
		//gör storleken jämn på sidorna
		int tempSide = side - side%2;
		//sida * cos(45) = sida/(ROOT2)
		//vi vill att: sida/2
		w.moveTo(x + (int) Math.round(tempSide*(Math.cos(rad)/Math.sqrt(2))), y + (int) Math.round(tempSide*(Math.sin(rad)/Math.sqrt(2))));
		for(int i = 0; i < detail; i++) {
			deg += (double) 360/detail;
			rad = Math.toRadians(deg);
			
			w.lineTo(x + (int) Math.round(tempSide*(Math.cos(rad)/Math.sqrt(2))), y + (int) Math.round(tempSide*(Math.sin(rad)/Math.sqrt(2))));
			System.out.println(deg);
		}
		
		
		//för att visa near
		deg = 45;
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
