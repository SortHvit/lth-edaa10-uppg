
public class LifeController {
	public static void main(String[] args) {
		int row = 15;
		int col = 15;
		LifeBoard board = new LifeBoard(row, col);
		LifeView window = new LifeView(board);
		Life game = new Life(board);
		window.drawBoard();
		
		board.put(0, 0, true);
		board.put(1, 1, false);
		board.put(2, 2, true);
		if (board.get(0, 0) && !board.get(1, 1) && !board.get(-1, -1) && !board.get(3, 3)) {
			System.out.println("put och get ok");
		} else {
			System.out.println("Fel vid anrop av put eller get");
		}
		window.update();
		
		/* board.increaseGeneration();
		if (board.getGeneration() == 2) {
			System.out.println("getGeneration ok");
		} else {
			System.out.println("Fel vid anrop av getGeneration");
		} */
		while (true) {	
			switch (window.getCommand()) {
			
				case 1:
					game.flip(window.getRow(), window.getCol());
					window.update();
					break;
			
				case 2:
					game.newGeneration();
					window.update();
					break;
			
				case 3:
					System.exit(0);
					break;
			}
		}
	}
}
