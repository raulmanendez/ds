package start.linklist;

//Intersection of Two Linked Lists:
//Find the intersection node of two linked lists.
public class Intersection {

	public static Node findIntersection(Node node1,Node node2) {
		
		Node pA=node1;
		Node pB=node2;
		
		short count=0;
		while(pA!=pB) {
			pA = pA.next==null ? node2 : pA.next;
			pB = pB.next==null ? node1 : pB.next;
			
			//this code is to avoid infinite loop 
			if(pA==node2 || pB==node1) count++;
			if(count > 1) return null;
			//this code is to avoid infinite loop
		}
		
		return pA;
	}
	
	public static void main(String[] args) {
		
		//if intersection exists
		
		Node node11=new Node(1);
		Node node12=new Node(2);
		Node node13=new Node(3);
		Node node14=new Node(4);
		Node node15=new Node(5);
		
		//1,2,3,[4],5
		node11.next=node12;
		node12.next=node13;
		node13.next=node14;
		node14.next=node15;
		
		//3,[4],5
		Node node21=new Node(3);
		//node21.next=node14;
		
		//if no intersection exists
		Node node22=new Node(4);
		Node node23=new Node(5);
		node21.next=node22;
		node22.next=node23;
		//if no intersection exists
		
		//4 is the point of intersection
		node11.print();
		node21.print();
		
		Node result=Intersection.findIntersection(node11, node21);
		if(result!=null) 
			System.out.println("Intersection of node11 and node21 is :"+result.data);
		else
			System.out.println("Intersection of nodes do not exists.");
	}
}
