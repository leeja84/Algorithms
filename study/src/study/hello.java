package study;

import java.util.ArrayList;

public class hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		test();
	}

	private static void test() {
		String str = "Hi Sivasrinivas, your Uber is arriving now!";

//		String str = "["Hi Sivasrinivas(total-2/ total), your Uber is arriving(total-1/ total), now!(total/total)"];
		String[] temp;
		String sentence = "";
		ArrayList<String> result = new ArrayList<String>();
		int limit = 25;
		int count = 0;

//		System.out.println(str.length());
		temp = str.split(",", 2);
		for(String string : temp) {
			System.out.println(string);
		}
//		System.out.println(temp.length);
		for (int i = 0, j = 0; i < temp.length; i++) {
			if (temp[i].length() >= 25) {
				return;
			}

//			System.out.println(sentence.length());

//			if (sentence.length() + temp[i].length() < limit) {
//				sentence += " " + temp[i];
//				System.out.println(sentence);
//			}

//			sentence += temp[i];
//			if (sentence.length() >= 25) {
//				
//			}

		}

	}

}
