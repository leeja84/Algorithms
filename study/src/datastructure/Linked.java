package datastructure;

import java.util.HashSet;
import java.util.Set;

public class Linked {
	public static void main(String[] args) {
		LinkedNode linkedNode = new LinkedNode();

		linkedNode.append(1);
		linkedNode.append(2);
//		linkedNode.append(3);
//		linkedNode.append(4);
//		linkedNode.append(5);
		linkedNode.append(2);

//
		linkedNode.retrieve();
//		linkedNode.delete(2);
//		linkedNode.retrieve();
//

//		linkedNode.removeDuplicate();
//		linkedNode.retrieve();

	}
}

class LinkedNode {
	Node header;

	LinkedNode() {
		header = new Node(9);
	}

	static class Node {
		Object data = null;
		Node next = null;

		Node(Object data) {
			this.data = data;
		}

	}

	void kafka() {
		int length = getListLength(header);
		System.out.println("oo" + length);
	}

	int getListLength(Node node) {
		int length = 0;
		while (node != null) {
			System.out.println("---" + node.data);
			length++;
			node = node.next;
		}

		return length;

	}

	// 버퍼 없이 중복 제거.
//	r
//	1 2 3 4
//	n
	void removeDuplicate() {
		Node node = header;
		while (node != null && node.next != null) {
			Node runner = node;
			while (runner.next != null) {
				if (node.data.equals(runner.next.data)) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			node = node.next;
		}
	}

	void retrieve() {
		Node node = header.next;
		while (node.next != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.println(node.data);
	}

	void delete(Object data) {
		Node node = header;
		while (node.next != null) {
			if (node.next.data.equals(data)) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
	}

	void append(Object data) {
		Node newNode = new Node(data);
		Node node = header;

		while (node.next != null) {
			System.out.println("node check : " + node.data);
			node = node.next;
		}

		node.next = newNode;
	}

}
