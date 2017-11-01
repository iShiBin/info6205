package greedy;

import java.util.*;

/**
 * 用Huffman算法对一个英文文本进行编码（https://en.wikipedia.org/wiki/Huffman_coding）
 * @author bin
 *
 */
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

public class Huffman {
	
	private static Node root;
	private static Map<Character, String> codeMap=new HashMap<>();
	
	public static String encode(String text){		
		HashMap<Character,Integer> statistic = new HashMap<>();
		for(char key:text.toCharArray()){
			statistic.computeIfPresent(key, (k,v)->v.intValue()+1);
			statistic.putIfAbsent(key, 1);
		}
//		System.out.println(statistic);
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		for(Map.Entry<Character, Integer> entry: statistic.entrySet()){
			queue.add(new Node(entry.getKey(), entry.getValue()));
		}
		
//		while(!queue.isEmpty()){
//			System.out.println(queue.poll());
//		}
		
		while(queue.size()>1){
			Node sum=new Node(queue.poll(),queue.poll());
			queue.add(sum);
		}
		
		root=queue.poll();
		setCode(root, "");
		buildCodeMap(root);
		
		StringBuilder compressed = new StringBuilder();
		for(char i:text.toCharArray()){
			compressed.append(codeMap.get(i));
		}
		return compressed.toString();
	}
	
	private static void setCode(Node node, String code){
		if(node!=null) node.code=code;
		if(node.left!=null){
			String leftCode=node.code+"0";
			setCode(node.left, leftCode);
		}
		if(node.right!=null){
			String rightCode=node.code+"1";
			setCode(node.right, rightCode);
		}
	}
	
//	private void printLeafCode(Node node){
//		if(node.left==null && node.right==null){
//			System.out.println(node.ch+","+node.code);
//		}else{
//			this.printLeafCode(node.left);
//			this.printLeafCode(node.right);
//		}
//	}
	
	private static void buildCodeMap(Node node){
		if(node.left==null && node.right==null){
			codeMap.put(node.ch, node.code);
		}else{
			buildCodeMap(node.left);
			buildCodeMap(node.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "A_DEAD_DAD_CEDED_A_BAD_BABE_A_BEADED_ABACA_BED";
		System.out.println(Huffman.encode(text));
//		huffman.printLeafCode(huffman.root);
	}

}
