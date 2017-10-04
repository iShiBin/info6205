package linkedlist;
public class Node {
	Node next = null;
	int data;

	public Node(){}
	public Node(int d) {data = d;}

	public void append(int d){
		Node end = new Node(d);
		Node n = this;
		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public String toString(){
		if(this == null) return "null";

		StringBuffer buffer = new StringBuffer("[");
		buffer.append(this.data);

		Node node = next;
		while(node != null ) {
			buffer.append("->");
			buffer.append(node.data);
			node = node.next;
		}
		buffer.append("]");

		return buffer.toString();
	}	
}
