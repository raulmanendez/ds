package start.ctci.mt;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PhilosopherV2 extends Thread {

	int id;
	int bites = 1;
	ChopstickV2 left, right;

	PhilosopherV2(int id,ChopstickV2 left, ChopstickV2 right) {
		this.id=id;
		this.left = left;
		this.right = right;
	}

	void eat() {
		if(pickup()) {
			putdown();
		}
	}
	
	boolean pickup() {
		if(!left.pickup(id)) {
			return false;
		}
		
		if(!right.pickup(id)) {
			left.putdown(id);
			return false;
		}
		
		return true;
	}
	
	void putdown() {
		left.putdown(id);
		right.putdown(id);
	}

	@Override
	public void run() {
		for (int i = 0; i < bites; i++) {
			eat();
		}
	}
}

class ChopstickV2 {

	int id;
	Lock lock;

	ChopstickV2(int id) {
		this.id = id;
		lock = new ReentrantLock();
	}

	boolean pickup(int philosopherId) {
		System.out.println(id + " picking by "+philosopherId);
		boolean canLock = lock.tryLock();
		System.out.println(id + " picked by "+philosopherId);
		
		return canLock;
	}

	void putdown(int philosopherId) {
		System.out.println(id + " putting down by "+philosopherId);
		lock.unlock();
		System.out.println(id + " put down by "+philosopherId);
	}
}

public class PhilosopherChopstickV2 {

	public static void main(String[] args) {

		ChopstickV2 c1 = new ChopstickV2(1);
		ChopstickV2 c2 = new ChopstickV2(2);
		ChopstickV2 c3 = new ChopstickV2(3);
		ChopstickV2 c4 = new ChopstickV2(4);

		PhilosopherV2 p1 = new PhilosopherV2(11,c1, c2);
		PhilosopherV2 p2 = new PhilosopherV2(12, c2, c3);
		PhilosopherV2 p3 = new PhilosopherV2(13, c3, c4);
		PhilosopherV2 p4 = new PhilosopherV2(14, c4, c1);

		p1.start();
		p2.start();
		p3.start();
		p4.start();
	}

}