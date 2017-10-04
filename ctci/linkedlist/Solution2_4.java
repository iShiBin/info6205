package linkedlist;
/* Partitio
 * Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x. 
 * If x is contained within the list, the values of x only need to be after the elements less than x (see below). 
 * The partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1[partition=5]
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */

public class Solution2_4{
	public LinkedListNode partition(LinkedListNode node, int x){
		LinkedListNode head = node, tail = node;
		while(node != null){
			LinkedListNode next = node.next;
			if(node.data < x) {
				// insert node at head
				node.next = head;
				head = node;
			} else {
				// insert node at tail
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		
		// return to the new head to the user
		return head;
	}
}
