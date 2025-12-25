package start.ctci.mt;

import java.util.function.Function;
import java.util.function.Predicate;

class Wrapper {
	int limit;
	int current;

	public Wrapper(int limit, int current) {
		this.limit = limit;
		this.current = current;
	}
}

class DivisorCheck implements Runnable {

	Wrapper wrapper;

	public DivisorCheck(Wrapper wrapper) {
		this.wrapper = wrapper;
	}

	@Override
	public void run() {
		synchronized (this) {
			while (wrapper.current <= wrapper.limit) {
				if (wrapper.current % 3 == 0 && wrapper.current % 5 == 0) {
					System.out.println(Thread.currentThread().getName() + " FizzBuzz");
				} else if (wrapper.current % 3 == 0) {
					System.out.println(Thread.currentThread().getName() + " Fizz");
				} else if (wrapper.current % 5 == 0) {
					System.out.println(Thread.currentThread().getName() + " Buzz");
				} else {
					System.out.println(Thread.currentThread().getName() +" "+ wrapper.current);
				}

				wrapper.current++;
			}
		}
	}
}

class FizzBuzzLambda extends Thread {

	public static Object lock = new Object();
	public static int max = 20;
	public static int current = 1;
	Predicate<Integer> test;
	Function<Integer, String> printer;

	public FizzBuzzLambda(Predicate<Integer> test, Function<Integer, String> printer) {
		this.test = test;
		this.printer = printer;
	}

	@Override
	public void run() {

		while (true) {
			synchronized (lock) {

				if (current > max)
					return;

//				System.out.println(Thread.currentThread().getName());

				if (test.test(current)) {
					System.out.println(printer.apply(current));
					current++;

				}

			}
		}

	}

}

public class FizzBuzz {

	public static void main(String[] args) {
		// Approach 1
		Wrapper wrapper = new Wrapper(30, 1);

		Thread dc1 = new Thread(new DivisorCheck(wrapper));
		Thread dc2 = new Thread(new DivisorCheck(wrapper));
		Thread dc3 = new Thread(new DivisorCheck(wrapper));
		Thread dc4 = new Thread(new DivisorCheck(wrapper));

		dc1.start();
		dc2.start();
		dc3.start();
		dc4.start(); 
		// Approach 1

		// Approach 2
		/*
		 * Thread threads[] = { new FizzBuzzLambda(i -> i % 3 == 0 && i % 5 == 0, i ->
		 * "FizzBuzz"), new FizzBuzzLambda(i -> i % 3 == 0, i -> "Fizz"), new
		 * FizzBuzzLambda(i -> i % 5 == 0, i -> "Buzz"), new FizzBuzzLambda(i -> i % 3
		 * != 0 && i % 5 != 0, i -> Integer.toString(i)), };
		 * 
		 * for (Thread t : threads) { t.start(); }
		 */
		// Approach 2

	}
}
