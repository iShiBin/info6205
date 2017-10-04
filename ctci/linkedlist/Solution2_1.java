package linkedlist;
/* Remove Dupss: Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary bu er is not allowed?
 */
import java.util.HashSet;

public class Solution2_1{
	public void removeDups(Node head){
		if(head == null) return ;

		Node previous = head, node = head;
		while( node != null)
			node = previous.next;

			if(isDups(head, node)) {
				previous.next = node.next;
			} else {
				previous = previous.next;
			}
		}

	private boolean isDups(Node head, Node node){
		Node iterator = head;
		while(iterator != node) {
			if (iterator.data == node.data) return true;
			iterator = iterator.next;
		}
		return false;
	}

	public void removeDupsII(Node n){
		HashSet<Integer> set = new HashSet<>();

		Node previous = null;
		while( n != null){
			if (set.contains(n.data)){
				previous.next = n.next;
			} else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}
}
// 12min
// Time: O(n); Space: O(1)
