package assignment;

import java.util.*;
import util.*;

public class KthLargest_PriorityQueue {

	public static int find(int[] nums, int k) {
		k = Math.min(nums.length, k);

		PriorityQueue<Integer> queue = new PriorityQueue<>(k);

		int i = nums.length - 1;
		while (k-- > 0) {
			queue.add(nums[i--]);
		}

		while (i-- > 0) {
			if (nums[i] >= queue.peek()) {
				queue.poll();
				queue.add(nums[i]);
			}
		}

		return queue.peek();

	}

	public static void main(String[] args) {
		int k = 3;
		int[] numbers = DataBuilder.getNumbersInRange(10);

		System.out.println(Arrays.toString(numbers));
		System.out.println(find(numbers, k));
	}

}
// T: O(log(n)); S:O(n)