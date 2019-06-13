package algorithm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Algorithms {
	private static final int LIMIT = 60;

	public static void main(String[] args) {

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

	public static boolean isSubString(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		return (s1 + s1).contains(s2);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();

		Arrays.sort(candidates);

		List<Integer> combination = new ArrayList<>();
		toFindCombination(result, combination, candidates, target, 0);

		return result;

	}

	private void toFindCombination(List<List<Integer>> result, List<Integer> combination, int[] candidates, int target,
			int startIndex) {
		if (target == 0) {
			result.add(new ArrayList<>(combination));
			return;
		}

		for (int i = startIndex; i < candidates.length; i++) {
			if (candidates[i] > target) {
				break;
			}

			combination.add(candidates[i]);
			toFindCombination(result, combination, candidates, target - candidates[i], i);
			combination.remove(combination.size() - 1);
		}

	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		boolean[] isWordBreak = new boolean[s.length() + 1];

		isWordBreak[0] = true;

		for (int i = 0; i < s.length() + 1; i++) {
			for (int j = 0; j < i; j++) {
				if (!isWordBreak[j]) {
					continue;
				}

				if (wordDict.contains(s.substring(j, i))) {
					isWordBreak[i] = true;
					break;
				}
			}
		}

		return isWordBreak[s.length()];
	}

//Given nums = [2, 7, 11, 15], target = 9,
// 
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].

	public static int solution(int[] A) {
		int val;
		int n = A.length;

		// to store next array element in
		// current traversal
		int nextval;

		for (int i = 0; i < n; i++) {

			// if value is negative or greater
			// than array size, then it cannot
			// be marked in array. So move to
			// next element.
			if (A[i] <= 0 || A[i] > n)
				continue;

			val = A[i];

			// traverse the array until we
			// reach at an element which
			// is already marked or which
			// could not be marked.
			while (A[val - 1] != val) {
				nextval = A[val - 1];
				A[val - 1] = val;
				val = nextval;
				if (val <= 0 || val > n)
					break;
			}
		}

		// find first array index which is
		// not marked which is also the
		// smallest positive missing
		// number.
		for (int i = 0; i < n; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}

		// if all indices are marked, then
		// smallest missing positive
		// number is array_size + 1.
		return n + 1;
	}

	public static List<List<String>> ana() {
		List<String> list = new ArrayList<>();
		String[] array = { "pear", "dormitory", "tinsel", "dirty room", "hamlet", "listen", "amleth", "silnet" };

		if (array == null || array.length == 0) {
			return new ArrayList<List<String>>();
		}

		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String s : array) {
			char[] ca = s.toCharArray();

			Arrays.sort(ca);

			String keyStr = String.valueOf(ca);
			if (!map.containsKey(keyStr)) {
				map.put(keyStr, new ArrayList<String>());
			}
			map.get(keyStr).add(s);
			for (String key : map.keySet()) {
				Collections.sort(map.get(key));
			}
		}
		return new ArrayList<List<String>>(map.values());

//		Arrays.sort(array);
//
//		LinkedHashSet<String> result = new LinkedHashSet<String>();
//
//		for (int i = 0; i < array.length; i++) {
//			for (int j = i + 1; j < array.length; j++) {
//				if (checkAnagram(array[i], array[j])) {
//					System.out.println(array[i] + " / " + array[j]);
//					list.add(array[i]);
//
//					result.add(array[i]);
//					result.add(array[j]);
////					System.out.println(result);
//					System.out.println(list);
//				}
//			}
//
//		}

//		System.out.println(list);
//			int[] nums = { 1, 2, 3, 4, 5, 6, 7, 20, 30 };
//
//		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
//		for (int i = 0; i < nums.length; i++) {
//			int complement = target - nums[i];
//			if (hash.containsKey(complement)) {
//				return new int[] { hash.get(complement), i };
//			}
//			hash.put(nums[i], i);
//
//		}
	}

	static List<Integer> oddNumbers(int l, int r) {
		List<Integer> array = new ArrayList<>();
		for (int i = l; i <= r; i++) {
			if (i % 2 != 0) {
				array.add(i);
			}
		}
		return array;
	}

	// 페어가 되는 값 찾기. sum = A+B
	public static void getPairNumbers() {
		int sum = 66;
		int left = 0;
		int length = 10;
		int right = length - 1;
		int array[] = { 18, 11, 21, 28, 31, 38, 40, 55, 60, 62 };

		Arrays.sort(array);

		while (left < right) {
			if (array[left] + array[right] == sum) {
				System.out.println("lee " + array[left] + "  //  " + array[right]);
			} else if (array[left] + array[right] > sum) {
				right--;
			} else {
				left++;
			}
		}

	}

	// 최소 공배수 최대 공약수
