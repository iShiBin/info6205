package linkedlist;
/* Return Kth to Last
 *  Implement an algorithm to  nd the kth to last element of a singly linked list.
 */

public class Solution2_2{
	public LinkedListNode getKthToLast(LinkedListNode node, int k){
		LinkedListNode kth = node, runner = node;
		do{
			runner = runner.next;
		}while (--k > 0 && runner != null);

		while(kth != null && runner != null){
			kth = kth.next;
			runner = runner.next;
		}
		return new LinkedListNode(kth.data);
	}
}
