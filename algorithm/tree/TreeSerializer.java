package tree;
import java.util.*;

//from Leetcode implementation
public class TreeSerializer {
  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode(int x) { val = x; }
   * }
   */
  
  public static String treeNodeToString(TreeNode root) {
      if (root == null) {
          return "[]";
      }
  
      String output = "";
      Queue<TreeNode> nodeQueue = new LinkedList<>();
      nodeQueue.add(root);
      while(!nodeQueue.isEmpty()) {
          TreeNode node = nodeQueue.remove();
  
          if (node == null) {
            output += "null, ";
            continue;
          }
  
          output += String.valueOf(node.val) + ", ";
          nodeQueue.add(node.left);
          nodeQueue.add(node.right);
      }
      return "[" + output.substring(0, output.length() - 2) + "]";
  }
  
  public static TreeNode stringToTreeNode(String input) {
      input = input.trim();
      input = input.substring(1, input.length() - 1);
      if (input.length() == 0) {
          return null;
      }
  
      String[] parts = input.split(",");
      String item = parts[0];
      TreeNode root = new TreeNode(Integer.parseInt(item));
      Queue<TreeNode> nodeQueue = new LinkedList<>();
      nodeQueue.add(root);
  
      int index = 1;
      while(!nodeQueue.isEmpty()) {
          TreeNode node = nodeQueue.remove();
  
          if (index == parts.length) {
              break;
          }
  
          item = parts[index++];
          item = item.trim();
          if (!item.equals("null")) {
              int leftNumber = Integer.parseInt(item);
              node.left = new TreeNode(leftNumber);
              nodeQueue.add(node.left);
          }
  
          if (index == parts.length) {
              break;
          }
  
          item = parts[index++];
          item = item.trim();
          if (!item.equals("null")) {
              int rightNumber = Integer.parseInt(item);
              node.right = new TreeNode(rightNumber);
              nodeQueue.add(node.right);
          }
      }
      return root;
  }
  
  /*   1
   *    \
   *     2
   *    /
   *   3
   * 
   */
  public static void main(String[] args){
    TreeNode root=new TreeNode(1);
    root.right=new TreeNode(2);
    root.right.left=new TreeNode(3);
    System.out.println(treeNodeToString(root));
    System.out.println(treeNodeToString(stringToTreeNode("[1, null, 2, 3, null, null, null]")));
    
    root.right.left.left=new TreeNode(4);
    System.out.println(treeNodeToString(root));
  }
}