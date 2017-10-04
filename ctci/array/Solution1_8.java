package array;
public class Solution1_8{
	public void setZeroes(int[][] matrix){
		if(matrix == null) return;
		int m = matrix.length, n = matrix[0].length;
		boolean[] lines = new boolean[m], columns = new boolean[n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(matrix[i][j] == 0) {
					lines[i] = true;
				    columns[j] = true;
				}
			}
		}

		for(int i = 0; i < m; i++){
			if(lines[i]){
				for(int j = 0; j < n; j++) matrix[i][j] = 0;
			}
		}

		for(int j = 0; j < n; j++){
			if(columns[j]) {
				for(int i = 0; i < m; i++) matrix[i][j] = 0;
			}
		}
	}

	// one way to improve is to use the first row and column to store the status of 0
}
// Time: O(m*n); Space: O(m+n)
// https://leetcode.com/problems/set-matrix-zeroes/description/
/* Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
