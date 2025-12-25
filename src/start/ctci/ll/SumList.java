package start.ctci.ll;

class PartialSum {
	LLNode sum;
	int carry=0;
}

public class SumList {

	private static LLNode sumIteratively(LLNode l1,LLNode l2) {

		int carry=0;
		LLNode result=null,head=null;

		int l1_length=length(l1);
		int l2_length=length(l2);

		if(l1_length > l2_length) l2=padListAfter(l2, l1_length - l2_length);
		if(l2_length > l1_length) l1=padListAfter(l1, l2_length - l1_length);

		l1.print();
		l2.print();

		while(l1!=null && l2!=null) {
			int sum=l1.value + l2.value + carry;

			int rem=sum%10;
			carry=sum/10;

			if(head==null) {
				result=new LLNode(rem);
				head=result;
			} else {
				result.next=new LLNode(rem);
				result=result.next;
			}

			l1=l1.next;
			l2=l2.next;

		}

		if(carry>0) {
			result.next=new LLNode(carry);
		}

		return head;
	}

	private static LLNode padListAfter(LLNode node,int pad) {
		LLNode temp=node;

		while(temp!=null && temp.next!=null) {
			temp=temp.next;
		}

		while(pad > 0) {
			LLNode last=new LLNode(0);
			temp.next=last;

			temp=temp.next;
			pad--;
		}

		return node;
	}

	private static LLNode padListBefore(LLNode node,int pad) {

		while(pad > 0) {
			LLNode temp=new LLNode(0);
			temp.next=node;

			node=temp;
			pad--;
		}

		return node;
	}

	public static int length(LLNode node) {
		int size=0;

		LLNode runner=node;
		while(runner!=null) {
			size++;
			runner=runner.next;
		}

		return size;
	}


	private static void sumEqualLength(boolean recursive,boolean backward) {

		LLNode first=new LLNode(8,new LLNode(7,new LLNode(3)));

		LLNode second=new LLNode(5,new LLNode(6,new LLNode(7)));

		LLNode result=null;
		if(recursive)
			result=sumRecursive(second, first, 0);
		else if(backward)
			result=sumBackward(first, second);
		else
			result=sumIteratively(first, second);

		result.print();
	}

	private static void sumUnEqualLength(boolean recursive,boolean backward) {
		LLNode first=new LLNode(7,new LLNode(8,new LLNode(9)));

		LLNode second=new LLNode(5,new LLNode(1));

		LLNode result=null;
		if(recursive)
			result=sumRecursive(first, second,0);
		else if(backward)
			result=sumBackward(first, second);
		else
			result=sumIteratively(first, second);

		result.print();
	}

	private static LLNode sumRecursive(LLNode l1,LLNode l2,int carry) {

		int sum=carry;

		if(l1!=null) {
			sum+=l1.value;
		}

		if(l2!=null) {
			sum+=l2.value;
		}

		LLNode result=new LLNode(sum %10);

		if(l1!=null) {
			LLNode remaining=sumRecursive(
					l1==null ? null : l1.next,
					l2==null ? null : l2.next,
					sum/10);
			result.next=remaining;
		}


		return result;
	}

	private static LLNode sumBackward(LLNode l1,LLNode l2) {
		int l1_length=length(l1);
		int l2_length=length(l2);

		if(l1_length > l2_length) l2=padListBefore(l2, l1_length - l2_length);
		if(l2_length > l1_length) l1=padListBefore(l1, l2_length - l1_length);

		PartialSum sum=sumBackwardRecurse(l1, l2);
		if(sum.carry==0)
			return sum.sum;
		else {
			LLNode result=insertBefore(sum.sum, 1);

			return result;
		}
	}

	private static PartialSum sumBackwardRecurse(LLNode l1,LLNode l2) {
		if(l1==null) {
			PartialSum sum=new PartialSum();
			return sum;
		}
		PartialSum res=sumBackwardRecurse(l1.next, l2.next);
		int sum=l1.value + l2.value + res.carry;

		res.sum=insertBefore(res.sum, sum % 10);
		res.carry=sum/10;

		return res;
	}

	private static LLNode insertBefore(LLNode node,int data) {
		LLNode newNode=new LLNode(data);

		if(node!=null) {
			newNode.next=node;
		}
		return newNode;

	}

	public static void main(String[] args) {
		sumEqualLength(false,false);
		sumUnEqualLength(false,false);

		sumEqualLength(true,false);
		sumUnEqualLength(true,false);

		sumEqualLength(false,true);
		sumUnEqualLength(false,true);

	}
}