package algorithm;

public class SymbolAndChemical {
	public static void main(String[] args) {
		symbolAndChemical();
	}

	/*
	 * Chemicals array: ['Amazon', 'Microsoft', 'Google']
	 * 
	 * Symbols: ['I', 'Am','cro', 'Na', 'le', 'abc']
	 * 
	 * Output: [Am]azon, Mi[cro]soft, Goog[le]
	 */
	public static String symbolAndChemical() {
		String[] strArr = { "Amazon", "Microsoft", "Google", "leeja" };
		String[] symArr = { "I", "Am", "cro", "Na", "le", "abc", "ja", "ros" };

		StringBuffer builder = new StringBuffer();

		String result = "";
		for (int i = 0; i < strArr.length; i++) {
			for (int j = 0; j < symArr.length; j++) {
				String sym = symArr[j];
				String str = strArr[i];

				if (str.contains(sym)) {
					builder.append(str);
					builder.insert(str.indexOf(sym), "[");
					builder.insert(str.indexOf(sym) + sym.length() + 1, "]");

					result += builder.toString() + ", ";
					builder.setLength(0);
				}
			}
		}
//		result.substring(0, result.length()-3);

		System.out.println(result.substring(0, result.length() - 2));
		return result.substring(0, result.length() - 2);

	}
}
