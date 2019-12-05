package lee.test;

public class Algorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

	public static void test() {
		int[] input = { 3, 2, 5, 4, 1, 2, 4, 2, 1 };
		int[] result = new int[input.length];
		int max = 0;

		for (int i = 0; i < input.length; i++) {
			if (max < input[i]) {
				max = input[i];
			}
		}

		int[] count = new int[max + 1];

		for (int i = 0; i < input.length; i++) {
			count[input[i]]++;
		}

		for (int i = 0; i < input.length - 1; i++) {
			int frequency = -1;
			int mark = 1;
			for (int j = i + 1; j < input.length; j++) {
						
//				System.out.print("  compare : " + count[input[i]] + " // " +  count[input[j]] );
				if(j < mark) {
//					System.out.print("  compare : " + count[input[i]] + " // " +  count[input[j]] );					
					frequency = input[mark];					
					break;
				}
				
				if (count[input[i]] < count[input[j]]) {
					frequency = input[j];
					mark = j;
//					System.out.println("final :  " + frequency);
					break;
				}
//				System.out.println("second final :  " + frequency);
				frequency = -1;

			}
			result[i] = frequency;
		}

		for (int i = 0; i < result.length-1; i++) {
			System.out.print(result[i] + ", ");
		}

	}

}
