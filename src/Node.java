

class Node implements Comparable<Node> {
	char ch;
	int weight;
	Node left,right;
	String code;
	
	public int compareTo(Node node){
		if(this.weight-node.weight!=0){
			return this.weight-node.weight;
		}else{
			return this.ch-node.ch;
		}
	}
	public Node(){
		
	}
	public Node(char ch, int freq){
		this.ch=ch;
		this.weight=freq;
	}
	public Node(Node x, Node y){
		this.weight=x.weight+y.weight;
		this.left=x;
		this.right=y;
		
	}
	public String toString(){
		return "["+ch+","+weight+"]";
	}
	
}