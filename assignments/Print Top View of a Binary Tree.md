# Print Top View of a Binary Tree

Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. Given a binary tree, print the top view of it. The output nodes can be printed in any order.

**Example 1**

```
       1
    /     \
   2       3
  /  \    / \
 4    5  6   7
Top view of the above binary tree is: 4 2 1 3 7
```

**Example 2**

```
        1
      /   \
    2       3
      \   
        4  
          \
            5
             \
               6
Top view of the above binary tree is: 2 1 3 6
```

# Algorithm

## Horizontal Position + Level Traverse

1. Get the list of nodes in each horizontal position. Assuming the position of a parent node is `x`, so the left child of which is `x-1`, and the right child is `x+1`. Then use a HashMap to store the <position, List<Node>> pair, when a position `horizon` is not in this map, add it to the map; otherwise, add it to the end of the corresponding list in this map. Taking the sample 2 for example, here is the output after traversing this tree (assuming root is `0`, and traverse order is root->left->right recursively).

   ```
    0: 1->4
   -1: 2->3
    1: 5->3
    2: 6
   ```

2. Get the level traverse order to determine which node should be displayed in the lists of step 1. The normal level traverse list is: 1->2->3->4->5->6. 

3. Print the result by referring the lists in step 1 and step 2. For example:
   in list item `1:5->3`, the node with value `3` should be displayed since it is prior to `5` according to the list in step 2. 

## Optimization

In fact, we don't actually need to store a list of nodes in the map because we only need one - a correct one in the horizontal position. The only thing is if another node with the same position shows we need to compare with the one in the map and replace it if the later node with a higher order in the level traverse list. The following code is based on this optimization.

# Solution

Here is the **Java** code, and the source file is /src/assignment/BinaryTree.java

```java
/* TreeNode definition
class TreeNode {
  public int val;
  public int data; // same as val but just for compatibility 
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {
  }

  public TreeNode(int x) {
    val = x;
  }
}
*/

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
}
```



# Complexity

**Time**: O(n). Traverse every node twice for the horizontal location and level order.

**Space**: O(n). Use some queue, list to store the temp values.

# Test

Here are the test code and running result.

```java
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
  
  new BinaryTree().printTopView(root);
  //[2, 1, 3, 6]
}
```

**Output** [2, 1, 3, 6]

# Follow-up

The above output is from the left to right, we can also do it using the 'level traverse' by root->left->right. 

```java
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
      System.out.print(topview.get(0));
      
      for(int i=1;i<topview.size();i++){
        System.out.print(" "+topview.get(i));
      }
    }
  }
```

And the running result on Example 2 is: [1, 2, 3, 6]
