package assignment;

import java.util.Arrays;
import util.DataBuilder;

public class KthLargest_Arrays {

	public static int find(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	public static void main(String[] args) {
		int k = 3;
		int[] numbers = DataBuilder.getNumbersInRange(10);

		System.out.println(Arrays.toString(numbers));
		System.out.println(find(numbers, k));
	}

}