// A×B=L×G
	public static void GCD_LCM() {
		int A = 120; // 첫번째 수
		int B = 50; // 두번째 수
		int R = 1; // 두수의 나누기 결과 나머지 저장
		int HIGH = 0; // 최대공약수
		int LOW = 0; // 두수중 작은 데이터 임시 보관
		int L = 0; // 최소공백수

		if (A > B) { // A가 B보다 크다면?
			HIGH = A; // 큰 변수에 A를 입력
			LOW = B; // 작은 변수에 B를 입력
		} else {
			LOW = A;
			HIGH = B; // [1]
		}
		while (R > 0) { // 나머지가 0이 될때까지 반복
			R = HIGH % LOW; // 큰수 / 작은수의 나머지 : MOD() // [2]
			HIGH = LOW; // 큰수에 작은수 대입, //[3]
			LOW = R; // 작은수에 나머지 대입 //[4]

		}

		L = (A * B) / HIGH; // 최소공백수 구하기 : LCM(least common multiple)) //[5]

		System.out.println("L: " + L + ", HIGH : " + HIGH); // 출력
	}

	// 가장 많이 나타난 수 체크.
	public static void oftenNumber() {
		int[] data = { 1, 3, 4, 3, 5 };
		int mode = 0; // 최빈값이 담길 그릇
		int[] index = new int[6]; // 0~5까지 : 인덱스의 카운터
		int max = Integer.MIN_VALUE; // 최대값을 저장하기위한 변수 ; 초기값은 정수형의 최소값지정

		// [2] 처리
		for (int i = 0; i < data.length; i++) {
			index[data[i]]++; // COUNT
		}
		for (int i = 0; i < index.length; i++) {
			System.out.println("lee index[i] : " + index[i]);
			if (max < index[i]) {
				max = index[i]; // MAX
				mode = i; // 최빈값 : MODE
			}
		}

		// [3] 출력
		System.out.println("최빈값 : " + mode + " , " + max + "번"); // 3, 2번
	}

	/**
	 * 버블 정렬(Bubble Sort)은 인접한 두개의 원소를 비교하여 자리를 교환하는 방식으로 정렬 첫번째 원소부터 인접한 원소끼리 계속
	 * 자리를 교환하면서 맨 마지막자리로 이동하는 모습이 물속에서 물 위로 올라오는 물방울 모양과 같다고 해서 버블 정렬이라고 한다.
	 */
	public void bubbleSort() {
		int a[] = { 68, 9, 32, 2, 14, 7, 31, 26 };

		int size = a.length;
		for (int i = size - 1; i > 0; i--) {
			System.out.printf("\n버블 정렬 %d 단계 : ", size - i);
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
				}
				System.out.printf("\n\t");
				for (int v : a) {
					System.out.printf("%3d ", v);
				}
			}
		}
		System.out.println();
	}

	/**
	 * 삽입 정렬(Insert Sort)은 정렬되어 있는 부분집합에 새로운 원소의 위치를 찾아 삽입하는 정렬방식 S(Sorted)와
	 * U(Unsorted)
	 */
	public void insortionSort() {
		int a[] = { 68, 9, 32, 2, 14, 7, 31, 26 };
		int size = a.length;
		for (int i = 1; i < size; i++) {
			int temp = a[i];
			int j = i;
			while ((j > 0) && (a[j - 1] > temp)) {
				a[j] = a[j - 1];
				j--;
			}

			a[j] = temp;
			System.out.printf("\n삽입정렬 %d 단계 : ", i);
			for (int v : a) {
				System.out.printf("%3d ", v);
			}
		}
		System.out.println();
	}

	// 선택 정렬
	public static void selectionSort() {
//		가장크거나 가장 작은걸 하나씩 비교하면서 변경하는 정렬방식. n^2
		int[] array = { 10, 1, 3, 2, 4, 8, 6, 9, 5, 7 };
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
//				array[i] < array[j] 오름차순
//				array[i] > array[j] 내림차순
				if (array[i] < array[j]) {
					swap(array, i, j);
				}
			}

		}

		for (int i = 0; i < array.length; i++) {
			System.out.println("lee " + array[i]);

		}

	}

	// 조합
	public static void combination(int[] arr, int index, int n, int r, int target) {
//		nCr = n-1Cr-1 + n-1Cr
//		n 몇개의 숫자에서 고를건지.
//		r 몇개를 추출할 건지.
//		int[] arr = new int[5];
//
//		AlgorithmUtils.combination(arr, 0, 5, 3, 0);
		if (r == 0) {
			for (int i = 0; i < index; i++)
				System.out.println("leeaa : " + arr[i]);
		} else if (target == n)
			return;
		else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}

	// 순열
	public static void permutation(int[] arr, int depth, int number, int max) {
//		int[] arr = { 1, 2, 3, 4 };
//		perm(arr, 0, 4, 4);

		// 한번 depth 가 max로 도달하면 사이클이 돌았음. 출력함.
		if (depth == max) {
			for (int i = 0; i < max; i++) {
				if (i == max - 1)
					System.out.println(arr[i]);
				else
					System.out.print(arr[i] + ",");
			}
			return;
		}
		for (int i = depth; i < number; i++) {
			swap(arr, i, depth);
			permutation(arr, depth + 1, number, max);
			swap(arr, i, depth);
		}
	}

	
	// 행렬 변환. 90도씩 변환하는 행렬.
	public static int[][] RotateCube(int[][] matrix, boolean clock) {
		int[][] rotated = new int[matrix.length][matrix[0].length];
		int n = matrix.length;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (clock) {
					rotated[i][j] = matrix[n - j - 1][i];
				} else {
					rotated[i][j] = matrix[j][n - i - 1];
				}
			}
		}
		return rotated;
	}

	public static void minAndMax() {
		List<Integer> intList = Arrays.asList(1, 4, 3, 4, 9, 7, 1, 2, 5, 4, 3);
		System.out.println("lee : " + Collections.max(intList));
		System.out.println("lee : " + Collections.min(intList));
//		Collections.reverse(intList);
	}

	// 키파는 곱하기를 좋아한다. 그래서 키파는 수를 보면 각 자리 숫자를 모두 곱해서 하나의 수를 만든다. 키파는 기쁘다. 키파는 이 작업을
	// 계속해서 반복한다. 그런데 수가 한 자리가 되었다. 키파는 슬퍼졌다.
