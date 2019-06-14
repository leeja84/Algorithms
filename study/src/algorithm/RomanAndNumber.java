package algorithm;

public class RomanAndNumber {
	public static void main(String[] args) {
		toRoman();
		toInteger();
	}

	/**
	 * 나머지 연산한 값이 원래의 값보다 작을때 로마 값 저장해주고 원래의 값은 나머지연산했던 수로 빼주면서 반복.
	 */
	public static void toRoman() {
		String result = "";
		int[] decimal = { 1000, 500, 100, 50, 10, 5, 1 };
		String[] roman = { "M", "D", "C", "L", "X", "V", "I" };

		int number = 1557;

		for (int i = 0; i < decimal.length; i++) {
			while (number % decimal[i] < number) {
				result += roman[i];
				number -= decimal[i];
			}
		}

		System.out.println("value : " + result);

	}

	/**
	 * 첫번째 문자를 찾고 치환하고 첫번째 문자를 제거하기를 반복.
	 */
	public static void toInteger() {
		int result = 0;
//		int[] decimal = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//		String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

		int[] decimal = { 1000, 500, 100, 50, 10, 5, 1 };
		String[] roman = { "M", "D", "C", "L", "X", "V", "I" };

		// Test string, the number 895
		String romanumber = "MDLVII";

		for (int i = 0; i < decimal.length; i++) {
			while (romanumber.indexOf(roman[i]) == 0) {
				result += decimal[i];
				romanumber = romanumber.substring(roman[i].length());
			}
		}
	}
}
