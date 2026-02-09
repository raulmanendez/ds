package start.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringJoiner;

class TreeNodeWithNext {
	int value;
	TreeNodeWithNext left;
	TreeNodeWithNext right;
	TreeNodeWithNext next;

	TreeNodeWithNext(int value) {
		this.value = value;
	}
}

public class ConnectLevelOrderSiblings {

	static List<TreeNodeWithNext> connectSiblings(TreeNodeWithNext root) {
		List<TreeNodeWithNext> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<TreeNodeWithNext> q = new LinkedList<TreeNodeWithNext>();
		q.offer(root);

		while (!q.isEmpty()) {
			int levelSize = q.size();

			TreeNodeWithNext prev = null;
			for (int i = 0; i < levelSize; i++) {
				TreeNodeWithNext current = q.poll();
				
				if(prev==null)
					result.add(current);
				else
					prev.next = current;
				
				prev = current;

				if (current.left != null)
					q.offer(current.left);

				if (current.right != null)
					q.offer(current.right);
			}
		}
		
		return result;
	}
	
	static void withExtraSpace(TreeNodeWithNext root) {
		var results = connectSiblings(root);
		
		for(var node : results) {
			
			StringJoiner joiner = new StringJoiner(",");
			joiner.add(node.value+"");
			
			var current = node.next;
			while(current!=null) {
				joiner.add(current.value+"");
				current = current.next;
			}
			
			System.out.println(joiner);
			
		}
	}
	
	//giving wrong output 
	static void withoutExtraSpace(TreeNodeWithNext root) {
		connectSiblings(root);
		
		TreeNodeWithNext nextRoot = root;
		while(nextRoot!=null) {
			TreeNodeWithNext current = nextRoot;
			nextRoot=null;
			
			while(current!=null) {
				System.out.print(current.value+" ");
				
				if(nextRoot == null) {
					if(current.left!=null)
						nextRoot =current.left;
					if(current.right!=null)
						nextRoot =current.right;
				}
				
				current = current.next;
				System.out.println(current);
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		/*
		 * 12 1, 7 9, 10, 5 17, 20
		 */

		TreeNodeWithNext root = new TreeNodeWithNext(12);
		root.left = new TreeNodeWithNext(7);
		root.right = new TreeNodeWithNext(1);

		root.left.left = new TreeNodeWithNext(9);

		root.right.left = new TreeNodeWithNext(10);
		root.right.right = new TreeNodeWithNext(5);

		root.right.left.left = new TreeNodeWithNext(20);
		root.right.left.right = new TreeNodeWithNext(17);
		
		//withExtraSpace(root);
		
		withoutExtraSpace(root);
		
	}
}
