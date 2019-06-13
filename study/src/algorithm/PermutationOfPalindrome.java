package algorithm;

//회문(Palindrome) 앞뒤가 같은 문자. 
//하나를 제외한 모든 문자의 갯수가 짝수이면 회문가능.
//abc(d)cba 가능. abc(d)(f)cba 불가능.
//
//치환(Permutaion) ABC, BCA 는 치환 가능한 문자.
//문자의 갯수가 같은지 확인하고 각 문자를 정렬후에 같은지 비교함.
/**
 * 치환 가능하지 않은 회문의 조건은 홀수개의 갯수가 두개 이상인것. aabbc -> abcba aabb -> abba ab 불가능.
 * 문자를 인덱스로 담은 배열의 값을 나머지 연산해서 홀수개인 값을 찾는다.
 * @author leeja84
 *
 */
public class PermutationOfPalindrome {
	public static void main(String[] args) {
		System.out.println(isPermutationOfPalindrome(" "));
		System.out.println(isPermutationOfPalindrome("aa bbb cc"));
		System.out.println(isPermutationOfPalindrome("a bbb cc"));
		System.out.println(isPermutationOfPalindrome("a bbb ccc"));
	}

	private static boolean isPermutationOfPalindrome(String s) {
		int[] letter = new int[128];
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			letter[s.charAt(i)]++;
			if (letter[s.charAt(i)] % 2 == 1) {
				count++;
			}else {
				count--;
			}
		}

//		for (int j = 0; j < letter.length - 1; j++) {
//			if (letter[j] % 2 == 1) {
//				count++;
//			}
//		}

		return count <= 1;

	}

//	치환가능한 회문 
//	private static boolean isPermutationOfPalindrome(String s) {
//		int coundOdd = 0;
//		// 0-25까지의 알파벳 각 자리를 담을 배열을 만든다. a~z
//		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
//
//		// 각 문자를 돌면서.
//		for (char c : s.toCharArray()) {
//			int x = getCharNumber(c);
////			x가 -1이면 공백이거나 다른 문자.
//			if (x != -1) {
////				하나 들어왔으니 1 증가시킴.
//				table[x]++; // table[x] += 1;
//				if (table[x] % 2 == 1) {
////					해당 배열방이 홀수인지 확인.
//					coundOdd++;
//				} else {
////					짝수이면 감소.
//					coundOdd--;
//				}
//			}
//		}
//		// 최종 홀수의 갯수가 하나이거나 그보다 작으면 회문이면서 치환가능한 문자.
//		return coundOdd <= 1;
//
//	}

//	아스키 값 A : 65 Z : 90    a : 97 z : 122 
	private static int getCharNumber(char c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);

		if (a <= val && val <= z) {
//			b가 들어왔다고 가정하면 98-97 이라서 b의 배열인덱스는 1
			return val - a;
		}
		return -1;
	}

}
