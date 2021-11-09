

import se.lth.cs.p.inl1.nbr6.*;

public class Decryptographer {
	private int[] nummer = new int[5];
	Decryptographer(Key key) {
		for (int i = 0; i < 5; i++) {
			nummer[i] = (char) (26 - key.getNumber(i)%26);
		}
	}
	
	String decrypt(String text) {
		StringBuilder streng = new StringBuilder();
		int counter = 0;
		for (int i = 0; i < text.length(); i++) {
			System.out.println(nummer[counter%5] + "" + text.charAt(i) + "=" + ((text.charAt(i) + nummer[counter%5] - 'A')%26 + 1));
			if(text.charAt(i) == ' ') {
				streng.append(' ');
			} else {
				streng.append((char) (((text.charAt(i) - 'A' + nummer[counter%5])%26) + 'A'));
				counter++;
			}
			
			
			
			
			//(text.charAt(i) - 'A'+ key.getNumber(count++ % 5)) % 26 +'A'
			
			
		}
		return streng.toString();
	}
}
