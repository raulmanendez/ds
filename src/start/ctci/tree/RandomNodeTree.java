package start.ctci.tree;

import java.util.Random;

public class RandomNodeTree {

	private int data;
	private RandomNodeTree left;
	private RandomNodeTree right;
	private int size=0;

	public RandomNodeTree(int d) {
		data=d;
		size=1;
	}

	public RandomNodeTree getRandomNode() {
		int leftSize=left==null ? 0 : left.getSize();

		Random random=new Random();
		int index=random.nextInt(size);

		if(index < size) {
			return left.getRandomNode();
		} else if(index==leftSize) {
			return this;
		} else {
			return right.getRandomNode();
		}
	}

	public RandomNodeTree getRandomNodeV1() {
		int leftSize=left==null ? 0 : left.getSize();

		Random random=new Random();
		int index=random.nextInt(size);

		if(index < size) {
			return left.getRandomNode();
		} else if(index==leftSize) {
			return this;
		} else {
			return right.getRandomNode();
		}
	}

	public RandomNodeTree getithNode(int i) {
		int leftSize=left==null ? 0 : left.getSize();

		if(i < size) {
			return left.getithNode(i);
		} else if(i==leftSize) {
			return this;
		} else {
			//skip left + 1
			return right.getithNode(i - (leftSize + 1));
		}
	}

	public void addInOrder(int d) {
		if(d <= data) {
			if(left==null) {
				left=new RandomNodeTree(d);
			} else {
				left.addInOrder(d);
			}
		} else {
			if(right==null) {
				right=new RandomNodeTree(d);
			} else {
				right.addInOrder(d);
			}
		}

		size++;
	}

	public int getSize() { return size; }
	public int getData() { return data; }

	public RandomNodeTree find(int d) {
		if(data==d) return this;

		if(d <= data) {
			return left!=null ? left.find(d) : null;
		} else {
			return right!=null ? right.find(d) : null;
		}
	}

	public static void main(String[] args) {

	}
}
