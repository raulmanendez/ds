package start.ctci.tree;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<GraphNode> nodes=new ArrayList<>();

	public void addVertex(int value) {
		GraphNode node=new GraphNode();
		node.value=value;

		nodes.add(node);
	}

	public void addEdge(int source,int destination) {
		GraphNode attachTo=find(source);
		GraphNode attachMe=find(destination);

		if(attachTo!=null && attachMe!=null) {
			attachTo.getAdjacents().add(attachMe);
			attachMe.getAdjacents().add(attachTo);
		}
	}

	private GraphNode find(int value) {
		return nodes.stream().filter(node -> node.value==value).findFirst().orElse(null);
	}

	public List<GraphNode> getNodes() {
		return nodes;
	}

	public static void main(String[] args) {

	}

}
