package tree;

/**
 * Binary tree node and represent a binary tree itself for simplify coding. 
 * @author bin
 *
 */
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  TreeNode() {
  }
  
  public TreeNode(int x) {
    val = x;
  }
  
  
  
  public String toString(){
    return String.valueOf(val);
  }
  
  public String toDeepString(){
    return BinaryTree.toString(this);
  }
  
  public boolean equals(TreeNode node){
    return BinaryTree.isIdentical(this, node);
  }
  
  public void print(){
    BinaryTree.print(this);
  }
  
  /**
   * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
   * <link> https://leetcode.com/problems/symmetric-tree/description/
   * @param root
   * @return
   */
  public boolean isSymmetric() {
    return BinaryTree.isMirrored(this, this);
  }

}
