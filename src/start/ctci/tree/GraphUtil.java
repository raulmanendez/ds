package start.ctci.tree;

import java.util.LinkedList;

public class GraphUtil {

	public static void main(String[] args) {
		GraphUtil gutil=new GraphUtil();
		Graph g=GraphUtil.create();
		GraphUtil.print(g);

		gutil.dfs(g, 0);
		gutil.unvisited(g);
		gutil.bfs(g, 0);
	}

	public void bfs(Graph g,int startIndex) {
		StringBuilder builder=new StringBuilder();

		GraphNode start=g.getNodes().get(startIndex);

		LinkedList<GraphNode> ll=new LinkedList<>();
		ll.addLast(start);

		while(!ll.isEmpty()) {
			GraphNode removed=ll.removeFirst();
			removed.visited();
			builder.append(removed.value+"\t");

			for(GraphNode adj:removed.getAdjacents()) {
				if(!adj.isVisited())
					ll.addLast(adj);
			}
		}

		System.out.println("Breadth first: "+builder);
	}

	public void dfs(Graph g,int startIndex) {
		StringBuilder builder=new StringBuilder();

		GraphNode start=g.getNodes().get(startIndex);

		dfsrec(start, builder);

		System.out.println("Depth first: "+builder);
	}

	private void dfsrec(GraphNode node,StringBuilder builder) {
		if(node.isVisited()) return;

		node.visited();
		builder.append(node.value+"\t");

		for(GraphNode adj:node.getAdjacents()) {
			dfsrec(adj,builder);
		}

	}

	public void unvisited(Graph g) {
		for(GraphNode node:g.getNodes()) {
			node.unvisited();
		}
	}

	public static void print(Graph g) {
		StringBuilder builder=new StringBuilder();
		for(GraphNode node:g.getNodes()) {
			builder.append(node.value+" -> ");

			for(GraphNode adj:node.getAdjacents()) {
				builder.append(adj.value+",");
			}

			builder.append("\n");
		}

		System.out.println(builder);
	}

	public static Graph create() {
		Graph graph=new Graph();

		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addVertex(6);
		graph.addVertex(7);
		graph.addVertex(8);
		graph.addVertex(9);
		graph.addVertex(10);

		graph.addEdge(1, 2);
		graph.addEdge(1, 9);

		graph.addEdge(2, 6);
		graph.addEdge(2, 5);
		graph.addEdge(2, 3);

		graph.addEdge(3, 4);
		graph.addEdge(3, 7);

		graph.addEdge(6, 8);
		graph.addEdge(6, 11);

		graph.addEdge(8, 10);

		return graph;
	}
}
