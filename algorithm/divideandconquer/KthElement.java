package divideandconquer;
import sort.*;
import java.util.*;
//Leetcode: 215. Kth *Largest* Element in an Array - https://leetcode.com/problems/kth-largest-element-in-an-array/#/description
//Choose the pivot wisely. In this case,if you choose the middle one, you will regret, because it will be very complicated 
//if the array contains duplicated elements.

public class KthElement {
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
	    return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
	}    

	public int findKthLargest(int[] nums, int start, int end, int k) {// quick select: kth smallest
		if (start > end) return Integer.MAX_VALUE;
		
		int pivot = nums[end];// Take A[end] as the pivot, 
		int left = start;
		for (int i = start; i < end; i++) {
			if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
				swap(nums, left++, i);			
		}
		swap(nums, left, end);// Finally, swap A[end] with A[left]
		
		if (left == k)// Found kth smallest number
			return nums[left];
		else if (left < k)// Check right part
			return findKthLargest(nums, left + 1, end, k);
		else // Check left part
			return findKthLargest(nums, start, left - 1, k);
	} 

	void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;				
	}
	
}