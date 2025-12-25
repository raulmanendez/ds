package start.ctci.stack;

import java.util.LinkedList;

public class AnimalQueue {
	int order=0;
	LinkedList<Dog> dogs=new LinkedList<>();
	LinkedList<Cat> cats=new LinkedList<>();

	public void enqueue(Animal animal) {
		animal.setOrder(order++);

		if(animal instanceof Dog)
			dogs.addLast((Dog) animal);
		else if(animal instanceof Cat)
			cats.addLast((Cat) animal);
	}

	public Animal dequeueAny() {
		if(dogs.isEmpty())
			return dequeueCats();
		else if(cats.isEmpty())
			return dequeueDogs();

		Dog dog=dogs.peek();
		Cat cat=cats.peek();

		if(dog.isOlderThan(cat)) return dequeueDogs();
		else return dequeueCats();
	}

	public Dog dequeueDogs() {
		return dogs.poll();
	}

	public Cat dequeueCats() {
		return cats.poll();
	}

}

class Animal {
	private int order;
	private String name;

	public Animal(String name) {
		this.name=name;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}

	public boolean isOlderThan(Animal other) {
		return this.order < other.order;
	}
}


class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}
}

class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}
}