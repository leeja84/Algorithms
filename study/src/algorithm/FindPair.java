package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * ohn works at a clothing store. He has a large pile of socks that he must pair
 * by color for sale. Given an array of integers representing the color of each
 * sock, determine how many pairs of socks with matching colors there are.
 * 
 * For example, there are socks with colors . There is one pair of color and one
 * of color . There are three odd socks left, one of each color. The number of
 * pairs is .
 * 
 * Function Description
 * 
 * Complete the sockMerchant function in the editor below. It must return an
 * integer representing the number of matching pairs of socks that are
 * available.
 * 
 * sockMerchant has the following parameter(s):
 * 
 * n: the number of socks in the pile ar: the colors of each sock
 * 
 * 
 * Sample Input
 * 
 * 9 10 20 20 10 10 30 50 10 20
 * 
 * 
 * Sample Output
 * 
 * 3
 * 
 * 
 * 
 * @author leeja84
 *
 */
public class FindPair {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 20, 10, 10, 30, 50, 10, 20, 20, 30 };

		System.out.println("result" + sockMerchant(arr.length, arr));

	}

	
	static int sockMerchant(int n, int[] c) {
		Set<Integer> colors = new HashSet<>();
		int pairs = 0;

		for (int i = 0; i < n; i++) {
			//같은 값이 없으면 추가. 같은 값이 있으면 제거하면서 pair 갯수 증가.
			if (!colors.contains(c[i])) {
				colors.add(c[i]);
			} else {
				pairs++;
				colors.remove(c[i]);
			}
		}

		return pairs;
	}

}
