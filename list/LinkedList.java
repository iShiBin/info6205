package list;

public class LinkedList {
	Node head, next;
	
	LinkedList(){};
	LinkedList(int v) { head = new Node(v); }
	
	public int length(){
		return 0;
	}
	
	public void addNode(int value){
		next = new Node(value);
	}
	
	public Node findKthFromEnd (int k){
		
		if(head == null) return null;
		
		Node front = head;
		Node back = head;
		
		while(k>0 && front != null){
			front = front.next;
		}
		
		while(front != null){
			front = front.next;
			back = back.next;
		}
		
		return back;
	}
	
	public boolean isCircling (){
		if(head == null || head.next == null) return false;
		
		Node front = head;
		Node back = head;
		
		while(front != null && back != null){
			front = front.next;
			if(front != null){
				front = front.next;
			}
			back = back.next;
		}
		
		return true;
	}
	
	//question: where is the start of the circle?
	//front moves two steps forward every time whiel back moves one every time
	
	public Node findStartOfCircle(){
		return null;
	}
	
	public Node findTail(){
		if(head == null || this.isCircling()) return null;
		
		Node tail = head;
		while(tail.next != null){
			tail = tail.next;
		}
		return tail;
	}
	
	//create a circle from the nth from the end
	public void createCircle(int n){
		
	}
	
	//find the middle of the list: one pointer move 2 steps each time and the other move 1 each time
	//when the faster reach to the end, the slower reaches to the middle
	
	public Node getMidNode(){
		if(head == null) return null;
		
		Node fast = head, slow = head;
		while(fast != null){
			fast = fast.next;
			if(fast != null){
				fast = fast.next;
			}
			
			slow = slow.next;
		}
		return slow;
	}
	
	//split the list into two parts, and get the back list
	
	public Node split() {
		if(head == null || head.next == null) return null;
		
		
		return getMidNode();
	}
	
	//figure out whether this is a palindrome
	public boolean isPalindrome(){
		
		if(head == null || head.next == null) return true;
		
		Node split = split();//.reverse(); -- todo: define
		Node temp = head;
		while(temp != null){
			// compare and return;
		}
		
		return true;
	}
	
	//***************tow lists**************
	//merge two sorted linked list
	
	public LinkedList mergeSortedList(LinkedList list){
		if(this == null) return list;
		if(list == null) return this;
		
		//recursion
//		if(this)
//		
		return null;
	}
	
	//zipmerge: take one from the front and one from the end
	
	public LinkedList zipMerge(){
		//todo: recursion and iteration versions [homework] *****
		return null;
	}
	
	//two linkedlist intersect . lab: use mem address and set
//	public boolean findIntersection(LinkedList list){
//		
//	}
//	
	//todo: merge sort for a linkedlist [homework]******
	
	public static void main(String[] args){
		LinkedList list = new LinkedList();
		
		int n = 10;
		
		for(int i=1; i<=10;i++){
			
		}
	}
	
}
