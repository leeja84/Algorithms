package booking;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

		checkSqure(1, 2, 1, 2);

	}

	// 사각형 확인.
	public static Shape checkSqure(int a, int b, int c, int d) {
		List<Integer> integerList = Arrays.asList(a, b, c, d);
		if (0 >= Collections.min(integerList)) {
			System.out.println("o11");
			return Shape.OTHER;
//				사각형 아님.
		} else if ((a == b) && (b == c) && (c == d)) {
			System.out.println("sq");
			return Shape.SQUARE;
//				사각형
		} else if ((a == c) && (b == d) || (a == b) && (c == d) || (a == d) && (b == c)) {
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