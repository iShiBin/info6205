package linkedlist;
/* Delete Middle Node
 * Implement an algorithm to delete a node in the middle 
 * (i.e., any node but the  rst and last node, not necessarily the exact middle) of a singly linked list, 
 * given only access to that node.
 * EXAMPLE
 * lnput:the node c from the linked lista->b->c->d->e->f
 * Result: nothing is returned, but the new linked list looks likea->b->d->e- >f
 */
public class Solution2_3{
	/*
	public void deleteMiddleNode(LinkedListNode head, LinkedListNode del){
		LinkedListNode node = head ;
		while(node.next != del){
			node = node.next;
		}
		node = node.next.next;
	}
	*/
	// wrong understanding the first time.
	// think 1'03; code 4'56; correct 1'04; re-write 06'04 
	//
	public void deleteNode(LinkedListNode n) {
		if(n == null || n.next == null) return ;
		LinkedListNode next = n.next;
		n.data = next.data;
		n.next = next.next;
	}
}

