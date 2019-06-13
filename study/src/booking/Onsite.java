package booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


/**
 * 
 * The input is a list of names in random order. We need a function that chains
 * elements of the list in such a way that the last character of an name is the
 * same as the first one of the next name.
 * 
 * For instance:
 * 
 * Input: [“Raymond”, “Nora”, “Daniel”, “Louie”, “Peter”, “Esteban”] Output:
 * [“Peter”, “Raymond”, “Daniel”, “Louie”, “Esteban”, “Nora”] There should be
 * only one solution, so the first element is unique.
 * 
 * 
 * @author leeja84
 *
 */
public class Onsite {
	
	public static void main(String[] args) {
		String[] names = new String[] { "Raymond", "Nora", "Daniel", "Louie", "Peter", "Esteban" };
		System.out.println(Arrays.toString(chainNames(names)));

	}

	/**
	 * You're given an array of names, where each name is given as a string. Your
	 * task is to link these names into a chain, so that the ith name starts with
	 * the same letter the (i - th)th name ends, and return this chain as a list.
	 * 
	 * All names should be used. It is guaranteed that each name starts with a
	 * unique letter. It is also guaranteed that there is only one solution.
	 * 
	 * 
	 * Example
	 * 
	 * For
	 * 
	 * names = ["Raymond", "Nora", "Daniel", "Louie", "Peter", "Esteban"] the output
	 * should be
	 * 
	 * chainNames(names) = ["Peter", "Raymond", "Daniel", "Louie", "Esteban",
	 * "Nora"]
	 * 
	 * @param names
	 * @return
	 */
	public static String[] chainNames(String[] names) {

		// Find the first name to put in the chain.
		// Whose first letter of name is not end letter of anybody's name.
		Map<Character, String> f = new HashMap<>();
		Map<Character, String> l = new HashMap<>();
		List<String> nl = new ArrayList<>();

		for (String e : names) {
			f.put(Character.toLowerCase(e.charAt(0)), e);
			l.put(e.charAt(e.length() - 1), e);
		}

		String a = "";
		Iterator<Character> i = f.keySet().iterator();
		while (i.hasNext()) {
			Character n = i.next();
			String p = l.get(n);
			if (p == null) {
				// this will be the first name.
				a = f.get(n);
				nl.add(a);
				String b = f.get(a.charAt(a.length() - 1));
				while (b != null) {
					nl.add(b);
					a = b;
					b = f.get(a.charAt(a.length() - 1));
					if (nl.size() == names.length) {
						break;
					}
				}

				break;
			}
		}

		return nl.toArray(new String[0]);

	}

	String[] chainNames0(String[] names) {

		// Find the first name to put in the chain.
		// Whose first letter of name is not end letter of anybody's name.
		Map<Character, String> f = new HashMap<>();
		Map<Character, String> l = new HashMap<>();
		List<String> nl = new ArrayList<>();

		for (String e : names) {
			f.put(Character.toLowerCase(e.charAt(0)), e);
			l.put(e.charAt(e.length() - 1), e);
		}

		String a = "";
		Iterator<Entry<Character, String>> i = f.entrySet().iterator();
		while (i.hasNext()) {
			Entry<Character, String> n = i.next();
			String p = l.get(n.getKey());
			if (p == null) {
				// this will be the first name.
				a = n.getValue();
				nl.add(a);
				String b = f.get(a.charAt(a.length() - 1));
				while (b != null) {
					nl.add(b);
					a = b;
					b = f.get(a.charAt(a.length() - 1));
				}

				break;
			}
		}

		return nl.toArray(new String[0]);

	}
}
