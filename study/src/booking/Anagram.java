package booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * An anagram is a word that can be written as a permutation of the characters
 * of another word, like "dirty room" and "dormitory" (ignore spaces). However,
 * "the" and "thee" are not anagrams, since "the" only has a single "e" whereas
 * "thee" has two "e" characters (spaces can occur zero, or multiple times,
 * however.)
 * 
 * Given a list of words as strings, you should return another list of strings,
 * each containing words that are mutual anagrams.
 * 
 * Each string of the output should be a single group of anagarms joined with
 * commas.
 * 
 * Within an output string, the expression should be sorted lexicographically.
 * If a group contains only a single element, output that one-element group as a
 * single string. And the string should be also output in lexicographical order.
 * Given e.g.:
 * 
 * pear amleth dormitory tinsel dirty room hamlet listen silnet ... the output
 * would be:
 * 
 * amleth,hamlet dirty room,dormitory listen,silnet,tinsel pear
 * 
 * 
 * @author leeja84
 *
 */
public class Anagram {

	public static void main(String[] args) {
		System.out.println(ana());
	}

	public static List<List<String>> ana() {
		List<String> list = new ArrayList<>();
		String[] array = { "pear", "dormitory", "tinsel", "dirty room", "hamlet", "listen", "amleth", "silnet" };

		if (array == null || array.length == 0) {
			return new ArrayList<List<String>>();
		}

		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String s : array) {
			char[] ca = s.toCharArray();

			Arrays.sort(ca);

			String keyStr = String.valueOf(ca);
			if (!map.containsKey(keyStr)) {
				map.put(keyStr, new ArrayList<String>());
			}
			map.get(keyStr).add(s);
			for (String key : map.keySet()) {
				Collections.sort(map.get(key));
			}
		}
		return new ArrayList<List<String>>(map.values());
	}
}
