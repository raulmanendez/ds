package start.array.recurse;

import java.util.ArrayList;
import java.util.LinkedList;
import start.ctci.tree.BinaryTree;
import start.ctci.tree.TreeFromSortedArray;
import start.ctci.tree.TreeNode;

public class Weaving {

	public static ArrayList<LinkedList<Integer>> allSequence(TreeNode node) {
		ArrayList<LinkedList<Integer>> result=new ArrayList<LinkedList<Integer>>();
		
		if(node==null) {
			result.add(new LinkedList<Integer>());
			return result;
		}
		
		LinkedList<Integer> prefix=new LinkedList<Integer>();
		prefix.add(node.getData());
		
		ArrayList<LinkedList<Integer>> leftSeq=allSequence(node.getLeft());
		ArrayList<LinkedList<Integer>> rightSeq=allSequence(node.getRight());
		
		System.out.println("leftSeq::"+leftSeq);
		System.out.println("rightSeq::"+rightSeq);
		
		for(LinkedList<Integer> left:leftSeq) {
			for(LinkedList<Integer> right:rightSeq) {
				ArrayList<LinkedList<Integer>>weaved=new ArrayList<LinkedList<Integer>>();
				weave(left, right, weaved, prefix);
				result.addAll(weaved);
			}
		}
		
		return result;
	}
	
	private static void weave(LinkedList<Integer> list1,LinkedList<Integer> list2,ArrayList<LinkedList<Integer>> results,LinkedList<Integer> prefix) {
	
		if(list1.isEmpty() || list2.isEmpty()) {
			LinkedList<Integer> result=(LinkedList<Integer>) prefix.clone();
			result.addAll(list1);
			result.addAll(list2);
			results.add(result);
			
			return;
		}
		
		int firstHead=list1.removeFirst();
		prefix.addLast(firstHead);
		weave(list1, list2, results, prefix);
		prefix.removeLast();
		list1.addFirst(firstHead);
		
		int secondHead=list2.removeFirst();
		prefix.addLast(secondHead);
		weave(list1, list2, results, prefix);
		prefix.removeLast();
		list2.addFirst(secondHead);
	}
	
	public static void testWeaving() {
		LinkedList<Integer> list1=new LinkedList<>();
		list1.add(1);
		list1.add(2);
		
		LinkedList<Integer> list2=new LinkedList<>();
		//list2.add(2);
		list2.add(3);
		list2.add(4);
		//list2.add(5);
		
		LinkedList<Integer> resultInner=new LinkedList<>();
		ArrayList<LinkedList<Integer>> result=new ArrayList<>();
		result.add(resultInner);
		
		weave(list1, list2, result, new LinkedList<>());
		
		System.out.println("result::"+result);
	}
	
	public static void main(String[] args) {
		//testWeaving();
		
		BinaryTree tree=TreeFromSortedArray.formBt(new int[] {1,2,3,4,5,6,7});
		
		System.out.println("result::"+allSequence(tree.getRoot()));
	}
}
