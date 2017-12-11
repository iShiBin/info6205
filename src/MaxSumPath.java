import java.util.*;

public class MaxSumPath {
  
  public List<Integer> getMaxSumPath(TreeNode root){
    List<Integer> max=new ArrayList<>(), temp=new ArrayList<>();
    long[] sums=new long[2];
    getMaxSumPath(root, max, temp, sums);
    return max; 
  }
  
  /**
   * Recursion: Calculate the path with max sum value
   * @param root: the root of the binary tree
   * @param max: the path of max sum 
   * @param temp: a temp list of the current recursion
   * @param sums: sums[0] - the sum of temp list; sum[1] - the sum of max list
   */
  private void getMaxSumPath(TreeNode root, List<Integer> max, List<Integer> temp, long[] sums){
    if(root==null) return;
    temp.add(root.val);
    sums[0]+=root.val;
    if(root.left==null && root.right==null) {
      if(sums[0]>sums[1]) {
        //cannot use `max = new ArrayList<Integer>(temp);` because it dereference max and list 
        max.clear();
        max.addAll(temp);
        sums[1]=sums[0];
      }
    }
    getMaxSumPath(root.left, max, temp, sums);
    getMaxSumPath(root.right, max, temp, sums);
    
    sums[0]-=temp.get(temp.size()-1);
    temp.remove(temp.size()-1);
  }

  public static void main(String[] args) {
    /*use the following tree as a test
        1
       / \
      2   3
     /|  / \
    6 7 4   5
     */
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(7);
    
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    
    List<Integer> list = new MaxSumPath().getMaxSumPath(root);
    System.out.println(list);
  }
}
