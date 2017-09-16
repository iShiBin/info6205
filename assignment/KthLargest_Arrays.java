package assignment;

import java.util.Arrays;

public class KthLargest_Arrays {

	public static int find(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
}
