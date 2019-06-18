package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(9)));
	}
	
	// https://leetcode.com/problems/two-sum/
		public static int[] twoSum(int target) {
//			Given nums = [2, 7, 11, 15], target = 9,
//			Because nums[0] + nums[1] = 2 + 7 = 9,
//			return [0, 1].
			int[] nums = { 1, 2, 3, 4, 5, 6, 7, 20, 30 };

			Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
			for (int i = 0; i < nums.length; i++) {
				int complement = target - nums[i];
				if (hash.containsKey(complement)) {
					return new int[] { hash.get(complement), i };
				}
				hash.put(nums[i], i);

			}
	//
//			Map<Integer, Integer> map = new HashMap<>();
//			for (int i = 0; i < nums.length; i++) {
//				int complement = target - nums[i];
//				if (map.containsKey(complement)) {
//					return new int[] { map.get(complement), i };
//				}
//				map.put(nums[i], i);
//			}
			return null;
		}
}
