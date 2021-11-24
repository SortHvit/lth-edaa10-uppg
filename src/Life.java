
public class Life {
	private LifeBoard board;
	
	Life(LifeBoard board) {
		this.board = board;
	}
	
	void newGeneration() {
		boolean[][] tempBoard = new boolean[board.getRows()][board.getCols()];
		int tempNum;
		board.increaseGeneration();
		for(int i = 0; i < tempBoard.length; i++) {
			for(int j = 0; j < tempBoard[0].length; j++) {
				//tempNum, annars kollar den 2 gånger
				tempNum = getNeighbours(board, i, j);
				if(board.get(i, j)) {
					tempBoard[i][j] = (tempNum == 2 || tempNum == 3);
				} else {
					tempBoard[i][j] = (tempNum == 3);
				}
			}
		}
		for(int i = 0; i < tempBoard.length; i++) {
			for(int j = 0; j < tempBoard[0].length; j++) {
				board.put(i, j, tempBoard[i][j]);
			}
		}
		
	}
	
	void flip(int row, int col) {
		if(board.get(row, col)) {
			board.put(row, col, false);
		} else {
			board.put(row, col, true);
		}
	}
	
	private int getNeighbours(LifeBoard board, int row, int col) {
		int num = 0;
		int i, j;
		System.out.println("\n\nINDEX" + row + ", " + col);
		
		for(i = (row - 1); i <= (row + 1); i++) {
			System.out.println("\n" + i);
			System.out.print("col ");
			for(j = (col - 1); j <= (col + 1); j++) {
				if (board.get(i, j)) {
					num++;
					System.out.print(j + ": " + 1 + " | ");
				} else {
					System.out.print(j + ": " + 0 + " | ");
				}
			}
		}
		System.out.println("\nneighbor: " + (num - 1));
		if(board.get(row, col)) {
			return num - 1;
		} else {
			return num;
		}
	}
}
