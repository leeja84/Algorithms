package algorithm;

import java.util.Arrays;

public class reverseArray {
	public static void main(String[] args) {
		int[] arr = {1,2,4,5,6,3};
		System.out.println(Arrays.toString(reverseArray(arr)));

	}

//	중간을 기점으로 제일 앞 제일 뒤 변환
	public static int[] reverseArray(int[] arr) {
		 int size = arr.length;
	        for (int i = 0 ;i < size / 2; i++) {
	            int temp = arr[i];
	            arr[i] = arr[size-1-i];
	            arr[size-1-i] = temp;
	        }

		return arr;
	}
}
