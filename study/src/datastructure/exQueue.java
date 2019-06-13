package datastructure;

import java.util.NoSuchElementException;

public class exQueue {
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty());
		System.out.println(queue.remove());
		System.out.println(queue.isEmpty());

	}
}

class Queue<T> {
	class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
		}
	}

	private Node<T> first;
	private Node<T> last;

	public void add(T item) {
		Node<T> newNode = new Node(item);

		// 마지막 노드가 있다면 마지막 다음노드에 새로운 노드를 넣고, 마지막 노드를 새로생성한 노드의 값으로 대체.
		if (last != null) {
			last.next = newNode;
		}
		last = newNode;

		// 첫번째 노드가 없다면 마지막값을 넣어준다.
		if (first == null) {
			first = last;
		}
	}

	public T remove() {
		if (first == null) {
			throw new NoSuchElementException();
		}

//		첫 번째 데이터를 임시로 저장해두고 
		T temp = first.data;
		first = first.next;

		// 첫 노드가 null일경우에 last도 null 로 변경.
		if (first == null) {
			last = null;
		}
		return temp;
	}

	public T peek() {
		if (first == null) {
			throw new NoSuchElementException();
		}

		return first.data;
	}

	public boolean isEmpty() {
		return first == null;
	}

}
