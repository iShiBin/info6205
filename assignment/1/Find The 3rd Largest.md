# Find the 3rd Largest Number in an Unsorted Array

Given a non-empty array of integers, return the third maximum number in this array.  
If it does not exist, return the minimum number.

>Example 1:  
Input: [3, 2, 1]  
Output: 1  
Explanation: The third maximum is 1.  

>Example 2:  
Input: [1, 2]  
Output: 2  
Explanation: The third maximum does not exist, so the maximum (2) is returned instead.  

>Example 3:  
Input: [2, 2, 3, 1]  
Output: 2  
Explanation: Note that the third maximum here means the third maximum number.  
Both numbers with value 2 are considered as different maximum numbers.  

# Approach I: Use quick sort
To generalize this problem, I would like to find the Kth largest element in an array. The set a parameter (k=3) to get the 3rd largest number.

## Algorithm

Here is the quick sort algorithm:
* Take a number in this array a pivot number, such as the last number
* Divide the array to two halve, the left of which is smaller or equal than the pivot, while the right is bigger
* Switch the position of the pivot number and the partition
* Continue to do so when the partition position hits (array's length - k)
>Note: Quick sort is in ascending order to the kth largest means the (length-k) smallest

## Implementation 

**Java**  

```java
public class KthLargest {

	public static int find(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return Integer.MAX_VALUE;

		return find(nums, 0, nums.length - 1, nums.length - k);
	}

	private static int find(int[] nums, int start, int end, int k) {
		k = Math.min(k, nums.length);

		assert start <= end;

		int pivot = nums[end];
		int left = start;
		for (int i = start; i < end; i++) {
			if (nums[i] <= pivot)
				swap(nums, left++, i);
		}

		swap(nums, left, end);

		if (left == k)
			return nums[left];
		else if (left < k)
			return find(nums, left + 1, end, k);
		else
			return find(nums, start, left - 1, k);
	}

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		int k = 3;
		int[] numbers = { 7, 4, 7, 4, 9, 1, 4, 1, 9, 10 };
		System.out.println(find(numbers, k));
	}

}
```

## Complexity
**Time**: $O(log n)$. It is similar to the quick sort.  
**Space**: $O(1)$. Constant space only.

# Approach II: Use Arrays.sort() function

## Algorithm
A quite obvious solution is to sort this array in a natural order and then output the Kth element from the end.

## Implementation
**Java**

```java
public class KthLargest_Arrays {

	public static int find(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
}
```    
Note: The main() in the previous approach could be used to test this solution.

## Complexity
**Time**: $O(log n)$. Arrays.sort() is a quick sort solution, so the complexity is $O(log n)$.  
**Space**: $O(1)$. Constant space only.

# Approach III: Use PriorityQueue

## Algorithm
* Create a priority queue with size k
* Put the last k elements in the queue as a start
* Continue to iterator this array forward
  * if the current number nums[i] > the head element in this array (which is also the smallest since the priority queue sorted the elements in a natural order)   
  * remove the head element and put this number nums[i] in the queue
 * End when it reaches the first element, and the first number in the queue is the result
 
 ## Implementation
 **Java**  
 ```java
 public class KthLargest_PriorityQueue {

	public static int find(int[] nums, int k) {
		k = Math.min(nums.length, k);

		PriorityQueue<Integer> queue = new PriorityQueue<>(k);

		int i = nums.length - 1;
		while (k-- > 0) {
			queue.add(nums[i--]);
		}

		while (i-- > 0) {
			if (nums[i] > queue.peek()) {
				queue.poll();
				queue.add(nums[i]);
			}
		}

		return queue.peek();

	}
}
```

## Complexity
**Time**: $O(n*log n)$. Like insertion sort, the worst case if the array is in a descending order when k = length.
**Space**: $O(k)$. Obviously, we need a queue with size k to hold the first largest k elements.

# Follow-up
What if asking for the Kth distinct largest number?
>Example:
Input: [2, 2, 3, 1]
Output: 1

>Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.

To achieve this, we need to modify the condition when comparing the data with the pivot/guard. This is the solution using PriorityQueue.

**Java**  
```java
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
```
# Conclusion

These three implementations have the same level of time complexity $O(n*log(n))$. However, the first one are most efficient in average. 
 