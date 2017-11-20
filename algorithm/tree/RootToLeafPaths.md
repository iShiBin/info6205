# Different Ways to Get all Paths from Root to Leaf in a Binary Tree

# Top-down Recursion [O(n); O(n)]

```java
  /** TOP-DOWN RECURSION
   * Another way to get the path of a tree, which just use one method.
   * The efficiency is however not high because of creating new LinkedList() each time.
   * <link> https://leetcode.com/problems/path-sum-ii/description/
   * @param root
   * @return
   */
  public static List<List<TreeNode>> getRootToLeafPaths(TreeNode root){
    List<List<TreeNode>> list=new LinkedList<>();
    if(root==null) return list;
    else if(root.left==null && root.right==null){
      List<TreeNode> l=new LinkedList<>();
      l.add(root);
      list.add(l);
    } else {
      List<List<TreeNode>> left= getRootToLeafPaths(root.left);
      List<List<TreeNode>> right= getRootToLeafPaths(root.right);
      
      for(List<TreeNode> l: left){
        l.add(0, root);
        list.add(l);
      }
      
      for(List<TreeNode> l: right){
        l.add(0, root);
        list.add(l);
      }
    }
    return list;
  }
```



# Bottom-up Recursion (Backtracking) [O(n); O(n)]

```java
  public static List<LinkedList<TreeNode>> getPaths(TreeNode root){
    List<LinkedList<TreeNode>> pathList=new LinkedList<>();
    if(root==null) return pathList;
    getToLeafPaths(root, new LinkedList<>(), pathList);
    return pathList;
  }
  
  /**
   * Helper function to backtrack and get the recursions.
   * @param root
   * @param path
   * @param pathList
   */
  private static void getToLeafPaths(TreeNode root, LinkedList<TreeNode> path, List<LinkedList<TreeNode>> pathList) {
    if (root == null)
      return;

    path.add(root);

    if (root.left == null && root.right == null) {
   // need to create a new list and then add
      pathList.add(new LinkedList<TreeNode>(path));
   // return ; //bug: still need to remove the last node here.
    }
    getToLeafPaths(root.left, path, pathList);
    getToLeafPaths(root.right, path, pathList);
    path.removeLast();// remove the last node after one recursion!
  }
```

**Note**:

* Must remove the last node in the temp list `path` in the end of recursion, otherwise, the rest of notes will keep adding to the list.
  Another way is to create a new `path` in the `getToLeafPaths(root.left, path, pathList);` such as `getToLeafPaths(root.left, new LinkedList<>(path), pathList);`. However, it is less effecient because creating a new object is expensive.
* Must continue to run the rest of code instead of `return` after adding the `path` to the result list. Otherwise, the wrong result is similar with the previous note item, which is not to remove the last node in the last.

# Conclusion

Both of the two appoaches are with same level of Big O notation time and space complexity. However, the first appoach is simpler to code but less efficient than the second one, which takes nearly 3 times to run for a tree with 100k nodes (116 ms vs 40 ms).