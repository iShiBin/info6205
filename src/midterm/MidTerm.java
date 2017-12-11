package midterm;
import java.util.*;

class MidTerm {
  
  public boolean find2Sum(int[] sorted, int target) {
    if (sorted == null) {
      return false;
    }
    int low = 0, high = sorted.length - 1;
    while (low < high) {
      int sum = sorted[low] + sorted[high];
      if (sum == target) {
        return true;
      } else if (sum > target) {
        high--;
      } else {
        low++;
      }
    }
    return false;
  }

//  bonus to find 3 number which sum to a target number
  public boolean find3Sum(int[] sorted, int target){
    if (sorted == null || sorted.length<3) {
      return false;
    }
    
    for(int i=0;i<sorted.length-2;i++){
      int target2=target-sorted[i];
      int j=i+1, k=sorted.length-1;
      while(j<k){
        int sum2=sorted[j]+sorted[k];
        if(sum2==target2){
          return true;
        }else if(sum2<target2) j++;
        else k--;
      }
    }
    return false;
  }
  

  // create a class of Nodes and Tree and Print all Nodes K distance from root.
  class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    protected TreeNode() {
    }

    public TreeNode(int x) {
      val = x;
    }
  }
  
  public void printKDistanceOfRoot(TreeNode root, int distance) {
    if (root == null)
      return;
    if (distance == 0) {
      System.out.println(root.val + " ");
    }
    printKDistanceOfRoot(root.left, distance - 1);
    printKDistanceOfRoot(root.right, distance - 1);
  }
}
