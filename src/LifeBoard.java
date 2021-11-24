public class LifeBoard {
	
	private boolean[][] board;
	private int r, c;
	private int generation;

	/** Skapar en spelplan med rows rader och cols kolonner. Spelplanen är från
	    början tom, dvs alla rutorna är tomma och generationsnumret är 1. */	
	public LifeBoard(int rows, int cols) {
		r = rows;
		c = cols;
		board = new boolean[r][c];
		generation = 1;
	}

	/** Ger true om det finns en individ i rutan med index row, col, false annars. 
	    Om index row, col är utanför spelplanen returneras false */
	public boolean get(int row, int col) {
		if (r > row && row >= 0 && c > col && col >= 0) {
			return board[row][col];
		} else {
			return false;
		}
	}

	/** Lagrar värdet val i rutan med index row, col */
	public void put(int row, int col, boolean val) {
		board[row][col] = val;
	}

	/** Tar reda på antalet rader */
	public int getRows() {
		return board.length;
	}

 	/** Tar reda på antalet kolonner */
	public int getCols() {
		return board[0].length;
	}

	/** Tar reda på aktuellt generationsnummer */
	public int getGeneration() {
		return generation;
	}

	/** Ökar generationsnumret med ett */
	public void increaseGeneration() {
		generation++;
	}
}