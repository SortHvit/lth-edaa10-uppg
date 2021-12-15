import java.awt.Color;

public class Generator {
	public Generator() {
	}
	//ritar en bild
	public void render(MandelbrotGUI gui) {
		int indexI;
		int indexK;
		int resolution;
		double tempNum;
		switch(gui.getResolution()) {
		case 1 << 7:
			resolution = 9;
			System.out.println("VLOW");
			break;
			
		case 1 << 8:
			resolution = 7;
			System.out.println("LOW");
			break;
		
		case 1 << 9:
			resolution = 5;
			System.out.println("MED");
			break;
		
		case 1 << 10:
			resolution = 3;
			System.out.println("HIGH");
			break;
		
		case 1 << 11:
			resolution = 1;
			System.out.println("VHIGH");
			break;
			
		default:
			resolution = 5;
			break;
		}
		//cirkeln ser ut att ha fel position MEN är inte det, man kan se genom att zooma
		
		//SPARA CIRKEL FÖR EXTRA
		//mandelbrot: på [i][k] for 200 gånger
		//KÖR z.ABS2 + z | reellt tal^2 + (x + iy) | z = (reellt tal^2 + x)^2 + iy^2
		gui.disableInput();
		Complex[][] complex = mesh(gui.getMinimumReal(), gui.getMaximumReal(), gui.getMinimumImag(), gui.getMaximumImag(), gui.getWidth(), gui.getHeight());
		Color[][] picture = new Color[complex.length/resolution][complex[0].length/resolution];
		for(int i = 0; i < picture.length; i++) {
			for(int k = 0; k < picture[i].length; k++) {
				/** i*res ALLTID  MINUS resolution/2
				 * MEN OM i = 0 BLIR INDEX NEGATIV
				 * LÖSNING: i*res - RUNDAD(i/i+1)*res/2
				 * (i/i+1): 0/1 = 0, ANNARS t.ex 1/2 = 1 osv */
				indexI = i*resolution - (int) Math.round((double) i/(i+1))*(resolution/2);
				indexK = k*resolution - (int) Math.round((double) k/(k+1))*(resolution/2);
				
				picture[i][k] = Color.BLACK;
				
				//MANDELBROT:
				//KÖR MUL 200 - 1 GÅNGER
				//SKAPA TEMPORÄRT Z FÖR SATSEN, INDEX ÄR C
				Complex tempZ = new Complex(0, 0);
				for(int rep = 1; rep <= 200; rep++) {
					tempZ.mul(tempZ);
					tempZ.add(complex[indexI][indexK]);
					//nu är k = rep utfört
					if(Math.sqrt(tempZ.getAbs2()) > 2) {
						if(gui.getMode() == 1 << 6) {
							if (rep > 25) {
								picture[i][k] = Color.RED;
							} else if (rep > 10) {
								picture[i][k] = Color.BLUE;
							} else if (rep > 5) {
								picture[i][k] = Color.GREEN;
							} else if (rep > 2) {
								picture[i][k] = Color.YELLOW;
							} else {
								picture[i][k] = Color.WHITE;
							}
						} else {
							picture[i][k] = Color.WHITE;
						}
						break;
					}
				}
				
				/** CIRKELN
				if(complex[indexI][indexK].getAbs2() > 1) {
					picture[i][k] = Color.WHITE;
				} else if (complex[indexI][indexK].getRe() >= 0 && complex[indexI][indexK].getIm() >= 0) {
					picture[i][k] = Color.RED;
				} else if (complex[indexI][indexK].getRe() < 0 && complex[indexI][indexK].getIm() >= 0) {
					picture[i][k] = Color.BLUE;
				} else if (complex[indexI][indexK].getRe() < 0 && complex[indexI][indexK].getIm() < 0) {
					picture[i][k] = Color.GREEN;
				} else {
					picture[i][k] = Color.YELLOW;
				} */
			}
		}
		
		gui.putData(picture, resolution, resolution);
		gui.enableInput();
	}
	
	private Complex[][] mesh(double minRe, double maxRe, double minIm, double maxIm, int width, int height) {
		//klart?
		Complex[][] theMesh = new Complex[height][width];
		for(int i = 0; i < height; i++) {
			//låt [0] = maxIm = height & [height-1] = minIm = 0 | minIm < maxIm
			//[0] = 0 då [height-1] = minIm - maxIm -> [height-1] = -maxIm
			//maxIm = (height-1)*2 -> ((height-1)-i)*2
			//OM minIm++ -> maxIm-- -> höjd = maxIm-minIm
			//maxIm = höjd+minIm
			//maxIm - i*((maxIm-minIm)/(height-1))
			//MINSKNING: -i*((maxIm-minIm)/(height-1))
			for(int j = 0; j < width; j++) {
				//[0][0] = minRe, maxIm | [size-1][size-1] = maxRe, minIm
				//låt minRe = 0 & maxRe = width-1 -> [j] = j
				//maxRe = (width-1)*2 -> [j] = (j)*2
				//OM minRe++ -> maxRe-- -> bredd = maxRe - minRe
				//ÖKNING: j*((maxRe - minRe)/(width-1))
				theMesh[i][j] = new Complex(j*((maxRe-minRe)/(width-1)) + minRe, maxIm - i*((maxIm-minIm)/(height-1)));
				if(j%100 == 0 & i%10 == 0) {
					System.out.println("IMAGINÄRDEL: [" + i + "][" + j + "] = " + theMesh[i][j].getIm());
					System.out.println("REALDEL: [" + i + "][" + j + "] = " + theMesh[i][j].getRe());
				}
			}
		}
		return theMesh;
	}
}
