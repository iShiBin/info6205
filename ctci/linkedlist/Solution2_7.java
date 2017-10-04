package linkedlist;
import java.util.HashSet;

public class Solution2_7{
	public static boolean isIntersected(LinkedListNode list1, LinkedListNode list2) {
		if(list1==null || list2==null) return false;

		HashSet<LinkedListNode> set=new HashSet<>();
		LinkedListNode node1=list1, node2=list2;
		while(node1!=null){
			set.add(node1);
			node1=node1.next;
		}

		while(node2!=null){
			if(set.contains(node2)) return true;
			node2=node2.next;
		}
		return false;
	}

	public static boolean isIntersected0(LinkedListNode list1, LinkedListNode list2){
		if(list1==null || list2==null) return false;
		int l1=list1.getLength(), l2=list2.getLength();
		LinkedListNode lon=list1, sht=list2;
		if(l2>l1) {
			lon=list2;
			sht=list1;
		}
		int diff=l1>l2?l1-l2:l2-l1;
		
		/* incorrect code: 
        do{
			lon=lon.next;
		}while(--diff>0);
		*/

		while(--diff>=0){
			lon=lon.next;
		}
		System.out.println(lon.data);

		while(lon!=null && sht!=null){
			if(lon==sht) return true;
			lon=lon.next;
			sht=sht.next;
		}
		return false;
	}
}
