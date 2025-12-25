package start.ctci.ood;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

enum Orientation {
	LEFT, TOP, RIGHT, BOTTOM;

	Orientation getOpposite() {
		switch (this) {
		case LEFT:
			return RIGHT;
		case RIGHT:
			return LEFT;
		case TOP:
			return BOTTOM;
		case BOTTOM:
			return TOP;
		default:
			return null;
		}
	}
}

enum Shape {
	INNER, OUTER, FLAT;

	Shape getOpposite() {
		switch (this) {
		case INNER:
			return OUTER;
		case OUTER:
			return INNER;
		default:
			return null;
		}
	}
}

class Edge {
	Shape shape;
	Piece parentPiece;
	
	boolean fitsWith(Edge edge) {
		return false;
	}
	
}

class Piece {
	Map<Orientation, Edge> edges = new HashMap<>();
	
	public Piece(Edge[] edges) {}
	
	
	void rotateEdgesBy(int num) {}
	
	boolean isCorner() { return false ;}
	boolean isBorder() { return false ;}
}

public class Jigsaw {
	LinkedList<Piece> pieces =new LinkedList<>();
	Piece[][] solution;
	int size;
	
	
	boolean fitNextEdge() {
		return false;
	}
	
	
	boolean solve() {
		return false;
	}
}
