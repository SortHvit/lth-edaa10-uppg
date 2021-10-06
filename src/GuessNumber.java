import java.util.Scanner;

public class GuessNumber {
	public static void main(String[] args) {
		int numMin, numMax;
		int gissning;
		int counter = 0;
		boolean korrektSvar = false;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Skriv in [MIN] och [MAx] värde på talet du ska gissa dig till");
		numMin = scan.nextInt();
		numMax = scan.nextInt();
		
		NumberGenerator generator = new NumberGenerator(numMin, numMax);
		generator.drawNbr();
		
		while (!korrektSvar) {
			System.out.println("Gissa talet");
			
			gissning = scan.nextInt();
			counter++;
			
			if (generator.isEqual(gissning)) {
				korrektSvar = true;
				System.out.println("Rätt svar, totala gissningar " + counter);
			} else if (generator.isBiggerThan(gissning)) {
				System.out.println("Det hemliga talet är större än " + gissning);
			}
		}
	}
}
