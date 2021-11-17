
public class Sannolikhet {

	public static void main(String[] args) {
		CardDeck deck = new CardDeck();
		Card kort;
		int ettTre = 0;
		int antal = 100000;
		for(int i = 0; i < 100000; i++) {
			while (deck.moreCards()) {
				
				kort = deck.getCard();
				System.out.println("ettTre = " + ettTre + " " + (ettTre%3 + 1));
				if (kort.getRank()%13 == 1 && ettTre%3 == 0) {
					System.out.println(kort);
					antal--;
					ettTre = 0;
					break;
				} else if (kort.getRank()%13 == 2 && ettTre%3 == 1) {
					System.out.println(kort);
					antal--;
					ettTre = 0;
					break;
				} else if (kort.getRank()%13 == 3 && ettTre%3 == 2) {
					System.out.println(kort);
					antal--;
					ettTre = 0;
					break;
				}
				
				ettTre++;
			}
			ettTre = 0;
			deck.shuffle();
		}
		System.out.println("antal: " + antal + " " + (float)(antal/100000.0));
	}

}
