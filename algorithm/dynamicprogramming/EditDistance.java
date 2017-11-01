package dynamicprogramming;

import java.util.Arrays;

/**Defining Min Edit Distance (Levenshtein)
 * ref. https://web.stanford.edu/class/cs124/lec/med.pdf
 * @author bin
 * @2017/04/21
 */
public class EditDistance {
	private final static int substituteWeight = 2;
	private static int minDistance;
	public static int getMinDistance(String x, String y){
		int m=x.length(), n=y.length();
		int[][] D = new int[m+1][n+1];
		
		//initialization
		for(int i=0;i<=m;i++){
			D[i][0] = i;
		}
		for(int j=0;j<=n;j++){
			D[0][j] = j;
		}
		print(D);
		//Recurrence Relation
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				int delete = D[i-1][j]+1;
				int insert = D[i][j-1]+1;
				int substitute = D[i-1][j-1];
				substitute += x.charAt(i-1)==y.charAt(j-1)?0:substituteWeight;
				D[i][j] = Math.min(Math.min(delete, insert), substitute);
			}
		}
		print(D);
		minDistance = D[m][n];
		return minDistance;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "INTENTION", y = "EXECUTION";
		int n = EditDistance.getMinDistance(x, y);
		System.out.println(n);
	}
	private static void print(int[][] D){
		for(int[] l:D){
			System.out.println(Arrays.toString(l));
		}
		System.out.println();
	}

}
