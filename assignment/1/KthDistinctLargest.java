package assignment;

import java.util.PriorityQueue;

public class KthDistinctLargest {

	public static int find(int[] nums, int k) {
		k = Math.min(nums.length, k);

		PriorityQueue<Integer> queue = new PriorityQueue<>(k);

		int i = nums.length;
		while (k-- > 0) {
			queue.add(nums[--i]);
		}
		System.out.println(queue);

		while (--i >= 0) {

			// pass it when the number is already in the queue
			if (!queue.contains(nums[i]) && nums[i] > queue.peek()) {
				queue.poll();
				queue.add(nums[i]);
			}
		}

		return queue.peek();

	}

	public static void main(String[] args) {
		int k = 3;
		int[] numbers = { 7, 4, 7, 4, 9, 1, 4, 1, 9, 10 };
		System.out.println(find(numbers, k));
	}

}
