package start.ctci.ood;


class Cell {

	int row;
	int column;
	int number;
	boolean isExposed;
	boolean isGuess;
	boolean isBomb;
	
	boolean flip() {return false;}
	boolean toggleGuess() { return false;}
	
}

class UserPlay {
	int row;
	int column;
	boolean isGuess;
}

class UserPlayResult {
	boolean isSuccess;
}

class BoardM {
	int rows;
	int columns;
	int nBombs;
	int cellsRemaining;
	
	Cell[][] cells;
	Cell[][] bombs;
	
	void flipCell(Cell cell) {};
	void expandBlank() {}
	
	UserPlayResult playFlip(UserPlay play) {
		return null;	
	}
}

enum MState {
	Won, Lost, Running
}

public class Minesweeper {
	private BoardM board;
	int rows;
	int columns;
	int bombs;
	MState state;
	
	
	void initialise() {
		
	}
	
	void start() {}
	
	void playGame() {}
}
