
public class Point {
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	public String toString() {
		return Integer.toString(x) + " " + Integer.toString(y);
	}
}
