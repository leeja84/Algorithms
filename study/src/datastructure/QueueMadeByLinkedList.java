package datastructure;

import java.util.LinkedList;

/**
 * 링크드 리스트로 queue 만들기.
 * @author leeja84
 *
 */
public class QueueMadeByLinkedList {
	public static void main(String[] args) {
		Dog d1 = new Dog("d1");
		Dog d2 = new Dog("d2");
		Dog d3 = new Dog("d3");
		
		Cat c1 = new Cat("c1");
		Cat c2 = new Cat("c2");
		Cat c3 = new Cat("c3");
		
		
		AnimalShelter animalShelter = new AnimalShelter();
		animalShelter.enqueue(c3);
		animalShelter.enqueue(c2);
		animalShelter.enqueue(d1);
		animalShelter.enqueue(c1);
		animalShelter.enqueue(d2);
		animalShelter.enqueue(d3);
		
		System.out.println(animalShelter.dequeueCat().info());
		System.out.println(animalShelter.dequeueDog().info());
		
		System.out.println(animalShelter.dequeue().info());
		System.out.println(animalShelter.dequeue().info());
		System.out.println(animalShelter.dequeue().info());
		System.out.println(animalShelter.dequeue().info());
		 
	}
}

class AnimalShelter {
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	int order;

	public AnimalShelter() {
		order = 1;
	}

	void enqueue(Animal animal) {
		animal.setOrder(order);
		order++;

		if (animal.animalType == AnimalType.DOG) {
			dogs.addLast((Dog) animal);
		} else if (animal.animalType == AnimalType.CAT) {
			cats.addLast((Cat) animal);
		}
	}

	Animal dequeueDog() {
		return dogs.poll();
	}

	Animal dequeueCat() {
		return cats.poll();
	}

	Animal dequeue() {
		if (dogs.size() == 0 && cats.size() == 0) {
			return null;
		} else if (dogs.size() == 0) {
			return cats.poll();
		} else if (cats.size() == 0) {
			return dogs.poll();
		}

		Animal dog = dogs.peek();
		Animal cat = cats.peek();

		if (dog.getOrder() > cat.getOrder()) {
			return cats.poll();
		} else {
			return dogs.poll();
		}

	}
}

enum AnimalType {
	DOG, CAT
}

abstract class Animal {
	AnimalType animalType;
	String name;
	int order;

	Animal(AnimalType animalType, String name) {
		this.animalType = animalType;
		this.name = name;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}

	String info() {
		return order + ") type : " + animalType + ", name : " + name;
	}
}

class Dog extends Animal {
	Dog(String name) {
		super(AnimalType.DOG, name);
	}
}

class Cat extends Animal {
	Cat(String name) {
		super(AnimalType.CAT, name);
		// TODO Auto-generated constructor stub
	}

}