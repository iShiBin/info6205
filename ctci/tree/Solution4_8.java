package tree;
/* First Common Ancestor: Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure. Note: This is not necessarily a binary search tree.
 */

public class Solution4_8 {
  
  static int TWO_NODES_FOUND = 2;
  static int ONE_NODE_FOUND = 1;
  static int NO_NODES_FOUND = 0;
    
  // Checks how many 'special' nodes are located under this root
  public static int covers(TreeNode root, TreeNode p, TreeNode q) {
    int ret = NO_NODES_FOUND;
    if (root == null) return ret;
    if (root == p || root == q) ret += 1;
    ret += covers(root.left, p, q);
    if(ret == TWO_NODES_FOUND) // Found p and q 
      return ret;
    return ret + covers(root.right, p, q);
  }
    
  public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (q == p && (root.left == q || root.right == q)) return root;
    int nodesFromLeft = covers(root.left, p, q); // Check left side
    if (nodesFromLeft == TWO_NODES_FOUND) {
      if(root.left == p || root.left == q) return root.left;
      else return commonAncestor(root.left, p, q);
    } else if (nodesFromLeft == ONE_NODE_FOUND) {
      if (root == p) return p;
      else if (root == q) return q;
    }

    int nodesFromRight = covers(root.right, p, q); // Check right side
    if(nodesFromRight == TWO_NODES_FOUND) {
      if(root.right == p || root.right == q) return root.right;
      else return commonAncestor(root.right, p, q);
    } else if (nodesFromRight == ONE_NODE_FOUND) {
      if (root == p) return p;
      else if (root == q) return q;
    }
    if (nodesFromLeft == ONE_NODE_FOUND && 
      nodesFromRight == ONE_NODE_FOUND) return root;
    else return null;
  }
  

}