//
//	키파의 기쁨이 지속될 수 있는 것이 몇 단계인지를 출력하는 프로그램을 작성하시오. 예를 들어 679라면:
//
//		679 → 6*7*9 = 378 (1단계)
//		378 → 3*7*8 = 168 (2단계)
//		168 → 1*6*8 = 48 (3단계)
//		48 → 4*8 = 32 (4단계)
//		32 → 3*2 = 6 (5단계: 키파는 슬퍼졌다.)
//	키파는 5단계만에 슬퍼지므로 5를 출력하면 된다.
	public static void splitNumber(String input) {
		int count = 0;
		String[] str = input.split("");
		while (str.length != 1) {
			int num = 1;
			for (int i = 0; i < str.length; i++) {
				num *= Integer.parseInt(str[i]);
			}
			str = Integer.toString(num).split("");
			count++;
		}
		System.out.println("lee : " + count);
	}

	public int[] solution(int N) {
		int[] result = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int randomValue = (int) (Math.random() * 100) + 1;
			result[i] = randomValue;
			for (int j = 0; j < i; j++) {
				if (result[i] == result[j]) {
					i--;
					break;
				}
			}
		}

		for (int i = 0; i < N - 1; i++) {
			sum += result[i];
		}
		result[N - 1] = -sum;

		return result;
	}

	// 구분자 사용하기.
	public static int splitedString() {
		String example = "We test coders. Give us a try?";
		String[] splited = example.replace("!", ".").replace("?", ".").split("\\.");
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < splited.length; i++) {
			int length = splited[i].trim().split("\\s+").length;
			if (length > max) {
				max = length;
			}
		}
		return max;
