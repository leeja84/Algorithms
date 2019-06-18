package booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

	public static String ana() {
		String[] array = { "pear", "dormitory", "tinsel", "dirty room", "hamlet", "listen", "amleth", "silnet" };

		String result = "";

		if (array == null || array.length == 0) {
			return result;
		}

		Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();
		for (String s : array) {
			// 각 스트링값을 정렬한거를 키 값으로사용함.
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String compareStr = String.valueOf(ca).trim();

			// 기존에 존재하지 않았던 값인지 확인해서 객체를 생성. 매번 해당 키에 값 추가.
			if (!anagramMap.containsKey(compareStr)) {
				anagramMap.put(compareStr, new ArrayList<String>());
			}
			anagramMap.get(compareStr).add(s);

		}

		Map<String, List<String>> sortedMap = new TreeMap<String, List<String>>();

		for (String key : anagramMap.keySet()) {
			List<String> list = anagramMap.get(key);
			
			Collections.sort(list);
			sortedMap.put(list.get(0), list);
		}

		
		// make output.
		for (String key : sortedMap.keySet()) {

			List<String> list = sortedMap.get(key);

			for (int i = 0; i < list.size(); i++) {
				result += list.get(i);
				if (i < list.size() - 1) {
					result += ", ";
				}
			}
			result += "\n";
		}

		result = result.substring(0, result.length() - 1);

		return result;
	}
}
