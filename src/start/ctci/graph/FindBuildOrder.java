package start.ctci.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class FindBuildOrder {

	//using DFS
	public Stack<Project> findBuildOrderStack(String projects[],String dependencies[][]) {
		ProjectGraph graph=buildGraph(projects, dependencies);
		return orderProjectsStack(graph.getNodes());
	}

	private Stack<Project> orderProjectsStack(ArrayList<Project> projects) {
		Stack<Project> stack=new Stack<>();

		for(Project project:projects) {
			if(project.state==Project.State.BLANK)
				if(!doDFS(project, stack))
					return null;
		}

		return stack;
	}

	public boolean doDFS(Project project,Stack<Project> stack) {
		if(project.state==Project.State.PARTIAL) return false;

		if(project.state==Project.State.BLANK) {
			project.state=Project.State.PARTIAL;

			ArrayList<Project> children=project.getChildren();
			for(Project child:children) {
				if(!doDFS(child, stack)) {
					return false;
				}
			}

			project.state=Project.State.COMPLETE;
			stack.push(project);
		}


		return true;
	}

	//using DFS

	public Project[] findBuildOrder(String projects[],String dependencies[][]) {
		ProjectGraph graph=buildGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
	}


	private ProjectGraph buildGraph(String projects[],String dependencies[][]) {
		ProjectGraph graph=new ProjectGraph();

		for(String project:projects) {
			graph.getOrCreateNode(project);
		}

		for(String dependency[]:dependencies) {
			String a=dependency[0];
			String b=dependency[1];

			graph.addEdge(a, b);
		}

		return graph;
	}

	private Project[] orderProjects(ArrayList<Project> projects) {
		Project[] order=new Project[projects.size()];

		int endOfList=addNonDependent(order, projects, 0);

		int toBeProcessed=0;
		while(toBeProcessed < order.length) {
			Project current=order[toBeProcessed];

			if(current==null) return null;

			ArrayList<Project> children=current.getChildren();
			for(Project child:children) {
				child.decrementDependencies();
			}

			endOfList=addNonDependent(order, children, endOfList);

			toBeProcessed++;
		}

		return order;
	}

	private int addNonDependent(Project order[],ArrayList<Project> projects,int offset) {
		for(Project project:projects) {
			if(project.getDependencies()==0) {
				order[offset]=project;
				offset++;
			}
		}

		return offset;
	}
}


class Project {
	public enum State { BLANK,PARTIAL,COMPLETE }
	HashMap<String, Project> map=new HashMap<>();
	ArrayList<Project> children=new ArrayList<>();
	String name;
	int dependencies=0;

	State state=State.BLANK;

	public State getState() {
		return state;
	}

	public void setState(State t) {
		state=t;
	}

	public Project(String name) {
		this.name=name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDependencies() {
		return dependencies;
	}

	public ArrayList<Project> getChildren() {
		return children;
	}

	public void incrementDependencies() {
		this.dependencies++;
	}

	public void decrementDependencies() {
		this.dependencies--;
	}

	public void addNeighbor(Project node) {
		if(!map.containsKey(node.name)) {
			children.add(node);
			map.put(node.name, node);
			node.incrementDependencies();
		}
	}

}

class ProjectGraph {

	HashMap<String, Project> map=new HashMap<>();
	ArrayList<Project> projects=new ArrayList<>();

	public ArrayList<Project> getNodes() {
		return projects;
	}

	public Project getOrCreateNode(String name) {
		if(!map.containsKey(name)) {
			Project project=new Project(name);
			projects.add(project);
			map.put(name, project);
		}

		return map.get(name);
	}

	public void addEdge(String start,String end) {
		Project main=getOrCreateNode(start);
		Project dependent=getOrCreateNode(end);

		main.addNeighbor(dependent);
	}


}
