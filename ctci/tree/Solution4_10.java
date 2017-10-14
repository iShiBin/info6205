package tree;
//572. Subtree of Another Tree - https://leetcode.com/problems/subtree-of-another-tree/description/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution4_10 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(equals(s,t)) return true;
        return (s!=null) && (isSubtree(s.left,t) || isSubtree(s.right,t));
    }
    public boolean equals(TreeNode x,TreeNode y)
    {
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
    }
}