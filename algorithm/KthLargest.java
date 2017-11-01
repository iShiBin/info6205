

//Assignment: Find the 3rd largest number in an unsorted array.

import java.util.Arrays;
public class KthLargest {
	public static int find(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return Integer.MAX_VALUE;
		return find(nums, 0, nums.length - 1, nums.length - k);
	}

	private static int find(int[] nums, int start, int end, int n) {
		n = Math.min(n, nums.length);
		assert start <= end;
		int pivot = nums[end];
		int left = start;
		for (int i = start; i < end; i++) {
			if (nums[i] <= pivot)
				swap(nums, left++, i);
		}
		swap(nums, left, end);
		if (left == n)
			return nums[left];
		else if (left < n)
			return find(nums, left + 1, end, n);
		else
			return find(nums, start, left - 1, n);
	}

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	public static void main(String[] args) {
		int k = 3;
		int[] numbers = { 4, 1, 9, 10 };
		System.out.println(find(numbers, k));
		System.out.println(Arrays.toString(numbers));
	}
}