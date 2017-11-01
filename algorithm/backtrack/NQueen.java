package backtrack;
/* 从4皇后问题扩展的N皇后问题
 * 输入：整数n；
 * 输出：总共排列的方式以及美中排列方式的向量表达
 * 
 * 4皇后问题的例子如下：
4后问题
4后问题:在 4 × 4 的方格棋盘上放置4
个皇后，使得没有两个皇后在同一行、 同一列、也不在同一条45度的斜线上. 问有多少种可能的布局?
 解是4维向量< x1, x2, x3, x4 > 解: <2,4,1,3>，<3,1,4,2>
推广到8后问题
解: 8维向量，有 92个. 例如:<1,5,8,6,3,7,2,4>是解
http://introcs.cs.princeton.edu/java/23recursion/Queens.java.html
 */
import java.util.*;

public class NQueen {

	/***************************************************************************
	 * Return true if queen placement q[n] does not conflict with other queens
	 * q[0] through q[n-1]
	 ***************************************************************************/
	private static boolean isConsistent(int[] q, int n) {
		for (int i = 0; i < n; i++) {
			if (q[i] == q[n])
				return false; // same column
			if ((q[i] - q[n]) == (n - i))
				return false; // same major diagonal
			if ((q[n] - q[i]) == (n - i))
				return false; // same minor diagonal
		}
		return true;
	}

	/***************************************************************************
	 * Prints n-by-n placement of queens from permutation q in ASCII.
	 ***************************************************************************/
	private static void printQueens(int[] q) {
		int n = q.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (q[i] == j) {
					System.out.print("Q ");
				} else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	/***************************************************************************
	 * Try all permutations using backtracking
	 ***************************************************************************/
	public static void enumerate(int n) {
		int[] a = new int[n];
		enumerate(a, 0);
	}

	private static void enumerate(int[] q, int k) {
		int n = q.length;
		if (k == n) {
			// System.out.println("Found it:");
			printQueens(q);
		} else {
			for (int i = 0; i < n; i++) {
				q[k] = i;
				if (isConsistent(q, k))
					enumerate(q, k + 1);
				else {
					// System.out.println("Backtrack: "+k);
					// printQueens(q);
				}
			}
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		enumerate(n);
	}

}