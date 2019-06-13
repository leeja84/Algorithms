package study;

public class BinaryTree {
	public static void main(String[] args) {
		Tree t = new Tree(10);
		System.out.println("inorder : " + t.isValidateBST1());
	}

}

class Tree {
	class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	Node root;
	int size;
	
//			4
//		   /  \
//	     1		7
//	    / \    / \
//	   0   2  5   8
//	        \  \   \
//	         3  6   9

	Tree(int size) {
		this.size = size;
		root = makeBST(0, size - 1);
//		root.right.right.right.left = new Node(10);
//		this.size++;
	}

	private Node makeBST(int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid - 1);
		node.right = makeBST(mid + 1, end);
		return node;
	}
	
	public boolean isValidateBST1() {
		int[] array = new int[size];
		inorder(root, array);
		for(int i=1; i< array.length; i++) {
			if(array[i]<array[i-1]) {
				return false;
			}
		}
		return true;
	}
	
	int index = 0;
	

//	left, root, right
	private void inorder(Node root, int[] array) {
		// TODO Auto-generated method stub
		if(root != null) {
			inorder(root.left, array);
			array[index]= root.data;
			index++;
			inorder(root.right, array);
		}
	}
	
	Integer last_printed = null;
	
}