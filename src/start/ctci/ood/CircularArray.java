package start.ctci.ood;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T> {

	T[] items;
	int head = 0;

	public CircularArray(int capacity) {
		items = (T[]) new Object[capacity];
	}

	int convert(int i) {
		return (head + i) % items.length;
	}

	T get(int i) {
		if (i < 0 || i >= items.length)
			throw new IndexOutOfBoundsException();

		return items[convert(i)];
	}

	void set(int i, T item) {
		items[convert(i)] = item;
	}

	@Override
	public Iterator<T> iterator() {
		return new CircularArrayIterator(this);
	}

	private class CircularArrayIterator<T> implements Iterator<T> {

		T[] items;
		int current = -1;

		public CircularArrayIterator(CircularArray<T> array) {
			this.items = array.items;
		}

		@Override
		public boolean hasNext() {
			return current < items.length - 1;
		}

		@Override
		public T next() {
			current++;
			T item = items[convert(current)];
			return item;
		}
	}

}
