package tree;

//Validate BST: Implement a function to check if a binary tree is a binary search tree.
public class Solution4_5 {
  
  public boolean isBinarySearchTree(TreeNode root){
    return isBinarySearchTree(root,null,null);
  }
  
  private boolean isBinarySearchTree(TreeNode node, Integer max, Integer min){
    if(node==null) return true;
    if(min!=null && node.val<=min || (max!=null && node.val>max)) return false;
    if(!isBinarySearchTree(node.left,min,node.val) || !isBinarySearchTree(node.right,node.val,max))
      return false;
    return true;
  }

}
