package algorithm;

public class NthSmallestNumber {
	public static void main(String[] args) {
		int[] arr = { 2, 100, 3, 5, 3, 9 };
		System.out.println(SecondMin(arr, 6));
	}

	public static int nthSmallestNum(int arr[], int n) {
		int nth = 0;
		for (int i = 0; i < arr.length; i++) {

		}
		return nth;
	}

	public static int SecondMin(int arr[], int n) {
		int i;
		int min = arr[0];
		int secondMin = min;

		for (i = 0; i < n; i++) {
			if (arr[i] < min) {
				secondMin = min;
				min = arr[i];
			} else if ((min < arr[i] && arr[i] < secondMin) || min == secondMin) {
				secondMin = arr[i];
			}
		}
		return secondMin;
	}

}
