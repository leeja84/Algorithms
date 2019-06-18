package algorithm;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
public class RemovedDulplicationNumber {
	public static void main(String[] args) {
		removeDuplicatesFromSortedArray();
	}
	
	// 초기 인덱스를 1로 설정하고 현재값과 바로 전의 값을 비교하면서 새로운 인덱스를 설정해서 저장.
	public static int removeDuplicatesFromSortedArray() {

		int[] nums = { 1, 1, 2, 2, 2, 3, 4, 4, 4, 5, 6, 7, 20, 30 };
		int point = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] < nums[i]) {
				nums[point] = nums[i];
				point++;
			}
		}

		for (int i = 0; i < point; i++) {
			System.out.println("lee" + nums[i]);
		}

		return point;
	}
}
