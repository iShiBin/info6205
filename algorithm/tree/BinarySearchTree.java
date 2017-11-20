/**
 * A binary search tree is a rooted binary tree, whose internal nodes each store a key (and optionally, an associated value) 
 * and each have two distinguished sub-trees, commonly denoted left and right. 
 * The tree additionally satisfies the binary search tree property, 
 * which states that the key in each node must be greater than or equal to any key stored in the left sub-tree, 
 * and less than or equal to any key stored in the right sub-tree.
 * <link> https://en.wikipedia.org/wiki/Binary_search_tree
 */
package tree;

/**
 * @author bin
 *
 */
public class BinarySearchTree extends BinaryTree{
 
  /**Convert Sorted Array to Binary Search Tree 
   * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
   * <link>https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
   * @param sortedArray sorted in ascending order
   * @return a height balanced BST.
   */
  public static TreeNode buildMinBST(int[] sortedArray){
    return buildMinBST(sortedArray,0,sortedArray.length-1);
  }
  private static TreeNode buildMinBST(int[] array, int start, int end){
    if(start>end) return null;
    int mid=start + (end-start)/2;
    TreeNode root=new TreeNode(array[mid]); // build the root from the middle element
    root.left=buildMinBST(array,start,mid-1); // recursively build a 'root' as the left of the root
    root.right=buildMinBST(array,mid+1,end); // recursively build a 'root' as the right of the root
    return root;
  }
  
  public static boolean isValidBST(TreeNode root){
    if(root==null) return false;
    else return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
  }
  
  private static boolean isValid(TreeNode root, long max, long min){
    if(root==null) return true;
    return root.val<=max && root.val>min && isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
  }
  
  
}
