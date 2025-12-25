package start.ctci.mt;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PhilosopherV3 extends Thread {

	int id;
	int bites = 10;
	ChopstickV3 lower, higher;

	PhilosopherV3(int id,ChopstickV3 left, ChopstickV3 right) {
		this.id=id;
		this.lower = left;
		this.higher = right;
		
		if(left.id>right.id) {
			this.lower = right;
			this.higher = left;
		} else {
			this.higher = right;
			this.lower = left;
		}
	}

	void eat() {
		pickup();
		//eat
		putdown();
	}
	
	void pickup() {
		lower.pickup(id);
		higher.pickup(id);
	}
	
	void putdown() {
		higher.putdown(id);
		lower.putdown(id);
	}

	@Override
	public void run() {
		for (int i = 0; i < bites; i++) {
			eat();
		}
	}
}

class ChopstickV3 {

	int id;
	Lock lock;

	ChopstickV3(int id) {
		this.id = id;
		lock = new ReentrantLock();
	}

	void pickup(int philosopherId) {
		System.out.println(id + " picking by "+philosopherId);
		lock.lock();
		System.out.println(id + " picked by "+philosopherId);
	}

	void putdown(int philosopherId) {
		System.out.println(id + " putting down by "+philosopherId);
		lock.unlock();
		System.out.println(id + " put down by "+philosopherId);
	}
}

public class PhilosopherChopstickV3 {

	public static void main(String[] args) {

		ChopstickV3 c1 = new ChopstickV3(1);
		ChopstickV3 c2 = new ChopstickV3(2);
		ChopstickV3 c3 = new ChopstickV3(3);
		ChopstickV3 c4 = new ChopstickV3(4);

		PhilosopherV3 p1 = new PhilosopherV3(11,c1, c2);
		PhilosopherV3 p2 = new PhilosopherV3(12, c2, c3);
		PhilosopherV3 p3 = new PhilosopherV3(13, c3, c4);
		PhilosopherV3 p4 = new PhilosopherV3(14, c4, c1);

		p1.start();
		p2.start();
		p3.start();
		p4.start();
	}

}