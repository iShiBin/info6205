package linkedlist;
/* Palindrome: Implement a function to check if a linked list is a palindrome */
import java.util.Stack;

public class Solution2_6 {
	public boolean isPalindrome(LinkedListNode head) {
		LinkedListNode current = head, runner = head;
		Stack<Integer> stack = new Stack<>();
		if(current != null && runner != null) {
			current = current.next;
			runner = runner.next;
			if(runner != null) runner = runner.next;
		}
		while(runner != null) {
			stack.push(runner.data);
            runner = runner.next;       
		}
		current = head;
		while(!stack.isEmpty()){
			if(current.data != stack.pop().intValue()) return false;
            current = current.next;
		}
		return true;
	}
}
