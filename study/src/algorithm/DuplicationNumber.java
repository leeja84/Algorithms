package algorithm;

import java.util.HashSet;
import java.util.Set;

public class DuplicationNumber {
	public static void main(String[] args) {
		int items[] = { 1, 2, 3, 2, 5, 7, 6, 4, 5, 5, 9 };
		Set set = new HashSet();
		for (int item : items) {
			if (set.contains(item)) {
				System.out.println(item);
			}
			set.add(item);
		}
		System.out.println("No. of duplicate items:" + (items.length - set.size()));

	}

}
