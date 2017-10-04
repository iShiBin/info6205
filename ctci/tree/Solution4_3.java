package tree;
/* List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
 * (e.g., if you have a tree with depth D, you will have D linked lists).
*/
import java.util.*;

public class Solution4_3{
	
	public ArrayList<LinkedList<TreeNode>> getLevelLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> list=new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current=new LinkedList<>();
		if(root!=null) current.add(root);
		
		while(current.size()>0){
		  list.add(current);
		  
		  // trick: add another reference - learn this technique
		  LinkedList<TreeNode> parent=current;
		  
		  current=new LinkedList<TreeNode>();
		  for(TreeNode n:parent){
		    if(n.left!=null) {
		      current.add(n.left);
		      n.left=null;
		    }
		    if(n.right!=null) {
		      current.add(n.right);
		      n.right=null;
		    }
		  }
		}
		return list;
	}
	
	// this could also be done in recursive way like below
	public ArrayList<LinkedList<TreeNode>> getLevelLinkedListRecursively(TreeNode root){
	  ArrayList<LinkedList<TreeNode>> lists=new ArrayList<LinkedList<TreeNode>>();
	  createLevelLinkedList(root,lists,0);
	  return lists;
	}
	
	private void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
	  if(root==null) return; //base case
	  
	  LinkedList<TreeNode> l=null;
	  if(lists.size()==level){ //level not contained in list
	    l=new LinkedList<TreeNode>();
	    lists.add(l);
	  }else{
	    l=lists.get(level);
	  }
	  l.add(root);
	  createLevelLinkedList(root.left,lists,level+1);
	  createLevelLinkedList(root.right,lists,level+1);
	}
	
	
	public static void main(String[] args){
	  TreeNode root=new TreeNode(3);
	  root.left=new TreeNode(1);
	  root.right=new TreeNode(9);
//	  System.out.println(root);
	  
	  Solution4_3 test=new Solution4_3();
	  root=new TreeNode(new int[]{1,2,4,5,7,9,10});
	  for(LinkedList<TreeNode> l:test.getLevelLinkedList(root)){
	    System.out.println(l);
	  }
	  
	  root=new TreeNode(new int[]{1,2,4,5,7,9,10});
    for(LinkedList<TreeNode> l:test.getLevelLinkedListRecursively(root)){
      for(TreeNode n:l){
        System.out.print(n.val+ " ");
      }
      System.out.println();
    }
	}
}