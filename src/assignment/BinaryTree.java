package assignment;

import java.util.*;

import tree.*;

class BinaryTree {
  
  private List<TreeNode> list=new ArrayList<>();
  
  // print the top view from left->right
  public void printTopView(TreeNode root) {
    if(root==null) System.out.println("[]");
    else{
      Queue<TreeNode> queue=new LinkedList<>();
      queue.offer(root);
      while(!queue.isEmpty()){
        TreeNode node=queue.poll();
        if(node.left!=null) queue.offer(node.left);
        if(node.right!=null) queue.offer(node.right);
        list.add(node);
      }

      Map<Integer, TreeNode> map=new TreeMap<>();
      getTopView(root, map, 0);
      
      List<Integer> topview=new ArrayList<Integer>();
      for(TreeNode node:map.values()){
        topview.add(node.val);
      }
      System.out.println(topview);
    }
  }
  
  private void getTopView(TreeNode root, Map<Integer, TreeNode> map, int horizon){
    if(root==null) return;
    if(!map.containsKey(horizon)){
      map.put(horizon, root);
    }else{
      TreeNode node=map.get(horizon);
      if(isBefore(root, node)){
        map.replace(horizon, root);
      }
    }
    getTopView(root.left,map,horizon-1);
    getTopView(root.right,map,horizon+1);
  }
  
  private boolean isBefore(TreeNode node1, TreeNode node2){
    for(TreeNode node:list){
      if(node==node1) return true;
      if(node==node2) return false;
    }
    return true;
  }
  // print the top view in level order (root, left, right)
  public void printTopViewLevel(TreeNode root) {
    if(root==null) System.out.println("[]");
    else{
      Queue<TreeNode> queue=new LinkedList<>();
      queue.offer(root);
      while(!queue.isEmpty()){
        TreeNode node=queue.poll();
        if(node.left!=null) queue.offer(node.left);
        if(node.right!=null) queue.offer(node.right);
        list.add(node);
      }

      Map<Integer, TreeNode> map=new TreeMap<>();
      getTopView(root, map, 0);
      
      List<Integer> topview=new ArrayList<>();
      Collection<TreeNode> set=map.values();
      for(TreeNode node:list){
        if(set.contains(node)) topview.add(node.val);
      }
      System.out.println(topview);
    }
  }

//   Driver class to test above methods usign the following example
  /* Create following Binary Tree
    1
  /  \
  2    3
  \
   4
    \
     5
      \
       6
  */
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.left.right.right = new TreeNode(5);
    root.left.right.right.right = new TreeNode(6);
    
    new BinaryTree().printTopViewLevel(root);
    //[2, 1, 3, 6]
  }
}

