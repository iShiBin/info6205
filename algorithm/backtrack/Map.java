package backtrack;

import java.util.*;

/*图的着色问题
输入:
无向连通图 G和 m 种颜色的集合
用这些颜色给图的顶点着色，每个 顶点一种颜色. 要求是:G 的每条 边的两个顶点着不同颜色.
输出:所有可能的着色方案. 如果不存在着色方案，回答“No”.

解向量
设 G=(V,E)，V={1,2, ... , n} 颜色编号:1, 2, ... , m
解向量:<x1, x2, ..., xn>，
x1, x2, ..., xn∈{1,2, .., m }
结点的部分向量 <x1, x2 , ... , xk> x1, x2, ..., xk , 1 ≤ k ≤ n，
表示只给顶点1,2,...,k着色的部分方案

 */
public class Map {
	private static List<int[]> solutions = new ArrayList<>();
	private static int[][] map ;
	private static int n, m;
	
	public static void paint (int[][] map, int m) {
		Map.map = map;
		Map.n = map.length;
		Map.m = m ;
		int[] s = new int[n];
		Map.backtrack(s, 0);
		Map.print();
	}
	
	private static void backtrack (int[] s, int x) {
//		System.out.println("backtrack: "+ x + " " + Arrays.toString(s));
		if (x==s.length) {
			solutions.add(Arrays.copyOf(s, s.length));
			return ;
		} else {
			for (int i=1; i<=m; i++) {
				if (isFeasible(s,x,i)) {
					s[x] = i;
					backtrack (s, x+1);
				}
			}
		}
	}
//  The key is to design this term
	private static boolean isFeasible (int[] solution, int vertex, int color) {
		Set<Integer> set = new HashSet<>();
		for (int i=0;i<vertex;i++){
			if(map[i][vertex] == 1) {
				set.add(solution[i]);
			}
		}
		if (set.contains(color) || set.size() >= m) return false;
		else return true;
	}
	

	private static void print() {
		if (solutions.size() == 0) {
			System.out.println("No Solution!");
		} else {
			System.out.println("You can paint this map in " + solutions.size() + " ways as following:");
			for (int[] s : solutions) {
				System.out.println(Arrays.toString(s));
			}
		}
	}

	public static void main(String[] args) {
		int[][] map = new int[][] {
			{0,1,0,0,0,1,1},
			{1,0,1,0,0,0,1},
			{0,1,0,1,0,0,1},
			{0,0,1,0,1,1,0},
			{0,0,0,1,0,1,0},
			{1,0,0,1,1,0,1},
			{1,1,1,0,0,1,0}
		};
		int m = 3;
		Map.paint(map, m);
	}
}