//		List<String> test = Arrays.asList(splited);
//		for (int i = 0; i < test.size(); i++) {
//			System.out.println("lee  : " + test.get(i));
//		}
	}

	// 구분자 사용하기.
	public static void splitedInt() {
		String example = "2,3,4,5,6,7,3,2";
		String[] splitedString = example.split(",");
//		for(int i=0; i<splitedString.length;i++){
//			System.out.println("lee  : "+ splitedString[i]);
//		}
		List<String> test = Arrays.asList(splitedString);
		for (int i = 0; i < test.size(); i++) {
			System.out.println("lee  : " + test.get(i));
		}
	}

	// 거듭제곱 찾기. num = o * 2^p
//	24를 입력하면 3 * 2의3승      o=3, p=3
//n의 거듭제곱을 구하려면 2로 되어있는것을 n으로 변경해서 적용하고, num이 1이 되는것을 찾으면 된다.
	public static void getExponentiation(int num) {
		int i;
		for (i = 1; num % 2 == 0; i++) {

			num /= 2;
		}
		System.out.println("lee : " + num + "// " + (i - 1));
	}

	// 약수 모두 찾기. 12 -> 1,2,3,4,6,12
	public static void getPrimeNumbers(int num) {
		List<Integer> primeList = new ArrayList<>();
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				primeList.add(i);
				System.out.println("lee" + i);
			}
		}

	}

	// 완전 제곱수 확인. 4는 2*2 16은 4*4
	public static void exponentiation(int baseNumber, int inputNumber) {
		for (int i = 1; i < inputNumber; i++) {
			if (i * i == inputNumber) {
				System.out.println("lee exponentiation : ");
				return;
			}
		}
		System.out.println("lee no : ");
	}

	// 중복 제거 로직.
	public static void distinctDataFromList() {
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 5, 2, 1, 5);

		List<String> list = new ArrayList<String>();
		list.add("33");
		list.add("22");
		list.add("1111111111111111");
		list.add("22");
		list.add("4");
		list.add("33");
		list.add("aaa");
		list.add("baa");
		list.add("baa");
		list.add("aba");
		list.add("aba");
		list.add("aaa");

		// 해쉬셋은 중복은 제거해주지만 순서는 보장해주지 않는다.
		HashSet<String> distinctHash = new HashSet<>(list);
		// 트리셋은 중복제거와 정렬까지 해준다.
		TreeSet<String> distinctTree = new TreeSet<>(list);

		List<String> list2 = new ArrayList<String>(distinctTree);

		for (int i = 0; i < list2.size(); i++) {
			System.out.println("lee  : " + list2.get(i).toString());
		}

		// 중복만 제거할 때 가장 빠른 로직.
		List<String> resultList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (!resultList.contains(list.get(i))) {
				resultList.add(list.get(i));
			}
		}

	}

	public static void compare() {
		String[] array = new String[3];
		Arrays.sort(array, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}

		});
	}

	// 아나그램이란 ? 서로 다른 두 문자열이 있을때 두 문자열의 알파벳을 재배열하였을때 같은 단어 혹은 문장.
