package start.ctci.mt;

import java.util.concurrent.Semaphore;

public class CallInOrder2 extends Thread{

	Semaphore sp1, sp2;

	public CallInOrder2() {
		sp1 = new Semaphore(1);
		sp2 = new Semaphore(1);
		
		try {
			sp1.acquire();
			sp2.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void first() {
		sp1.release();
		System.out.println("First called.");
	}

	public void second() {
		try {
			sp1.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sp1.release();
		sp2.release();

		System.out.println("Second called.");
	}

	public void third() {
		try {
			sp2.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sp2.release();
		System.out.println("Third called.");

	}
	
	@Override
	public void run() {
		first();
		second();
		third();
	}

	public static void main(String[] args) {
		CallInOrder2 c1=new CallInOrder2();
		CallInOrder2 c2=new CallInOrder2();
		CallInOrder2 c3=new CallInOrder2();
		
		
		c1.start();
		c2.start();
		c3.start();
	}
}
