package start.ctci.ll;

public class DetectLoop {

	private static LLNode detectLoop(LLNode node) {
		LLNode slow=node,fast=node;
		
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			
			if(slow==fast) break;
		}
		
		if(fast==null || fast.next==null) return null;
		
		slow=node;
		while(slow!=fast) {
			slow=slow.next;
			fast=fast.next;
		}
		
		return fast;
	}
	
	
	public static void main(String[] args) {
		LLNode loopStart=new LLNode(6);
		
		LLNode loopNode=new LLNode(7,new LLNode(8,new LLNode(9,new LLNode(10))));
		
		loopStart.next=loopNode;
		
		LLNode tail=loopNode;
		while(tail!=null && tail.next!=null) {
			tail=tail.next;
		}
		tail.next=loopStart;
		
		LLNode node=new LLNode(1,new LLNode(2,new LLNode(3,new LLNode(4,new LLNode(5,loopStart)))));
		
		node.print();
		
		LLNode res=detectLoop(node);
		
		if(res!=null)
			res.print();
		else {
			System.out.println("No Loop Detected!");
		}
		
		
		
		
	}
}
