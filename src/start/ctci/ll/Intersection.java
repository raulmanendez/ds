package start.ctci.ll;


class TailSizeResult {
	LLNode tail;
	int size;

	TailSizeResult(LLNode tail,int size) {
		this.tail=tail;
		this.size=size;
	}

}
public class Intersection {

	public static LLNode itersection(LLNode l1,LLNode l2) {
		TailSizeResult l1_res=getTailAndSize(l1);
		TailSizeResult l2_res=getTailAndSize(l2);

		if(l1_res.tail!=l2_res.tail) {
			return null;
		}

		LLNode shorter=l1_res.size > l2_res.size ? l2 : l1;
		LLNode longer=l1_res.size > l2_res.size ? l1 : l2;

		longer=moveNth(longer, Math.abs(l1_res.size-l2_res.size));

		while(longer!=shorter) {
			longer=longer.next;
			shorter=shorter.next;
		}

		return shorter;
	}

	private static TailSizeResult getTailAndSize(LLNode node) {
		LLNode tail=node;
		int size=0;

		while(tail!=null) {
			tail=tail.next;
			size++;
		}

		return new TailSizeResult(tail, size);
	}

	private static LLNode moveNth(LLNode node,int n) {
		while(n>0) {
			node=node.next;
			n--;
		}

		return node;
	}

	public static void main(String[] args) {
		LLNode intersection=new LLNode(5,new LLNode(55,new LLNode(555)));

		LLNode l1=new LLNode(2, new LLNode(3, new LLNode(4, intersection)));
		LLNode l2=new LLNode(7, new LLNode(6, intersection));

		l1.print();
		l2.print();

		LLNode interResult=itersection(l1,l2);
		interResult.print();

		//no INTERSECTION
		LLNode ll1=new LLNode(2, new LLNode(3, new LLNode(4)));
		LLNode ll2=new LLNode(6, intersection);

		ll1.print();
		ll2.print();

		interResult=itersection(ll1,ll2);
		if(interResult!=null)
			interResult.print();
		else {
			System.out.println("no intersection found....");
		}
	}
}
