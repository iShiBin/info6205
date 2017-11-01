package sort;

import java.util.Arrays;

//https://en.wikipedia.org/wiki/Quicksort

public class QuickSort {
	public static void sort(int[] nums) {

		if (nums.length < 1)
			return;
		sort(nums, 0, nums.length - 1);
	}

	private static void sort(int arr[], int left, int right) {
		int index = partition(arr, left, right);
		System.out.println(index+","+Arrays.toString(arr));
		if (left < index - 1)
			sort(arr, left, index - 1);
		if (index < right)
			sort(arr, index, right);
	}

	public static int partition(int arr[], int left, int right) {
		int i = left, j = right, m=i+(j-i)/2;
		int pivot = arr[m];

		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		
		// i and j meet in the right in order position for arr[m]
		return i;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1,4,2,3,5};//, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6 };
		//nums = new int[]{1,12,5,26,7,14,3,7,2};
		sort(nums);
		System.out.println("Sorted:" + Arrays.toString(nums));
	}
}
