package sort;
import java.util.Arrays;

public class MergeSort {

	public static void sort(int[] nums) {
		sort(nums, 0, nums.length - 1);
	}

	private static void sort(int[] nums, int low, int high) {
		if (low >= high)
			return;
		int mid = (low + high) / 2;
		sort(nums, low, mid);
		sort(nums, mid, high);
		merge(nums, low, high);
	}

	private static void merge(int[] nums, int low, int high) {
		int mid = (low + high) / 2;
		int[] temp = new int[high - low + 1];

		int i = low, j = mid + 1, index = 0;
		while (i <= mid && j <= high) {
			if (nums[i] < nums[j]) {
				temp[index++] = nums[i++];
			} else {
				temp[index++] = nums[j++];
			}
		}

		while (i < mid)
			temp[index++] = nums[i++];
		while (j < high)
			temp[index++] = nums[j++];

		i = low;
		for (int k = 0; k < nums.length; k++)
			nums[i++] = temp[k];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = { 6, 5, 3, 1, 8, 7, 2, 4 };
		sort(n);
		System.out.println(Arrays.toString(n));
	}

}
