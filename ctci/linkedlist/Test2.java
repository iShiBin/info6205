package linkedlist;
public class Test2{
public static void main(String[] args){
/*
		// Solution2_1
		Node node = new Node(1);
		node.append(1);:
		node.append(2);
		node.append(3);
		node.append(2);
		node.append(2);

		System.out.println(node.toString());

		new Solution2_1().removeDupsII(node);
		System.out.println(node.toString());	
		
		// Solution2_2
		System.out.println("Solution2_2");
		LinkedListNode lln = new LinkedListNode();
		for(int i = 1; i < 10; i++){
			lln.append(i);
		}

		System.out.println(lln);
		LinkedListNode k = new Solution2_2().getKthToLast(lln, 30);
		System.out.println(k);

		//Solution2_4
		int[] nums = {3,5,8,5,10,2,1};
		int p = 5;
		lln = new LinkedListNode();
		for(int n:nums) lln.append(n);

		LinkedListNode partition = new Solution2_4().partition(lln,p);
		System.out.println(partition);
		
		// Solution2_5
		LinkedListNode a = new LinkedListNode(new int[]{7,1,6});
		LinkedListNode b = new LinkedListNode(new int[]{5,9,2});
		System.out.println(new Solution2_5().sumListsII(a,b));

		
		a = new LinkedListNode(new int[]{1});
		b = new LinkedListNode(new int[]{9,9,9,9,9,9,9});
		System.out.println(new Solution2_5().sumListsII(a,b));
		// Solution2_6
	    Solution2_6 solution2_6 = new Solution2_6();
		LinkedListNode list = new LinkedListNode(new int[]{1,2,3,2,1});
		System.out.println(solution2_6.isPalindrome(list));

		list = new LinkedListNode(new int[]{1,2,3,3,2,1});
		System.out.println(solution2_6.isPalindrome(list));

		list = new LinkedListNode(new int[]{3,2,1,9});
		System.out.println(solution2_6.isPalindrome(list));
    */
		// Solution2_7
		LinkedListNode list1 = new LinkedListNode(new int[]{1,3,5,7});
		LinkedListNode list2 = new LinkedListNode(new int[]{2,4,6,8});
		LinkedListNode node = new LinkedListNode(9);
		/*
		list1.append(node);
		list2.append(node);
		System.out.println(Solution2_7.isIntersected(list1, list2));
		System.out.println(Solution2_7.isIntersected0(list1, list2));
		*/

		// Solution2_8
		list1.append(node);
		list1.append(list2);
		list1.append(node);

		// System.out.println(Solution2_8.getLoopStart(list1));
		System.out.println(Solution2_8.getLoopStart0(list1));
}
}
