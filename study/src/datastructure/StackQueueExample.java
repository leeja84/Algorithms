package datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueExample {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(0);
		stack.add(10);
		stack.add(100);
		stack.add(4);
		
		System.out.println(stack.isEmpty());
		System.out.println(stack.search(4));
	
		Queue<Integer> queue = null;
		queue = new LinkedList<Integer>();
		queue.add(0);
		queue.add(0);
		queue.add(2);
		
		System.out.println(queue.remove());
		System.out.println(queue.isEmpty());
		System.out.println(queue.remove(0));
		System.out.println(queue.remove());
		System.out.println(queue.isEmpty());
		
	}
}
