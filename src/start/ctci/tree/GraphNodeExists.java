package start.ctci.tree;

import java.util.LinkedList;
import java.util.Queue;

public class GraphNodeExists {
	GraphUtil gutil=new GraphUtil();
	
	public boolean pathExists(Graph g,GraphNode start,GraphNode end) {
		if(start == end) return true;
		
		StringBuilder builder=new StringBuilder();
		Queue<GraphNode> q=new LinkedList<>();
		//mark all nodes as unvisited
		gutil.unvisited(g);
		
		q.add(start);
		while(!q.isEmpty()) {
			GraphNode removed=q.remove();
			
			for(GraphNode gnode:removed.getAdjacents()) {
				if(!gnode.isVisited()) {
					builder.append(gnode.value+",");
					if(gnode==end) {
						System.out.println("Path followed : "+builder);
						return true;
					}
					gnode.visited();
					q.add(gnode);
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Graph g=GraphUtil.create();
		
		GraphUtil.print(g);;
		
		GraphNode start=g.getNodes().get(0);
		GraphNode end=g.getNodes().get(3);
		
		boolean exists=new GraphNodeExists().pathExists(g, start, end);
		
		System.out.println(exists ? "Path exists!!" : "No path found!");
		
	}
}
