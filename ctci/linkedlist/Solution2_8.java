package linkedlist;
import java.util.HashSet;

public class Solution2_8{
	public static LinkedListNode getLoopStart(LinkedListNode head){
		HashSet<LinkedListNode> set=new HashSet<>();
		LinkedListNode node=head;
		while(node!=null && !set.contains(node)){
			set.add(node);
			node=node.next;
		}
		return node==null?null:new LinkedListNode(node.data);
	}

	public static LinkedListNode getLoopStart0(LinkedListNode head){
		LinkedListNode slow=head, fast=head;

		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) break;
		}

		if(fast==null || fast.next==null) return null;

		slow=head;
		while(slow!=fast){
			slow=slow.next;
			fast=fast.next;
		}

		return new LinkedListNode(fast.data);
	}
		
}
