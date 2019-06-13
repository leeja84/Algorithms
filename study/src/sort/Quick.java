package sort;

public class Quick {
	public static void main(String[] args) {
		int[] arr = { 11, 18, 1, 20, 5, 12, 16, 21, };
//		System.out.println(findKth(arr, 6, 0, arr.length - 1));
//		11, 18, 1, 20, 5, 12, 5, 16, 21, 9, 13, 17, 3, 24, 15, 19
		printArray(arr);
		QuickSort(arr);
		printArray(arr);

	}

	private static void printArray(int[] arr) {
		for (int data : arr) {
			System.out.print(data + " ");
		}
		System.out.println();
	}

	public static void QuickSort(int[] array) {
		QuickSort(array, 0, array.length - 1);
	}

	private static void QuickSort(int[] array, int start, int end) {
		if (start < end) {
			int partition = hoarePartition(array, start, end);
			QuickSort(array, 0, partition - 1);
			QuickSort(array, partition + 1, end);
		}
	}

	private static int hoarePartition(int[] array, int start, int end) {
//		중간 지점을 피봇값으로 선택.
		int pivot = array[(start + end) / 2];

//		시작지점이 끝 지점보다 작거나 같을때만 돈다.
		while (start <= end) {
			while (array[start] < pivot) {
				start++;
			}
			while (array[end] > pivot) {
				end--;
			}
			if (start <= end) {
				swap(array, start, end);
				start++;
				end--;
			}

		}
		return start;
	}

	private static void swap(int[] array, int start, int end) {
		// TODO Auto-generated method stub
		int temp = 0;
		temp = array[start];
		array[start] = array[end];
		array[end] = temp;

	}

	static int findKth(int[] array, int find, int start, int end) {
		int pivot = lumutoPartition(array, start, end);
		int ret;
		if (pivot == find) {
			ret = array[pivot];
		} else if (pivot < find) {
			ret = findKth(array, find, pivot + 1, end);
		} else {
			ret = findKth(array, find, start, pivot - 1);
		}
		return ret;
	}

	private static int lumutoPartition(int array[], int start, int end) {
		int last = array[end];
		int index = start;
		for (int i = start; i < end; i++) {
			if (array[i] <= last) {
				swap(array, i, index);
				index++;
			}
		}
		swap(array, index, end);
		return index;
	}
}
