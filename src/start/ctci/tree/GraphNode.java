package start.ctci.tree;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
	int value;
	int state;// -1 => unvisited, 0 => visiting, 1 => visited
	private List<GraphNode> adjacents=new ArrayList<>();

	public void unvisited() {
		this.state=-1;
	}

	public void visiting() {
		this.state=0;
	}

	public void visited() {
		this.state=1;
	}

	public boolean isVisited() {
		return this.state==1;
	}

	public List<GraphNode> getAdjacents() {
		return adjacents;
	}
}
