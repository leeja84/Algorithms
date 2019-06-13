package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * // Each chunk has to be: // - up to 160 characters long // - no word should
 * be split in the middle // - each chunk has to have its order suffixed in the
 * form of ' (k/n)', e.g. "this is the first chunk (1/2)", "this is the second
 * chunk (2/2)" // - if the text provided to the function is less than 160
 * characters, no ordering should be suffixed
 * 
 * @author leeja84
 *
 */
public class cutString {
	private static final int LIMIT = 300;

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		String str = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
//		test(str, 160);

		List<String> list = new ArrayList<String>();
		list = test(str, LIMIT);
//		list = breakSentenceSmart(str, 160);
		for (String s : list) {
			System.out.println(s);
		}

	}

	public static List<String> test(String str, int limit) {
		List<String> result = new ArrayList<String>();

		StringTokenizer st = new StringTokenizer(str, " ");
		StringBuilder sb = new StringBuilder();

		while (st.hasMoreTokens()) {
			String word = st.nextToken();
			int totalLength = word.length() + sb.length();

//			1. sum of word length is over the limit.
//			2. sum of word length is equal the limit.
//			3. sum of word length is under the limit.

			// 160 초과했을 때. 초과한 길이만큼 제거하고 결과에 저장하고 SB 초기화. 초과된 단어는 저장해두었다가 나중에 다시 저장.
			if (limit < totalLength) {
				if (word.length() > limit) {
					int lineLengthLeft = limit - sb.length();
					String firstWordPart = word.substring(0, lineLengthLeft);
					sb.append(firstWordPart);
					// lines.add(currLine.toString());
					word = word.substring(lineLengthLeft);
					// currLine = new StringBuilder();
				}
				result.add(sb.toString());
				sb.setLength(0);
				// 160자 일때.
			} else if (limit == totalLength) {
				sb.append(word);
			} else {
				// 160자 미만일때. 계속 공백을 추가해주면서 더해줌. 뒤에 토큰이 더이상 없는경우에는 공백을 추가 하지 않음.
				if (st.hasMoreTokens()) {
					sb.append(word + " ");
				} else {
					sb.append(word);
				}
			}

		}

		if (sb.length() > 0) { // add whats left
			result.add(sb.toString());
		}

		return result;

	}

	public static List<String> breakSentenceSmart(String text, int maxWidth) {

		StringTokenizer stringTokenizer = new StringTokenizer(text, " ");
		List<String> lines = new ArrayList<String>();
		StringBuilder currLine = new StringBuilder();
		while (stringTokenizer.hasMoreTokens()) {
			String word = stringTokenizer.nextToken();

			boolean wordPut = false;
			while (!wordPut) {
				if (currLine.length() + word.length() == maxWidth) { // exactly fits -> dont add the space
					currLine.append(word);
					wordPut = true;
				} else if (currLine.length() + word.length() <= maxWidth) { // whole word can be put
					if (stringTokenizer.hasMoreTokens()) {
						currLine.append(word + " ");
					} else {
						currLine.append(word);
					}
					wordPut = true;
				} else {
					if (word.length() > maxWidth) {
						int lineLengthLeft = maxWidth - currLine.length();
						String firstWordPart = word.substring(0, lineLengthLeft);
						currLine.append(firstWordPart);
						// lines.add(currLine.toString());
						word = word.substring(lineLengthLeft);
						// currLine = new StringBuilder();
					}
					lines.add(currLine.toString());
					currLine = new StringBuilder();
				}

			}
			//
		}
		if (currLine.length() > 0) { // add whats left
			lines.add(currLine.toString());
		}
		return lines;
	}
}
