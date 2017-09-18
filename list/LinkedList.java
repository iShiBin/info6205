package list;

public class LinkedList {
	private Node head, tail;
	
	LinkedList(){};
	LinkedList(int num) { head = new Node(num); }
	LinkedList(int[] nums) {
		for(int n:nums){
			this.append(n);
		}
	}
	LinkedList(Node node){
		this.head = node;
	}
	
	public String toString(){
		if(head == null) return "[]";
		StringBuilder string = new StringBuilder("["+head.value);
		Node iterator = head.next;
		while(iterator != null){
			string.append(",");
			string.append(iterator.value);
			iterator = iterator.next;
		}
		return string.append("]").toString();
		
	}
	
	public Node get(int index){
		Node i = head;
		while(index-- > 0){
			i = i.next;
		}
		return i;
	}
	
	public int length(){
		if(head == null) return 0;
		
		int length = 1;
		Node node = head;
		while (node.next != null) {
			length++;
			node = node.next;
		}
		return length;
	}

	public void append(Node node) {
		if (head == null) {
			head = node;
		} else {
			if (tail == null) tail = getTail();
			tail.next = node;
			tail = node;
		}
	}

	public void append(int value){
		append(new Node(value));
	}
	
	public Node findKthFromEnd (int k){
		if(head == null) return null;
		Node front = head, back = head;
		
		while(k>0 && front != null){
			front = front.next;
		}
		
		while(front != null){
			front = front.next;
			back = back.next;
		}
		
		return back;
	}
	
	// fast move 2 steps once while slow only move 1 step so they will meet in case of circling
	public boolean isCircling() {
		if (head == null || head.next == null)
			return false;

		Node fast = head;
		Node slow = head;

		while (fast != null && slow != null) {
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
			slow = slow.next;

			if (fast == slow) {
				return true;
			}
		}

		return false;
	}
	
	public Node FindStartOfCycle() {
		if (head == null || head.next == null)
			return null;
		Node front = head.next.next;
		Node back = head;
		while (front != null && front != back) {
			front = front.next.next;
			back = back.next;
		}

		if (front == null)
			return null;

		back = head;

		while (back != front) {
			back = back.next;
			front = front.next;
		}

		return back;
	}
	
	public Node getTail(){
		if(head == null || this.isCircling()) return null;
		
		Node tail = head;
		while(tail.next != null){
			tail = tail.next;
		}
		return tail;
	}
	
	//create a circle from the nth from the end
	public void createCircle(int n) {
		Node tail = getTail();
		Node startCycle = this.findKthFromEnd(n);

		if (startCycle == null) {
			// bad data
			return;
		}
		tail.next = startCycle;

	}

	//when the faster reach to the end, the slower reaches to the middle	
	public Node getMidNode(){
		if(head == null) return null;
		
		Node fast = head, slow = head;
		while(fast != null){
			fast = fast.next;
			if(fast != null){
				fast = fast.next;
	      slow = slow.next;
			}
		}
		return slow;
	}
	
	public static Node getMidNode (Node head){
	   if(head == null) return null;
	    
	    Node fast = head, slow = head;
	    while(fast != null){
	      fast = fast.next;
	      if(fast != null){
	        fast = fast.next;
	        slow = slow.next;
	      }
	    }
	    return slow;
	}
	
	//split the list into two parts, and get the back list
	public LinkedList split() {
		if(head == null || head.next == null) return null;
		
		LinkedList list = new LinkedList();
		list.head = this.getMidNode();
		
		Node cut = head;
		while(cut.next != list.head) cut = cut.next;
		cut.next = null;
		return list;
	}

	//http://www.geeksforgeeks.org/reverse-a-linked-list/
	public void reverse() {
		Node prev = null;
		Node current = head;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	// [homework 1]: iteration version of zip-merge: take one node from the front and one from the end until the list is empty. 
  public void zipMerge() {
    if (this.head == null)
      return;
    LinkedList list = this.split();
    list.reverse();
    Node iterator = this.head, addon = list.head;
    while (iterator != null && addon != null) {
      Node iteratorNext = iterator.next, addonNext = addon.next;
      iterator.next = addon;
      addon.next = iteratorNext;
      iterator = iteratorNext;
      addon = addonNext;

      if (iterator.next == null) {
        iterator.next = addon;
        break;
      }
    }
  }

//  [homework 2]: merge sort for a linked list
//  ref. http://www.geeksforgeeks.org/merge-sort-for-linked-list/ 
  public void sort() {
    this.head = sort(head);
  }

  private static Node sort(Node h) {
    // base case
    if (h == null || h.next == null)
      return h;

    // get the middle of the list
    Node middle = getMidNode(h);
    Node premid = h;
    
    while (premid != null && premid.next != middle){
      premid = premid.next;
    }
    // divide list h by setting the previous of middle node point to null
    if(premid != null) premid.next = null;

    // sort the left and right
    Node left = sort(h);
    Node right = sort(middle);

    // merge the left and right lists
    Node sortedlist = merge(left, right);
    return sortedlist;
  }

  // this is to merge to sorted node a and b
  private static Node merge(Node a, Node b) {
    Node result = null;

    if (a == null)
      return b;
    if (b == null)
      return a;

    if (a.value <= b.value) {
      result = a;
      result.next = merge(a.next, b);
    } else {
      result = b;
      result.next = merge(a, b.next);
    }
    return result;
  }
  
  // in place way to find the intersection of two linked list
	public Node getIntersection(LinkedList list){
		int m = this.length(), n = list.length(), diff = Math.abs(m-n);
		
		// change the position if n > m
		if(n > m) return list.getIntersection(this);
		
		Node intersection = this.head;
		do{
		  intersection = intersection.next;
		} while (--diff > 0);
		
		Node node = list.head;
		while(intersection != null && node != null){
		  if(intersection == node) return intersection;
		  intersection = intersection.next;
		  node = node.next;
		}
		return null; // this and list don't intersect
	}
	
  public static void main(String[] args) {
    LinkedList list = new LinkedList(new int[] {5, 1, 3, 6, 4, 7, 9, 8});
    list.sort();
    System.out.println(list);
  }
}
