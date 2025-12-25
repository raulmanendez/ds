package start.ctci.ood;

enum Direction {
	left, right, up, down
}

enum Color {
	Black, White
}

class Player {
	Color color;

	int getScore() {
		return 0;
	}

	boolean playPiece() {
		return false;
	}

	Player(Color c) {
		this.color = c;
	}

}

class PieceO {
	Color color;

	void flip() {
		if (Color.Black.equals(color))
			color = Color.White;
		else
			color = Color.Black;
	}
}

class Board {
	int bCount = 0;
	int wCount = 0;

	PieceO[][] board;

	public Board(int rows, int columns) {
		board = new PieceO[rows][columns];
	}

	boolean placeColor(int row, int column, Color color) {
		return false;
	}

	public int getScoreFor(Color c) {
		return 0;
	}

}

public class Othello {

	Player[] players;
	private static Othello instance;
	Board board;
	int rows = 10;
	int columns = 10;

	private Othello() {
		board = new Board(rows, columns);

		players = new Player[2];
		players[0] = new Player(Color.White);
		players[1] = new Player(Color.Black);
	}

	static Othello getInstance() {
		if (instance == null)
			instance = new Othello();
		return instance;
	}

}
