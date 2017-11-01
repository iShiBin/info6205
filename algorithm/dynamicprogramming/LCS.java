package dynamicprogramming;
import java.util.*;

/**longest common subsequence (LCS) problem
 * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 * The longest common subsequence (LCS) problem is the problem of finding the longest subsequence common to all sequences in a set of sequences (often just two sequences). 
 * It differs from problems of finding common substrings: unlike substrings, subsequences are not required to occupy consecutive positions within the original sequences.
 * 
 * 最长公共子序列
 * 问题：给定序列 X=x1,x2,x3...xm; Y=y1,y2,y3...yn，求X和Y的最长公共子序列,示例如下：
 * X：ABCBDAB
 * Y: BDCABA
 * 最长公共子序列：BCBA 长度4
 * 
 * @author bin
 * date 2017/4/13
 */

public class LCS {
	private static int longestCommonSubsequenceLength;
	private static StringBuilder longestCommonSubsequence;
	
	public static String get(String X, String Y){
		if(X.length()==0 || Y.length()==0) return new String(); 
				
		int m = X.length(), n=Y.length();
		int[][] C = new int[m+1][n+1];
		int[][] B = new int[m+1][n+1]; // B is for tracking the result
		//the default value of C is 0, so no need to initialize it.
		for(int i=1;i<=m;i++){ //*** key!!! Build the C and B matrix. dynamic programming
			for(int j=1;j<=n;j++){
				if(X.charAt(i-1) == Y.charAt(j-1)){
					C[i][j] = C[i-1][j-1] + 1;
					B[i][j] = 1;
				} else {
					if(C[i-1][j] >= C[i][j-1]){
						C[i][j] = C[i-1][j];
						B[i][j] = -1;
					} else {
						C[i][j] = C[i][j-1];
						B[i][j] = -2;
					}
				}
			}
		}
//		System.out.println("Value");
//		for(int[] nums:C) System.out.println(Arrays.toString(nums));
//		System.out.println("Track");
//		for(int[] nums:B) System.out.println(Arrays.toString(nums));
		
		LCS.longestCommonSubsequenceLength = C[m][n];
		trackLCS(X,B);
		return LCS.longestCommonSubsequence.reverse().toString();
	}
	
	private static void trackLCS(String X, int[][] B){
		longestCommonSubsequence = new StringBuilder();
		int i = B.length-1, j=B[0].length-1;
		while(i>0 && j>0){
			if(B[i][j]==1) {
				longestCommonSubsequence.append(X.charAt(i-1));
				i--;
				j--;
			}
			else if (B[i][j]==-1) i--;
			else if(B[i][j]==-2) j--;
			else System.out.println("invalid track table");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String X="ABCBDAB", Y="BDCABA";
		System.out.println(LCS.get(X, Y));
		
		//Another test case: Let  X X be “XMJYAUZ” and  Y Y be “MZJAWXU”. The longest common subsequence between  X X and  Y Y is “MJAU”.
		System.out.println(LCS.get("XMJYAUZ", "MZJAWXU"));
	}
}
