import java.util.Random;

public class CardDeck {
	private Card[] korten;
	private int counter = 52;
	
	CardDeck() {
		korten = new Card[52];
		for (int i = Card.SPADES - 1; i < Card.CLUBS; i++) {
			for (int j = 0; j < 13; j++) {
				korten[j + 13*i] = new Card(i+1, j+1);
			}
		}
	}
	
	void shuffle() {
		counter = 52;
		Random rand = new Random();
		Card tempKort;
		int nr;
		for (int i = 51; i > 0; i--) {
			nr = rand.nextInt(i);
			tempKort = korten[i];
			korten[i] = korten[nr];
			korten[nr] = tempKort;
		}
	}
	
	boolean moreCards() {
		if (counter > 0)
		{
			return true;
		} else {
			return false;
		}
	}
	
	Card getCard() {
		Card tempKort = new Card(korten[counter-1].getSuit(), korten[counter-1].getRank());
		counter--;
		return tempKort;
	}
}
