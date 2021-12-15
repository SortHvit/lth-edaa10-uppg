
public class Complex {
	private double re, im;
	/** Skapar en komplex variabel med realdelen re och imaginärdelen im */
	Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	/** Tar reda på realdelen */
	double getRe() {
		return re;
	}
	/** Tar reda på imaginärdelen */
	double getIm() {
		return im;
	}
	/** Tar reda på talets absolutbelopp i kvadrat */
	double getAbs2() {
		return re*re + im*im;
	}
	/** Adderar det komplexa talet c till detta tal */
	void add(Complex c) {
		re += c.getRe();
		im += c.getIm();
	}
	/** Multiplicerar detta tal med det komplexa talet c */
	void mul(Complex c) {
		//(x1 + y1i)(x2 + y2i) = x1x2 + x1y2i + x2y1i - y1y2
		double tempRe = re;
		double tempReC = c.getRe();
		re = re*c.getRe() - im*c.getIm();
		im = tempRe*c.getIm() + tempReC*im;
	}
}
