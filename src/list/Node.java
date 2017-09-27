package list;

public class Node {
	int value;
	Node next;

	Node() {
	};

	Node(int val) {
		value = val;
		next = null;
	}
	
	Node(Node node){
		this.value = node.value;
		this.next = node.next;
	}
	
	public String toString(){
		return Integer.toString(value);
	}
}
