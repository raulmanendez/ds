package start.ctci.ll;

import java.util.Stack;

public class Palindrome {

	//reverse and compare
	private static boolean isPalindromeV1(LLNode node) {
		LLNode reversed=cloneReverse(node);
		return isEqual(node, reversed);
	}
	
	private static LLNode cloneReverse(LLNode node) {
		LLNode reverse=null;
		
		while(node!=null) {
			LLNode temp=new LLNode(node.value);
			
			temp.next=reverse;
			reverse=temp;
			
			node=node.next;
		}
		
		return reverse;
	}
	
	private static boolean isEqual(LLNode l1,LLNode l2) {
		while(l1!=null && l2!=null) {
			if(l1.value!=l2.value) return false;
			
			l1=l1.next;
			l2=l2.next;
		}
		
		return l1==null && l2==null;
	}
	
	//use a stack till half
	private static boolean isPalindromeV2(LLNode node) {
		
		Stack<Integer> stack=new Stack<>();
		LLNode slow=node,fast=node;
		
		//slow will be middle
		while(fast!=null && fast.next!=null) {
			stack.push(slow.value);
			
			slow=slow.next;
			fast=fast.next.next;
		}
		
		if(fast!=null) slow=slow.next;
		while(slow!=null) {
			
			if(slow.value!=stack.pop()) return false;
			slow=slow.next;
		}
		
		return true;
	}
	
	private static  boolean isPalindromerRecurse(LLNode node)  {
		int length=SumList.length(node);
		
		Result result=isPalindromerRecurse(node, length);
		return result.result;
	}
	
	private static Result isPalindromerRecurse(LLNode node,int length)  {
		if(node==null || length<=0) {//even 
			return new Result(true, node);
		} else if(length==1) {
			return new Result(true,node.next);//odd
		}
		
		Result res=isPalindromerRecurse(node.next, length -2);
		
		if(res.node==null || !res.result) return res;
		
		res.result= res.node.value==node.value;
		res.node=res.node.next;
		
		return res;
	}
	
	public static void main(String[] args) {
		LLNode evenList=new LLNode(1,new LLNode(2,new LLNode(2,new LLNode(1))));
		LLNode oddList=new LLNode(1,new LLNode(2,new LLNode(3,new LLNode(2,new LLNode(1)))));
		
		
		/*
			System.out.println(isPalindromeV1(oddList));
			System.out.println(isPalindromeV1(evenList));
			
			System.out.println(isPalindromeV2(oddList));
			System.out.println(isPalindromeV2(evenList));
		*/
		
		System.out.println(isPalindromerRecurse(oddList));
		System.out.println(isPalindromerRecurse(evenList));
	}
}

class Result {
	boolean result;
	LLNode node;
	
	Result(boolean result,LLNode node) {
		this.result=result;
		this.node=node;
	}
}
