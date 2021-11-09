

import se.lth.cs.p.inl1.*;
import se.lth.cs.p.inl1.nbr6.*;


public class InlChiffer {

	public static void main(String[] args) {
		Key nyckel = new Key();
		TestCase texter = new TestCase();
		Decryptographer dekrypt = new Decryptographer(nyckel);
		
		
		
		TextWindow fonsterChfr = new TextWindow("capussi");
		TextView fonsterTextChfr = new TextView("Chiffer", 10, 30);
		fonsterChfr.addView(fonsterTextChfr);
		fonsterTextChfr.displayText(texter.getCryptoText(1));
		
		TextWindow fonsterMinT = new TextWindow("capussi");
		TextView fonsterTextMinT = new TextView("Min klartext", 10, 30);
		fonsterMinT.addView(fonsterTextMinT);
		fonsterTextMinT.displayText(dekrypt.decrypt(texter.getCryptoText(1)));
		
		TextWindow fonsterKlar = new TextWindow("capussi");
		TextView fonsterTextKlar = new TextView("Korrekt klartext", 10, 30);
		fonsterKlar.addView(fonsterTextKlar);
		fonsterTextKlar.displayText(texter.getClearText(1));
		
		for(int i = 2; i < 6; i++) {
			fonsterChfr.waitForMouseClick();
			fonsterTextChfr.displayText(texter.getCryptoText(i));
			fonsterTextMinT.displayText(dekrypt.decrypt(texter.getCryptoText(i)));
			fonsterTextKlar.displayText(texter.getClearText(i));
		}
	}
}
