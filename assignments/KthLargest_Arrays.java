package assignment;

import java.util.Arrays;

public class KthLargest_Arrays {
	public static int find(int[] nums, int k) {
		int n = Math.min(k, nums.length);
		Arrays.sort(nums);
		return nums[nums.length - n];
	}
	
	public static void main(String[] args) {
		int k = 3;
		int[] numbers = { 2,1 };
		System.out.println(find(numbers, k));
	}
	
}