//	예를 들어, apple과 ppale는 아나그램 abcd와 bacd는 아나그램
	public static boolean checkAnagram(String str1, String str2) {
		// 공백 제거
		str1 = str1.replaceAll("\\s", "");
		str2 = str2.replaceAll("\\s", "");

		// 미리 문자열의 길이가 같은지 계산하여 1차적인 결과 수행
		if (str1.length() != str2.length()) {
			return false;
		}

		// 두 단어다 소문자로 변환 후 char 형식으로 변환해주는 toCharArray() 메서드 활용
		char[] char1 = str1.toLowerCase().toCharArray();
		char[] char2 = str2.toLowerCase().toCharArray();

		// Arrays.sort()를 이용하여 정렬을 한다.
		Arrays.sort(char1);
		Arrays.sort(char2);

		// String 비교를 위해 character 배열을 String으로 변환한다.
		String _str1 = new String(char1);
		String _str2 = new String(char2);

		// 비교한 결과를 리턴한다.
		return _str1.equals(_str2);
	}

	// 피보나치
	public static int fibo(int data) {
		if (data <= 1) {
			return 1;
		}

		return fibo(data - 1) + fibo(data - 2);
	}

	// 피보나치
	public static int memoFibo(int data) {
		int[] table = new int[10];
		if (data <= 1) {
			table[data] = 1;
			return 1;
		}

		if (table[data] > 0) {

			return table[data];
		}

		table[data] = memoFibo(data - 1) + memoFibo(data - 2);

		return table[data];
	}

	// factorial
	public static int fact(int data) {
		if (data <= 1)
			return 1;

		return fact(data - 1) * data;
	}

	// Math.Random();
	public static void randomQuiz() {

		for (int i = 0; i < 50; i++) {

			int randomValue = (int) (Math.random() * 10) + 1;
			System.out.println(randomValue);
		}
	}

	// 10진법을 원하는 진법으로 변환하는 로직.
	public static void toDeposition(int value, int i) {
		String returnString = "";
		String temp = "";

		while (value != 0) {

			// 나머지가 0~9 사이이면 캐릭터 값을 배열에 저장
			if ((value % i) < 10) {
				// 문자열 우->좌로 배열
				returnString = (value % i) + returnString;
				// 몫을 구함
				value /= i;
			}
			// 나머지가 10 이상이면 해당하는 값의 알파벳을 저장
			else {
				int temp1 = (char) ((value % i) + 55);

				returnString = Integer.toString(temp1) + returnString;
			}

		}

		System.out.println("lee " + returnString);

	}

	// 10진수 2진수로 변환
// 1이 남을 때 까지 계속 2로 나누어 주며 나머지를 배열에 저장한 후 거꾸로 출력해주면 2진수가 된다.
	public static void change10to2(int num) {
		int[] b = new int[100];

		int i = 0;
		while (num != 1) {
			b[i++] = num % 2;
			num = num / 2;
		}
		b[i] = num;

		for (int j = i; j >= 0; --j) {
			System.out.println("lee " + b[j]);
		}

	}

	// 홀,짝수 구하기.
	public static void getEvenNumber() {
		for (int i = -10; i <= 10; i++) {
			if (i % 2 == 0) {
//				짝수
			} else {
//				홀수
			}
		}
	}

	// 자릿수 구하기
	public static void findBit() {
		int[] nums = { 10000, -11, 111, 22, 33 };
		int length;

		for (int i = 0; i < nums.length; i++) {
			length = String.valueOf(Math.abs(nums[i])).length();
			System.out.println("lee length : " + length + "/// " + nums[i]);
		}
	}

	// 2자리수 구하기.
	public static void twobit() {
		int sum = 0;
		int[] nums = { 100001, -11 };
		int length;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 100000) {
				continue;
			}
			System.out.println("lee i" + i);
			if (nums[i] < 0) {
				length = -(int) (Math.log10(Math.abs(nums[i])) + 1);
			} else {
				length = (int) (Math.log10(nums[i]) + 1);
			}

			if (length == 2 || length == -2) {
				sum += nums[i];
				System.out.println("lee num" + nums[i] + "sum " + sum);
			}
		}

