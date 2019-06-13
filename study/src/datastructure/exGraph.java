package datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class exGraph {

	public static void main(String[] args) {
		Graph graph = new Graph(9);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		graph.addEdge(6, 8);

//		graph.DFS();
//		graph.BFS(3);
		graph.DFSR();
	}

}

class Graph {
	class Node {
		int data;
		LinkedList<Node> adjacent;
		boolean marked;

		Node(int data) {
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>();
			// TODO Auto-generated constructor stub
		}
	}

	Node[] nodes;

	Graph(int size) {
		nodes = new Node[size];
		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}

	// 두 노드간에 서로 인접한 노드가 있는지 확인하고 서로 추가.
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];

		if (!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}

		if (!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}

	void DFSR(Node r) {
		if (r == null) {
			return;
		}
		r.marked = true;
		visit(r);
		for (Node n : r.adjacent) {
			if (n.marked == false) {
				DFSR(n);
			}
		}
	}

	void DFSR() {
		DFSR(0);
	}

	void DFSR(int index) {
		Node n = nodes[index];
		DFSR(n);
	}

	void DFS() {
		DFS(0);
	}

	void DFS(int i) {
		// 스택 생성과 스택에 들어갔다고 표시.
		Node root = nodes[i];
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		root.marked = true;

		while (!stack.isEmpty()) {
			Node r = stack.pop();
			for (Node n : r.adjacent) {
				if (n.marked == false) {
					n.marked = true;
					stack.push(n);
				}
			}
			visit(r);
		}
	}

	private void visit(Node n) {
		// TODO Auto-generated method stub
		System.out.print(n.data + " ");

	}

	void BFS() {
		BFS(0);
	}

	void BFS(int i) {
		Node root = nodes[i];
		Queue<Node> queue = new LinkedList<Graph.Node>();
		queue.add(root);
		root.marked = true;

		while (!queue.isEmpty()) {
			Node r = queue.poll();
			for (Node n : r.adjacent) {
				if (n.marked == false) {
					n.marked = true;
					queue.add(n);
				}
			}
			visit(r);
		}

	}

}