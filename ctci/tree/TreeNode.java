package tree;

import java.util.*;

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int x) {
    val = x;
  }
  
  TreeNode(int[] nums){
    TreeNode node=createMinimalBST(nums);
    this.val=node.val;
    this.left=node.left;
    this.right=node.right;
  }
  
  private TreeNode createMinimalBST(int[] array){
    return createMinimalBST(array,0,array.length-1);
  }
  private TreeNode createMinimalBST(int[] array, int start, int end){
    if(start>end) return null;
    int mid=(start+end)/2;
    TreeNode n=new TreeNode(array[mid]);
    n.left=createMinimalBST(array,start,mid-1);
    n.right=createMinimalBST(array,mid+1,end);
    return n;
  }

  // BST way
  public String toString() {
    if (left == null && right == null)
      return String.valueOf(val);
    List<Integer> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(this);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node != null) {
        queue.add(node.left);
        queue.add(node.right);
        list.add(node.val);
      } else list.add(null);
    }
    return Arrays.toString(list.toArray());
  }

  public static void main(String[] args) {
    TreeNode tree = new TreeNode(3);
    tree.left = new TreeNode(1);
    tree.right = new TreeNode(8);
    tree.left.left=new TreeNode(10);
    System.out.println(tree);
    
    int[] nums={1,2,3,4};
    tree=new TreeNode(nums);
    System.out.println(tree);
  }
}
