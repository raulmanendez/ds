package start.ctci.mt;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Philosopher extends Thread {

	int id;
	int bites = 10;
	Chopstick left, right;

	Philosopher(int id,Chopstick left, Chopstick right) {
		this.id=id;
		this.left = left;
		this.right = right;
	}

	void eat() {
		left.pickup(id);
		right.pickup(id);

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

class Chopstick {

	int id;
	Lock lock;

	Chopstick(int id) {
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

public class PhilosopherChopstickV1 {

	public static void main(String[] args) {

		Chopstick c1 = new Chopstick(1);
		Chopstick c2 = new Chopstick(2);
		Chopstick c3 = new Chopstick(3);
		Chopstick c4 = new Chopstick(4);

		Philosopher p1 = new Philosopher(11,c1, c2);
		Philosopher p2 = new Philosopher(12, c2, c3);
		Philosopher p3 = new Philosopher(13, c3, c4);
		Philosopher p4 = new Philosopher(14, c4, c1);

		p1.start();
		p2.start();
		p3.start();
		p4.start();
	}

}