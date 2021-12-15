public class Mandelbrot {

	public static void main(String[] args) {
		MandelbrotGUI mandelbrot = new MandelbrotGUI();
		Generator generator = new Generator();
		boolean zoomRender = false;
		while(true) {
		switch(mandelbrot.getCommand()) {
			case 1 << 0:
				System.out.println(1 << 0);
				System.out.println("RENDER");
				generator.render(mandelbrot);
				zoomRender = true;
				break;
			
			case 1 << 1:
				System.out.println(1 << 1);
				System.out.println("ZOOM");
				if(zoomRender) {
					generator.render(mandelbrot);
				}
				break;
			
			case 1 << 3:
				System.out.println(1 << 3);
				System.out.println("RESET");
				mandelbrot.resetPlane();
				mandelbrot.clearPlane();
				zoomRender = false;
				break;
			
			case 1 << 4:
				System.out.println(1 << 4);
				System.out.println("QUIT");
				System.exit(0);
				break;
			/**
			case 1 << 5:
				System.out.println(1 << 5);
				System.out.println("BW");
				break;
			
			case 1 << 6:
				System.out.println("COLOR");
				break;
				*/
			}
		}
	}

}
