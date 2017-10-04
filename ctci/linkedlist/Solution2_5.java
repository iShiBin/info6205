package linkedlist;
/* Sum List
 * You have two numbers represented by a linked list, where each node contains a single digit.The digits are stored in reverse order, 
 * such that the 1 's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked lis
 * EXAMPLE
 * Input:(7-> 1 -> 6) + (5 -> 9 -> 2).Thatis,617 + 295. Output:2 -> 1 -> 9.Thatis,912.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE: lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295. Output:9 -> 1 -> 2.Thatis,912.
 */
import java.math.BigInteger;

public class Solution2_5{
	public LinkedListNode sumLists(LinkedListNode a, LinkedListNode b){
		if(a == null) return b;
		if(b == null) return a;

		LinkedListNode head = new LinkedListNode(), node = head;
		int sum = 0, carry = 0;
		while( a != null && b != null){
			sum = a.data + b.data + carry;
			node.append(sum % 10);
			carry = sum / 10;
			a = a.next;
			b = b.next;
		}
		
		LinkedListNode left = (a==null)?b:a;
		if(carry != 0) {
			node.append(sumLists(left, new LinkedListNode(carry)));
		}
		return head.next;
	}

	public LinkedListNode sumListsII(LinkedListNode a, LinkedListNode b){
		BigInteger x = getBigInteger(a), y = getBigInteger(b);
		BigInteger sum = x.add(y);
		LinkedListNode node = new LinkedListNode();
		for(char ch:sum.toString().toCharArray()){
			node.append(ch - '0');
		}
		return node.next;
	}

	private BigInteger getBigInteger(LinkedListNode node){
		StringBuilder builder = new StringBuilder();
		LinkedListNode iterator = node;
		while(iterator!= null) {
			builder.append(iterator.data);
			iterator = iterator.next;
		}
		System.out.println("The BigInteger is: "+ builder);
		return new BigInteger(builder.reverse().toString());

	}

}
// Think 7'; Code 11'
// Time: O(max(m,n)); Space: O(max(m,n))

