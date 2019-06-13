package datastructure;

import java.util.Stack;

//하나의 추가 스택을 이용한 정렬
public class StackSort {
	public static void main(String[] args) {
		Stack<Integer> test = new Stack<Integer>();
		test.push(1);
		test.push(8);
		test.push(4);
		test.push(9);

		sort(test);
		System.out.println(test.pop());
		System.out.println(test.pop());
		System.out.println(test.pop());
		System.out.println(test.pop());
	}

	private static Stack<Integer> sort(Stack<Integer> s1) {
		java.util.Stack<Integer> s2 = new java.util.Stack<Integer>();

		while (!s1.isEmpty()) {
			int temp = s1.pop();
			while (!s2.isEmpty() && s2.peek() > temp) {
				s1.push(s2.pop());
			}
			s2.push(temp);
		}

		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}


		return s1;
	}
}
