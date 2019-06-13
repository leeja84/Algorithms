package datastructure;

import java.util.EmptyStackException;

public class exStack {
	public static void main(String[] args) {

		Stack<Integer> test = new Stack<Integer>();
		
		test.push(1);
		test.push(2);
		test.push(3);
		
		
		System.out.println("pop : " + test.pop());
		System.out.println("pop : " + test.pop());
		System.out.println("peak : " + test.peak());
		System.out.println("empty : " + test.isEmpty());
		System.out.println("pop : " + test.pop());
		System.out.println("empty : " + test.isEmpty());

	}
}

class Stack<T> {
	class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
		}

	}

	private Node<T> top;

	public T pop() {
		if (top == null) {
			throw new EmptyStackException();
		}
		T item = top.data;
		top = top.next;
		return item;
	}

	public void push(T item) {
		Node<T> newNode = new Node<T>(item);
		Node<T> temp;
		
		temp = top;
		top = newNode;
		top.next = temp;
		
//		top.next = top;
//		top = newNode;
		
	}

	public T peak() {
		if (top == null) {
			throw new EmptyStackException();
		}

		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}
}
