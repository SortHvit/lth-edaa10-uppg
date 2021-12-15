import java.util.Random;

public class TestComplex {

	public static void main(String[] args) {
		//FIXA ABSOLUTVÄRDE HÄR
		Random rand = new Random();
		double re = rand.nextInt(10) + (double) rand.nextInt(101)/100;
		double im = rand.nextInt(10) + (double) rand.nextInt(101)/100;
		
		Complex comp1 = new Complex(re, im);
		System.out.println(re + " " + im);
		System.out.println("RE: " + comp1.getRe() + " IM: " + comp1.getIm());
		if(comp1.getRe() == re && comp1.getIm() == im) {
			System.out.println("KORREKT");
		} else {
			System.out.println("FEL");
		}
		
		re = rand.nextInt(20) + (double) rand.nextInt(101)/100;
		im = rand.nextInt(20) + (double) rand.nextInt(101)/100;
		Complex comp2 = new Complex(re, im);
		System.out.println(re + " " + im);
		System.out.println("RE: " + comp2.getRe() + " IM: " + comp2.getIm());
		if(comp2.getRe() == re && comp2.getIm() == im) {
			System.out.println("KORREKT");
		} else {
			System.out.println("FEL");
		}
		
		
		System.out.println("ABSOLUTVÄRDE: (" + comp1.getRe() + " + " + comp1.getIm() + ")^2 = " + comp1.getAbs2());
		System.out.println((comp1.getRe() + comp1.getIm())*(comp1.getRe() + comp1.getIm()));
		if(comp1.getAbs2() <= Math.pow(Math.abs(comp1.getRe() + comp1.getIm()), 2) + 0.0000001) {
			System.out.println("KORREKT");
		} else {
			System.out.println("FEL");
		}
		
		System.out.println("ABSOLUTVÄRDE: " + comp2.getRe()*comp2.getRe() + " + " + comp2.getIm()*comp2.getIm() + " = " + comp2.getAbs2());
		
		comp1.add(comp2);
		System.out.println("RE: " + comp1.getRe() + " IM: " + comp1.getIm());
		System.out.println("ABSOLUTVÄRDE: " + Math.pow(comp1.getRe(), 2) + " + " + Math.pow(comp1.getIm(), 2) + " = " + comp1.getAbs2());
		comp1.mul(comp2);
		System.out.println("MULTIPLIKATION COMPLEX(1*2): " + comp1.getRe() + " " + comp1.getIm());
		comp2.mul(comp2);
		System.out.println("MULTIPLIKATION COMPLEX(2*2): " + comp2.getRe() + " " + comp2.getIm());
		
	}

}
