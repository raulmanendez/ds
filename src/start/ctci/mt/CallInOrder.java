package start.ctci.mt;

import java.util.concurrent.CountDownLatch;

public class CallInOrder extends Thread{

	CountDownLatch sp1, sp2;

	public CallInOrder() {
		sp1 = new CountDownLatch(1);
		sp2 = new CountDownLatch(1);
	}

	public void first() {
		sp1.countDown();
		System.out.println("First called.");
	}

	public void second() {
		try {
			sp1.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		sp2.countDown();
		System.out.println("Second called.");
	}

	public void third() {
		try {
			sp2.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Third called.");

	}
	
	@Override
	public void run() {
		first();
		second();
		third();
	}

	public static void main(String[] args) {
		CallInOrder c1=new CallInOrder();
		CallInOrder c2=new CallInOrder();
		CallInOrder c3=new CallInOrder();
		
		
		c1.start();
		c2.start();
		c3.start();
	}
}
