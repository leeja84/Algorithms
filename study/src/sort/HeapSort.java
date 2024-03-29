public static void main(String[] args) {
	int arr[] = { 5, 2, 1, 7, 112, 42, 52, 62 };
	heapSort(arr);
	printArray(arr);
}

/* 최대힙 삽입 */
public static void insert_max_heap(int[] arr,int x){
	int length = arr.length - 1;
	arr[++length] = x; // 힙 크기를 하나 증가하고 마지막 노드에 x를 넣는다.

	for (int i=length; i>1; i/=2) {
  	// 마지막 노드가 자신의 부모 노드보다 크면 swap
  	if (arr[i/2] < arr[i]) {
    	swap(i/2, i);
  	} else {
    	break;
  	}
}
}

/* 최대힙 삭제 */
int delete_max_heap(int[] arr){
	int heapsize = arr.length - 1;
if (heapSize == 0) // 배열이 빈 경우
  return 0;

int item = arr[1]; // 루트 노드의 값을 저장한다.
arr[1] = arr[heapSize]; // 마지막 노드의 값을 루트 노드에 둔다.
arr[heapSize--] = 0; // 힙 크기를 하나 줄이고 마지막 노드를 0으로 초기화한다.

for (int i=1; i*2<=heapSize;) {
  // 마지막 노드가 왼쪽 노드와 오른쪽 노드보다 크면 반복문을 나간다.
  if (arr[i] > arr[i*2] && arr[i] > arr[i*2+1]) {
    break;
  }
  // 왼쪽 노드가 더 큰 경우, 왼쪽 노드와 마지막 노드를 swap
  else if (arr[i*2] > arr[i*2+1]) {
    swap(i, i*2);
    i = i*2;
  }
  // 오른쪽 노드가 더 큰 경우, 오른쪽 노드와 마지막 노드를 swap
  else {
    swap(i, i*2+1);
    i = i*2+1;
  }
}
return item;
}

private static void heapSort(int[] arr) {
	// TODO Auto-generated method stub
	int length = arr.length - 1;
	maxHeapBuild(arr);
	for (int i = length; i >= 1; i--) {
		swap(arr, 0, i);
		length-=1;
		maxHeapify(arr, 0);
	}
}
private static void maxHeapBuild(int[] arr) {
	int length = arr.length;
	// 마지막 노드의 부모 노드에서부터 시작
	for (int i = length / 2; i >= 0; i--) {
		maxHeapify(arr, i);
	}
}
private static void maxHeapify(int[] arr, int i) {
	int length = arr.length;
	int leftChild = i*2;
	int rightChild = (i*2)+1;
	int k = 0;
	//자식 노드가 없을 경우에는 종료한다.
	if(leftChild > length || rightChild > length) {
		return;
	}
	//더 큰 Child를 k에 할당한다.
	if (arr[leftChild] > arr[rightChild]) {
		k = leftChild;
	} else {
		k = rightChild;
	}
	//부모 노드가 자식보다 큰 경우 종
	if (arr[i] >= arr[k]) {
		return;
	}
	//swap
	swap(arr, i, k);
	maxHeapify(arr, k);
}
public static void printArray(int arr[]) {
	for (int i = 0; i < arr.length; i++) {
		System.out.print(arr[i] + " ");
	}
	System.out.println();
}
public static void swap(int arr[], int i, int j) {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}
