package dynamicprogramming;

import java.util.Arrays;

/**
 * @author bin
矩阵链相乘
问题:设 A1, A2 , ... , An 为矩阵序列， Ai 为 Pi-1* Pi 阶矩阵，i = 1, 2, ... , n. 
	试确定矩阵的乘法顺序，使得元素相乘的总次数最少.
输入:向量 P = < P0, P1, ... , Pn >，其中 P0, P1, ..., Pn为 n 个矩阵的行数 与列数
输出:矩阵链乘法加括号的位置

实例
实例: P = <10, 100, 5, 50>
A1: 10*100, A2: 100*5, A3: 5*50,
乘法次序
(A1A2)A3: 10*100*5+10*5*50 = 7500
A1(A2A3): 10*100*50+100*5*50=75000
第一种次序计算次数最少.

程序测试数据：
P = < 30, 35, 15, 5, 10, 20 >
矩阵链:A1 A2 A3 A4 A5，其中
A1: 30×35，A2: 35×15，A3: 15×5，A4: 5×10，A5: 10×20
备忘录:存储所有子问题的最小乘法 次数及得到这个值的划分位置
输出
计算顺序: (A1(A2A3))(A4A5) 最少的乘法次数:m[1,5]=11875
 */

public class MatrixMultiplication {
	private static long leastMtpTimes = -1;
	private static long[][] m, s;
	public static long caculateLeastTime(int[] p){
		int n = p.length;
		m = new long[n][n]; s = new long[n][n];
		
		// Set M[1][] = 0 since no multiplication is needs if there is only one matrix
		Arrays.fill(m[1], 0);
		
		for(int r=2;r<n;r++){ //r为链长
			for(int i=1; i<n-r+1;i++){ //左边界 i
				int j = i+r-1; //右边界 j
				m[i][j] = m[i+1][j] + p[i-1]*p[i]*p[j]; //赋初值
				s[i][j] = i; //记录k
				
				for(int k=i+1;k<j-1;k++){//用k来遍历所有划分
					long t = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
					if (t<m[i][j]){
						m[i][j] = t;
						s[i][j] = k;
					}
				}
			}
		}
		for(long[] l:m){
			System.out.println(Arrays.toString(l));
		}
		leastMtpTimes = m[1][n-1];
		return leastMtpTimes;
	}
	

	public static void main(String[] args){
		int[] matrixChain = {30, 35, 15, 5, 10, 20};
		long n = caculateLeastTime(matrixChain);
		System.out.println(n);
	}
}

