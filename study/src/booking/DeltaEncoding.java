package booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of numbers, e.g.:

25626 25757 24367 24267 16 100 2 7277
Output a delta encoding for the sequence. In a delta encoding, the first element is reproduced as is. Each subsequent element is represented as the numeric difference from the element before it. E.g. for the sequence above, the delta encoding would be:

25626 131 -1390 -100 -24251 84 -98 7275
However, if a difference value does not fit in a single signed byte, i.e. -127 <= x <= 127, then, instead of the difference, we would like to use an escape token, printing it.

This will denote that the value following the escape token is a full four-byte difference value, rather than a one-byte different value.

For this exercise, we'll declare -128 as the escape token.

Following the same example above, the final result would be:

25626 -128 131 -128 -1390 -100 -128 -24251 84 -98 -128 7275
 * @author leeja84
 *
 */
public class DeltaEncoding {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(25626, 25757, 24367, 24267, 16, 100, 2, 7277);
		System.out.println(delta(list));
	}
	public static List<Integer> delta(List<Integer> list) {
//		List<Integer> list = Arrays.asList(25626, 25757, 24367, 24267, 16, 100, 2, 7277);
		int def = 0;
		int token = -128;
		List<Integer> result = new ArrayList<>();

		result.add(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			def = list.get(i) - list.get(i - 1);
			if (Math.abs(def) <= 127) {
				result.add(def);
			} else {
				result.add(token);
				result.add(def);
			}
		}

		
		return result;
	}
}
