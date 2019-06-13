package algorithm;

//치환(Permutaion) ABC, BCA 는 치환 가능한 문자.
//문자의 갯수가 같은지 확인하고 각 문자를 정렬후에 같은지 비교함.
public class Permutation {
	public static void main(String[] args) {
		System.out.println(permutation("AABBDD", "aabbdd"));
		System.out.println(permutation("AABBDD", "DBDABA"));
		System.out.println(permutation("AABBDD", "DBDABC"));

	}

	public static boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

//		아스키인 경우 128짜리 배열을 만든다.
		int[] letter = new int[128];

		// 문자를 돌면서 문자가 해당되는 위치에 1을 증가해준다.
		for (int i = 0; i < s.length(); i++) {
			letter[s.charAt(i)]++;
		}

		// 문자를 돌면서 문자가 해당되는 위치에 1을 빼준다.
		for (int i = 0; i < t.length(); i++) {
			letter[t.charAt(i)]--;
			// 0보다 작은경우에는 첫번째 문자열에 없는 문자가 있기때문에 음수가 된다. 이런 경우에는 치환이 불가능한 경우라 false 반환.

			if (letter[t.charAt(i)] < 0) {
				return false;
			}
		}

		return true;
	}
}