//		return sum;
	}

	// 소수 구하기. 에라스토테네스의 체를 이용.
	public static void onePickPrimeNumber(int number) {
		boolean isPrime = true;
		// 2부터 N-1의 수로 나눠서 나눠지는 수가 있으면 반복문 종료
		System.out.println("lee f time : " + System.currentTimeMillis());

		for (int i = 2; i <= Math.sqrt(number); ++i) {
			if (number / i == 0) {
				isPrime = false;
				break;
			}
		}

		if (isPrime) {
			System.out.println("lee prime");
		} else {
			System.out.println("lee not prime");
		}
		System.out.println("lee f time : " + System.currentTimeMillis());
	}

	// 여러개의 소수 구하기. 에라스토테네스의 체를 이용.
	public static void manyPickPrimeNumber(int max) {
		boolean[] array = new boolean[max + 1];
		int rootSqrt = (int) Math.sqrt(max);

		for (int i = 2; i <= max; i++) {
			array[i] = true;
		}

		for (int i = 2; i <= rootSqrt; i++) {
			if (array[i]) {
				for (int j = i; j * i < max; j++) {
					array[i * j] = false;
				}
			}
		}

//		for (int i = 2; i <= max; i++) {
//			if (array[i]) {
//				System.out.println("lee : " + i);
//			}
//		}

	}

	// 하나의 소수 구하기. 가장 기본적인 방법이지만 수가 커지면 시간 복잡도가 n제곱이 되어서 구림.
	public static void isPrimeNumber(int input) {
		int i = 2;
		while (input % i != 0) {
			i++;
		}
		if (input == i) {
			System.out.println("lee prime");
		} else {
			System.out.println("lee not prime");
		}
	}

	// 문자가 소수인지 확인
// https://www.acmicpc.net/problem/2153
//	알파벳 대소문자로 이루어진 영어 단어가 하나 있을 때, a를 1로, b를 2로, …, z를 26으로,
// A를 27로, …, Z를 52로 하여 그 합을 구한다. 예를 들어 cyworld는 합을 구하면 100이 되고, abcd는 10이 된다.
	public static void isStringPrimeNumber(String inputStr) {
		int strTotal = 0;

		for (int i = 0; i < inputStr.length(); i++) {
			char ch = inputStr.charAt(i);
			System.out.println("lee : " + ch + " number : " + (int) ch);
			if (ch >= 'A' && ch <= 'Z') {
				strTotal += (int) ch - 38;
			} else if (ch >= 'a' && ch <= 'z') {
				strTotal += (int) ch - 96;
			}
		}

		boolean check = false;

		for (int i = 2; i <= strTotal; i++) {
			if (i < strTotal && strTotal % i == 0) {
				break;
			}

			if (i == strTotal && strTotal % i == 0) {
				check = true;
			}
		}

		if (check || strTotal == 1) {
			System.out.println("It is a prime word.");
		} else {
			System.out.println("It is not a prime word.");
		}

	}

	public static void strongNumber(int input) {
		// 123 -> 1!+2!+3! = 9 (not strong) 145 -> 1!+4!+5! = 145 ( Strong)
		int sum = 0, remember = 0, temp = 0;

		while (input > 0) {
			remember = input % 10;
			int factorial = 1;
			for (int i = 0; i <= remember; i++) {
				factorial *= i;
			}
			input /= 10;
			sum += factorial;
		}

		System.out.println("lee " + sum);

	}

	// 숫자를 하나씩 쪼갠후에 더하기.
	public static void digSub(int input) {
		// 12345 -> 1+2+3+4+5 15
		int sum = 0, remember = 0;

		while (input > 0) {
			remember = input % 10;
			sum += remember;
			input /= 10;
		}

		System.out.println("lee " + sum);

	}

	// 반복문 없이 문자열 뒤집기.(재귀를 활용)
	public static void reverseRecursive(int a[], int begin, int end) {
		// begin과 end가 같아지는 경우는 a의 원소의 개수가
		// 홀수일때 인데 가운데 begin, end 둘 다 가운데 값을
		// 가르키고 있으므로 바꿀 필요가 없다.
		if (begin < end) {
			swap(a, begin, end);
			reverseRecursive(a, begin + 1, end - 1);
		}
	}

	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	// https://leetcode.com/problems/long-pressed-name/
	public static boolean isLongPressedName(String name, String typed) {
//		Input: name = "leelee", typed = "lleeelee"
//		Output: true
//		Input: name = "saeed", typed = "ssaaedd"
//		Output: false
//		Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.

		int i = 0, m = name.length(), n = typed.length();
		for (int j = 0; j < n; ++j) {
			if (i < m && name.charAt(i) == typed.charAt(j)) {
				++i;
			} else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
				return false;
			}
		}
		return i == m;
	}

	// 짝으로 되어진 수들의 배열에서 유일하게 짝이 없는 수를 찾는
	public static int singleNumber() {
		int[] nums = { 4, 1, 2, 1, 2 };

		int result = 0;
		for (int i : nums) {
//			System.out.println("lee " + i);
			result = result ^ i;
		}
		System.out.println("lee " + result);
		return result;
	}

	// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
	public static int removeDuplicatesFromSortedArray() {

		int[] nums = { 1, 1, 2, 2, 2, 3, 4, 4, 4, 5, 6, 7, 20, 30 };
		int point = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] < nums[i]) {
				nums[point] = nums[i];
				point++;
			}
		}

		for (int i = 0; i < point; i++) {
			System.out.println("lee" + nums[i]);
		}

		return point;
	}

	// https://leetcode.com/problems/two-sum/
	public static int[] twoSum(int target) {
//		Given nums = [2, 7, 11, 15], target = 9,
//		Because nums[0] + nums[1] = 2 + 7 = 9,
//		return [0, 1].
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 20, 30 };

		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (hash.containsKey(complement)) {
				return new int[] { hash.get(complement), i };
			}
			hash.put(nums[i], i);

		}
