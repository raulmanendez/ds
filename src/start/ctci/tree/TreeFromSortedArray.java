package start.ctci.tree;

public class TreeFromSortedArray {

	public static BinaryTree formBt(int arr[]) {
		BinaryTree tree=new BinaryTree();
		return formTree(arr, 0, arr.length-1,tree);
	}
	
	private static BinaryTree formTree(int arr[],int start,int end,BinaryTree tree) {
		int mid=(start + end)/2;
		tree.add(arr[mid]);
		
		if(start < mid) formTree(arr, start, mid-1,tree);
		if(end > mid) formTree(arr, mid+1, end,tree);
		
		return tree;
	}
	
	public static void main(String[] args) {
		BinaryTree bt=formBt(new int[] { 1,2,3,4,5,6,7,8,9,10 });
		
		System.out.println(bt.inOrder());
		
	}
}
