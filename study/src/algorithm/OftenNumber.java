package algorithm;

import java.util.HashMap;
import java.util.Map;

public class OftenNumber {
	public static void main(String[] args) {
		oftenNumber();
	}

	// 가장 많이 나타난 수 체크.
	public static void oftenNumber() {
		int[] data = { 1, 3, 4, 1, 1, 1, 1 };
//			int mode = 0; // 최빈값이 담길 그릇
//			int[] index = new int[6]; // 0~5까지 : 인덱스의 카운터
//			int max = Integer.MIN_VALUE; // 최대값을 저장하기위한 변수 ; 초기값은 정수형의 최소값지정
//
//			// [2] 처리
//			for (int i = 0; i < data.length; i++) {
//				index[data[i]]++; // COUNT
//			}
//			for (int i = 0; i < index.length; i++) {
//				System.out.println("lee index[i] : " + index[i]);
//				if (max < index[i]) {
//					max = index[i]; // MAX
//					mode = i; // 최빈값 : MODE
//				}
//			}

		//
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int max = Integer.MIN_VALUE;
		int mode = 0;
		for (int i = 0; i < data.length; i++) {
			int key = data[i];
			if (map.containsKey(key)) {
				map.put(data[i], map.get(key) + 1);
				if (max < map.get(key)) {
					max = map.get(key);
					mode = key;
				}
			} else {
				map.put(key, 1);
			}
		}

		// [3] 출력
		System.out.println("최빈값 : " + mode + " , " + max + "번"); 

	}
}
