package start.ctci.mt;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CallInOrder3 extends Thread{

	int step = 1;
	Lock lock=new ReentrantLock();
	Condition sp1,sp2;

	public CallInOrder3() {
		sp1=lock.newCondition();
		sp2=lock.newCondition();
	}

	public void first() {
		lock.lock();
		
		try {
			step=2;
			System.out.println("First called.");
			sp1.signal();
		} finally {
			lock.unlock();
		}
	}

	public void second() throws InterruptedException {
		lock.lock();
		
		try {
			while(step!=2)
				sp1.await();
			
			System.out.println("Second called.");
			step=3;
			sp2.signal();
		} finally {
			lock.unlock();
		}
	}

	public void third() throws InterruptedException {
		lock.lock();	
		
		try {
			while(step!=3)
				sp2.await();
			
			System.out.println("Third called.");
		} finally {
			lock.unlock();
		}
	}
	
	@Override
	public void run() {
		try {
			first();
			second();
			third();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		CallInOrder3 c1=new CallInOrder3();
		CallInOrder3 c2=new CallInOrder3();
		CallInOrder3 c3=new CallInOrder3();
		
		
		c1.start();
		c2.start();
		c3.start();
	}
}
