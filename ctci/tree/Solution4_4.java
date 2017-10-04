package tree;
// check Balanced: Implement a function to check if a binary tree is balanced
public class Solution4_4 {
  
  public boolean isBalanced(TreeNode root){
    return checkHeight(root) != Integer.MIN_VALUE;
  }
  
  private int checkHeight(TreeNode root){
    if(root==null) return -1;
    
    int leftHeight=checkHeight(root.left);
    if(leftHeight==Integer.MIN_VALUE) return Integer.MIN_VALUE;
    
    int rightHeight=checkHeight(root.right);
    if(rightHeight==Integer.MIN_VALUE) return Integer.MIN_VALUE;
    
    int diff = Math.abs(leftHeight-rightHeight);
    if(diff>1) return Integer.MIN_VALUE;
    else return Math.max(leftHeight, rightHeight) + 1;
  }
}