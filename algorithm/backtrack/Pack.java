package backtrack;

import java.util.Arrays;

/**
 * 0-1背包问题 问题: 有n种物品，每种物品只有 1个. 第i 种 物品价值为 vi , 重量为 wi , i =1,2,..., n.
 * 问如何选择放入背包的物品，使得总 重量不超过 B, 而价值达到最大?
 * 
 * 实例: V={12,11,9,8}, W={8,6,4,3}, B=13 最优解: <0,1,1,1>，价值: 28，重量: 13
 * 
 * @author bin
 *
 */
public class Pack {
	private static int LIMIT = 0, max = -1;
	private static int[] V, W;
	private static int[] S ;

	public static int[] sack(int[] values, int[] weights, int limit) {
		LIMIT = limit;
		V = values;
		W = weights;
		int[] solution = new int[weights.length];
//		bruteforce(solution, 0);
		backtrack(solution, 0, LIMIT);
		System.out.println("Optimal Solution: " + Arrays.toString(S));
		System.out.println("Value: " + max);
		System.out.println("Weight: " + measureWeight(S));
		return solution;
	}

	private static void bruteforce(int[] solution, int k) {
		if (k >= solution.length) {
			if (measureWeight(solution) <= LIMIT && max < measureValue(solution)) {
				max = measureValue(solution);
				S = Arrays.copyOf(solution, solution.length);
				// System.out.println(Arrays.toString(S) + " " +
				// measureWeight(solution));
			}
		} else {
			solution[k] = 0;
			bruteforce(solution, k + 1);

			solution[k] = 1;
			bruteforce(solution, k + 1);

		}
	}
	
	private static void backtrack(int[] solution, int k, int limit) {
		if (k >= solution.length) {
			if (max < measureValue(solution)) {
				max = measureValue(solution);
				S = Arrays.copyOf(solution, solution.length);
//				System.out.println(Arrays.toString(S) + " " + measureWeight(solution));
			}
		} else {
			if (limit - W[k] >= 0) {
				solution[k] = 1;
				backtrack(solution, k + 1, limit - W[k]);
			}
			solution[k] = 0;
			backtrack(solution, k + 1, limit);
		}
	}

	private static int measureValue(int[] solution) {
		int n = 0;
		for (int i = 0; i < solution.length; i++) {
			n += V[i] * solution[i];
		}
		return n;
	}

	private static int measureWeight(int[] solution) {
		int n = 0;
		for (int i = 0; i < solution.length; i++) {
			n += W[i] * solution[i];
		}
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = { 12, 11, 9, 8 }, weights = { 8, 6, 4, 3 };
		int limit = 13;
		
		values = new int[]{9,10,7,4};
		weights = new int[]{3,5,2,1};
		limit = 7;
		Pack.sack(values, weights, limit);
	}
}
