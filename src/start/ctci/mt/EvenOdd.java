package start.ctci.mt;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOdd  {

	static int current = 0;
	static int last = 10;
	Lock lock = new ReentrantLock();
	Condition evenCondition = lock.newCondition();
	Condition oddCondition = lock.newCondition();

	private boolean IsEven(int n) {
		return n % 2 == 0;
	}

	void printEven() throws InterruptedException {
		lock.lock();

		try {
			while (current <= last) {
				boolean isEven = IsEven(current);
				while (!isEven)
					evenCondition.await();

				
				System.out.println(current + " is Even.");
				current++;
				oddCondition.signal();
			
			}
		} finally {
			lock.unlock();
		}
	}

	void printOdd() throws InterruptedException {
		lock.lock();

		try {
			while (current <= last) {
				boolean isEven = IsEven(current);
				while (isEven)
					oddCondition.await();
	
				System.out.println(current + " is Odd.");
				current++;
				evenCondition.signal();
			
			}
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		EvenOdd eo = new EvenOdd();

		new Thread(() -> {
			try {
				eo.printEven();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();

		new Thread(() -> {
			try {
				eo.printOdd();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();

	}
}
