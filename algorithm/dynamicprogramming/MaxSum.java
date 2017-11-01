package dynamicprogramming;

import java.util.Arrays;

/**
 * 最大子段和 问题:给定n个数(可以为负数)的序列 (a1, a2, ... , an) 求最大连续大的字段和。
 * 
 * 实例：(-2, 11, -4, 13, -5, -2) 解:最大子段和为 a2+a3+a4=20
 * 
 * @author bin
 * @since 2017/04/18
 */
public class MaxSum {

	private static int maxSum = -1;
	private static int[] maxSumSeq;
	
	private static void compute(int[] nums){
		int maxSum = 0, tempMax = 0, endIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (tempMax>0) { tempMax+= nums[i];} //如果tempMax还大于0，那么一直往后继续遍历；否则从当前位置开始重新打算
			else tempMax = nums[i];
			
			if (maxSum < tempMax) { //因为只需要最值，一遍遍历即可！
				maxSum = tempMax;
				endIndex = i; //记录下最大值时候原序列结束的位置
			}
		}
		int startIndex = endIndex, backtrackSum=0;
		
		while(backtrackSum<maxSum){
			backtrackSum+=nums[startIndex--];
		}
		
		MaxSum.maxSum = maxSum;
		MaxSum.maxSumSeq = Arrays.copyOfRange(nums, startIndex+1, endIndex+1);
	}
	
	public static int[] getMaxSumSeq(int[] nums) {
		if(maxSum == -1) compute(nums);
		return maxSumSeq;
	}
	
	public static int getMaxSum(int[] nums){
		if(maxSum == -1) compute(nums);
		return maxSum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {-2, 11, -4, 13, -5, -2};
		System.out.println(Arrays.toString(MaxSum.getMaxSumSeq(n)));
		System.out.println(MaxSum.getMaxSum(n));
		
		
	}

}
