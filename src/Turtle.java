import se.lth.cs.window.SimpleWindow;

public class Turtle {
	private double x,y;
	private SimpleWindow w;
	private boolean pen;
	private int alfa = 90;
  /** skapar en sköldpadda som ritar i ritfönstret w. 
      Från början befinner sig sköldpaddan i punkten xHome,yHome med pennan 
      lyft och huvudet pekande rakt uppåt i fönstret, dvs i negativ y-riktning  
  */
  Turtle(SimpleWindow w, int xHome, int yHome) {
	  x = xHome;
	  y = yHome;
	  this.w = w;
	  pen = false;
  }

  /** sänker pennan */
  void penDown() {
	  pen = true;
  }

  /** lyfter pennan */
  void penUp() {
	  pen = false;
  }

  /** går rakt framåt n pixlar i huvudets riktning */
  void forward(int n) {
	  //uppdaterar position i fönstret
	  w.moveTo((int) Math.round(x), (int) Math.round(y));
	  //går till ny position - sköldpaddan
	  x = x + n*Math.cos(alfa*Math.PI/180);
	  y = y - n*Math.sin(alfa*Math.PI/180);
	  //uppdaterar position i fönstret med linje om penna är nere
	  if (pen) {
		  w.lineTo((int) Math.round(x), (int) Math.round(y));
	  }
  }

  /** vrider huvudet beta grader åt vänster */
  void left(int beta) {
	  alfa += beta;
  }

  /** vrider hvudet beta grader åt höger */
  void right(int beta) {
	  alfa -= beta;
  }

  /** går till punkten newX,newY utan att rita. 
      Pennans läge och huvudets riktning påverkas inte */
  void jumpTo(int newX, int newY) {
	  x = newX;
	  y = newY;
  }

  /** återställer huvudets riktning till den ursprungliga */
  void turnNorth() {
	  alfa = 90;
  }

  /** tar reda på sköldpaddans aktuella x-koordinat */
  int getX() {
	  return (int) Math.round(x);
  }

  /** tar reda på sköldpaddans aktuella y-koordinat */
  int getY() {
	  return (int) Math.round(y);
  }
}
