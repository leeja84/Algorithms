package booking;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Identify whether four sides (given by four integers) can form a square, a
 * rectangle, or neither.
 * 
 * Input: You will receive an list of strings, each containing four
 * space-separated integers, which represent the length of the sides of a
 * polygon. The input lines will follow the 'A B C D' order as in the following
 * representation:
 * 
 * |-----A-----| | | | | D B | | | | |-----C-----| Output: A single line which
 * contains 3 space-separated integers; representing the number of squares,
 * number of rectangles, and number of other polygons with 4 sides. Note that
 * squares shouldn't be counted as rectangles. Invalid polygons should also be
 * counted as 'other polygons'.
 * 
 * Constraints: The four integers representing the sides will be such that:
 * -2000 <=X <= 2000 (Where X represents the integer)
 * 
 * Sample Input:
 * 
 * 36 30 36 30 15 15 15 15 46 96 90 100 86 86 86 86 100 200 100 200 -100 200
 * -100 200 Sample Output: 2 2 2
 * 
 * @author leeja84
 *
 */
public class Polygon {
	public static void main(String[] args) {
		List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 1, 1, 1), Arrays.asList(10, 20, 20, 10),
				Arrays.asList(10, 30, 30, 10), Arrays.asList(10, 100, 30));

		Map<Shape, Integer> map = distinctShape(list);

		System.out.println("lee : " + map);

	}

	private static Map<Shape, Integer> distinctShape(List<List<Integer>> list) {
		Map<Shape, Integer> result = new HashMap<Shape, Integer>();

		for (int i = 0; i < list.size(); i++) {
			Shape temp = checkSqure(list.get(i));
			if (result.containsKey(temp)) {
				result.put(temp, result.get(temp) + 1);
			} else {
				result.put(temp, 1);
			}
		}
		return result;
	}

	// 사각형 확인.
	public static Shape checkSqure(List<Integer> list) {
		final int countsSide = 4;
		final int maxLength = 2000;
		final int minLengh = -2000;
		if (0 >= Collections.min(list) || countsSide > list.size() || 2000 <= Collections.max(list)) {
			System.out.println("o11");
			return Shape.OTHER;
//				사각형 아님.
		}

		int a = list.get(0), b = list.get(1), c = list.get(2), d = list.get(3);

		if ((a == b) && (b == c) && (c == d)) {
			System.out.println("sq");
			return Shape.SQUARE;
//				사각형
		} else if ((a == c) && (b == d) && (c == d)) {
//		사각형
			System.out.println("re");
			return Shape.RECTANGLE;
		} else {
			// 사각형 아님
			System.out.println("other");
			return Shape.OTHER;
		}
	}
}

enum Shape {
	RECTANGLE, SQUARE, OTHER
}