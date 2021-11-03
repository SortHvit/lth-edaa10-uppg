import se.lth.cs.window.SimpleWindow;

public class Turtle {
	private double x,y;
	private SimpleWindow w;
	private boolean pen;
	private int alfa = 90;
  /** skapar en sk�ldpadda som ritar i ritf�nstret w. 
      Fr�n b�rjan befinner sig sk�ldpaddan i punkten xHome,yHome med pennan 
      lyft och huvudet pekande rakt upp�t i f�nstret, dvs i negativ y-riktning  
  */
  Turtle(SimpleWindow w, int xHome, int yHome) {
	  x = xHome;
	  y = yHome;
	  this.w = w;
	  pen = false;
  }

  /** s�nker pennan */
  void penDown() {
	  pen = true;
  }

  /** lyfter pennan */
  void penUp() {
	  pen = false;
  }

  /** g�r rakt fram�t n pixlar i huvudets riktning */
  void forward(int n) {
	  //uppdaterar position i f�nstret
	  w.moveTo((int) Math.round(x), (int) Math.round(y));
	  //g�r till ny position - sk�ldpaddan
	  x = x + n*Math.cos(alfa*Math.PI/180);
	  y = y - n*Math.sin(alfa*Math.PI/180);
	  //uppdaterar position i f�nstret med linje om penna �r nere
	  if (pen) {
		  w.lineTo((int) Math.round(x), (int) Math.round(y));
	  }
  }

  /** vrider huvudet beta grader �t v�nster */
  void left(int beta) {
	  alfa += beta;
  }

  /** vrider hvudet beta grader �t h�ger */
  void right(int beta) {
	  alfa -= beta;
  }

  /** g�r till punkten newX,newY utan att rita. 
      Pennans l�ge och huvudets riktning p�verkas inte */
  void jumpTo(int newX, int newY) {
	  x = newX;
	  y = newY;
  }

  /** �terst�ller huvudets riktning till den ursprungliga */
  void turnNorth() {
	  alfa = 90;
  }

  /** tar reda p� sk�ldpaddans aktuella x-koordinat */
  int getX() {
	  return (int) Math.round(x);
  }

  /** tar reda p� sk�ldpaddans aktuella y-koordinat */
  int getY() {
	  return (int) Math.round(y);
  }
}
