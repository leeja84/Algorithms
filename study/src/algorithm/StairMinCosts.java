package algorithm;

public class StairMinCosts {
	public static void main(String[] args) {
//		int[] cost = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int[] cost = new int[] { 1, 15, 30, 30};
		System.out.println(minCost(cost));
	}

	public static int minCost(int[] cost) {
		int case1 = 0, case2 = 0, current = 0;

		for (int i = cost.length - 1; i >= 0; --i) {
			current = cost[i] + Math.min(case1, case2);
			System.out.println("current : " + current + " / case1 : " + case1 + " / case2 : " + case2);
			case2 = case1;
			case1 = current;
		}

		return Math.min(case1, case2);
	}

}