//
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < nums.length; i++) {
//			int complement = target - nums[i];
//			if (map.containsKey(complement)) {
//				return new int[] { map.get(complement), i };
//			}
//			map.put(nums[i], i);
//		}
		return null;
	}

	public static long getMonday(int year, String firstMonth) {
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy.MM.dd");
		Calendar c = Calendar.getInstance();

		int month = getMonth(firstMonth);

		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.WEEK_OF_MONTH, 1);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

		return c.getTime().getTime();

	}

	private int getWeeks(int Y, String A, String B, String W) {
		long calDate = getMonday(Y, A) - getSunday(Y, B);
		long calDays = Math.abs(calDate / (24 * 60 * 60 * 1000));
		int weeks = (int) (calDays / 7);
		if (weeks % 7 != 0) {
			weeks = weeks + 1;
		}
		return weeks;
	}

//특정 년,월,주 차에 일요일 구하기

	public static long getSunday(int year, String nextMonth) {
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy.MM.dd");
		Calendar c = Calendar.getInstance();

		int month = getMonth(nextMonth);

		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.WEEK_OF_MONTH, c.getActualMaximum(Calendar.WEEK_OF_MONTH));
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

		return c.getTime().getTime();
	}

	// 일을 숫자로 변환
	public static int getDay(String dayOfWeek) {
		Date date = null;
		try {
			date = new SimpleDateFormat("EEE").parse(dayOfWeek);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		return cal.get(Calendar.DAY_OF_WEEK);
	}

	// 월을 숫자로 변환
	public static int getMonth(String strMonth) {
		Date date = null;
		try {
			date = new SimpleDateFormat("MMM").parse(strMonth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		System.out.println("lee month : : " + cal.get(Calendar.MONTH));
		return cal.get(Calendar.MONTH);
	}

	private void timecheck() {
		long starttime = System.nanoTime();
		long endtime = System.nanoTime(); // 모든 코드가 실행되고 시간 저장 save time when your code ended
		long estimatedTime = endtime - starttime; // 시작점과 끝점을 계산하여 걸린 시간 측정 calculate the spending time of your code
		System.out.println(estimatedTime);
	}

	public static void iteratortest() {
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 5, 2, 1, 5);

//		List result1 = intList.stream().distinct().collect(Collectors.toList());
		Iterator<Integer> it = intList.iterator();

		ListIterator<Integer> iter = intList.listIterator();

		while (iter.hasNext()) {
			System.out.println("lee n index : " + iter.nextIndex());
			System.out.println("lee n list : " + iter.next());
		}

		while (iter.hasPrevious()) {
			System.out.println("lee index : " + iter.previousIndex());
			System.out.println("lee list : " + iter.previous());
		}

		while (it.hasNext()) {
			System.out.println("lee " + it.next());
		}
	}

}
