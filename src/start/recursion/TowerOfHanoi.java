package start.recursion;

import java.util.Stack;

public class TowerOfHanoi {

	public static void towerOfHanoi(int n,Stack<Integer> source,Stack<Integer> auxilliary,Stack<Integer> destination) {
		System.out.println("n::"+n+"::source::"+source+" ::auxilliary::"+auxilliary+"::destination::"+destination);
		
		if(n==1) {
			//System.out.println("::n reached 1 so push destination with source pop::");
			destination.push(source.pop());
		}
		
		else {
			//System.out.println("destination <-> auxilliary");
			towerOfHanoi(n-1, source, destination, auxilliary);
			
			destination.push(source.pop());
			
			//System.out.println("source <-> auxilliary");
			towerOfHanoi(n-1, auxilliary, source, destination);
		}
		
	}
	
	public static void main(String[] args) {
		int disks=3;
		
		Stack<Integer> source=new Stack<>();
		Stack<Integer> auxilliary=new Stack<>();
		Stack<Integer> destination=new Stack<>();
		
		
		for(int i=disks;i>0;i--) {
			source.push(i);
		}
		
		towerOfHanoi(disks, source, auxilliary, destination);
		
		System.out.println("source::"+source);
		System.out.println("auxilliary::"+auxilliary);
		System.out.println("destination::"+destination);
	}
	
}
