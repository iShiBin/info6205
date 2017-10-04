package assignments;

import java.util.*;

public class KthDistinctLargest {
	public static int find(int[] nums, int k) {
		k = Math.min(nums.length, k);
		PriorityQueue<Integer> queue = new PriorityQueue<>(k);
		int i = nums.length;
		while (k-- > 0) {
			queue.add(nums[--i]);
		}

		while (--i >= 0) {

			// pass it when the number is already in the queue
			if (!queue.contains(nums[i]) && nums[i] > queue.peek()) {
				queue.poll();
				queue.add(nums[i]);
			}
		}
		return queue.peek();
	}
}
