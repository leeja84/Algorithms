package algorithm;

//회문(Palindrome) 앞뒤가 같은 문자. 
//하나를 제외한 모든 문자의 갯수가 짝수이면 회문가능.
//abc(d)cba 가능. abc(d)(f)cba 불가능.
/**
 * 앞 뒤를 검색해서 같은지 비교.
 * 
 * @author leeja84
 *
 */
public class Palindrome {
	public static void main(String[] args) {
		System.out.println(palindrome("토마토마토"));
		System.out.println(palindrome("leveL"));
	}

	private static boolean palindrome(String input) {
		for (int i = 0; i < input.length() / 2; i++) {
			if(input.charAt(i) != input.charAt(input.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
}
