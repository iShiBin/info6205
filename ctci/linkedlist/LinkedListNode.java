package linkedlist;
public class LinkedListNode {
	LinkedListNode next = null;
	int data;

	public LinkedListNode(){}
	public LinkedListNode(int d) {data = d;}
	public LinkedListNode(int[] nums) {
		if(nums == null) return;
		this.data = nums[0];
		for(int i = 1; i < nums.length; i++){
			this.append(nums[i]);
		}
	}

	public void append(int d){
		LinkedListNode end = new LinkedListNode(d);
		LinkedListNode n = this;
		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public void append(LinkedListNode node){
		LinkedListNode tail = this;
		while(tail.next != null) tail = tail.next;
		tail.next = node;
	}

	public int getLength() {
		if(this == null) return 0;
		LinkedListNode literator = this;
		int length = 0;
		while(literator != null) {
			length++;
			literator = literator.next;
		}
		return length;
	}

	public void reverse() {
		int l = getLength();
		int[] datas = new int[l];
		LinkedListNode node = this;
		for(int i = 0; i<l; i++) {
			datas[i] = node.data;
			node = node.next;
		}
		
		node = this;
		for(int i=l-1; i>=0; i--) {
			node.data = datas[i];
			node = node.next;
		}
	}

	//todo
	public void removeHead() {
		if(this == null) return ;
		// cannot move remove head if there is only one node
		if(this.next == null) return ;

		LinkedListNode node = this;

		do{
			node.data = node.next.data;
			node = node.next;
		}while(node.next != null);
		node = null;
	}

	//todo
	public void removeTail() {
		if(this == null) return ;
		LinkedListNode node = this.next;
		do{
			node = node.next;
		}while(false);
	}

	public boolean isCircling(){
		LinkedListNode slow=this, fast=this;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(fast==slow) break; 
		}

		if(fast==null || fast.next==null) return false;
		else return true;
	}
			
	public String toString(){
		if(this == null) return "null";

		StringBuffer buffer = new StringBuffer("[");
		buffer.append(this.data);

		LinkedListNode node = next;
		while(node != null ) {
			buffer.append("->");
			buffer.append(node.data);
			node = node.next;
		}
		buffer.append("]");

		return buffer.toString();
	}
}
