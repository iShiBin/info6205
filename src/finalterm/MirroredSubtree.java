package finalterm;

/**
 * Assignment:
 * Check whether a binary tree is a the mirror of a subtree of another tree.
 * The match should be a full match, meaning the subtree should reach the leaves of the full tree.
 * 
 * Example:
 * Input: 
 * A big tree:
 *    5
 *   / \
 *  2   4
 *     / \
 *    7   8
 *  
 * A small tree:
 *       4
 *      / \
 *     8   7
 * 
 * @author bin
 * Output: true
 * Explanation: The small tree is a mirror of a subtree of the big tree, which is as below.
 *       4
 *      / \
 *     7   8
 * 
 * Note: If either 7 or 8 in the big tree has a child, 
 * it will return false as the subtree structure are not exactly the same.
 */

/*
 * Algorithm:
 * 1. Get a mirrored tree of the target subtree
 * 2. Verify the mirrored tree is whether a subtree of the big tree
 * 
 * Complexity: 
 * Time O(h): h is the height of the big tree
 * Space O(h): h is the height of the big tree (recursion stack)
 */
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

public class MirroredSubtree {
    /**
     * Entry function to validate whether a small tree is a mirror of some subtree of a big tree. 
     * @param tree: the big tree
     * @param subtree: the subtree
     * @return
     */
    public static boolean validate(TreeNode tree, TreeNode subtree){
        TreeNode mirror = getMirrored(subtree);
        return isSubtree(tree, mirror);
    }
    
    private static TreeNode getMirrored(TreeNode root) {
        if (root != null) {
            TreeNode left = getMirrored(root.left);
            TreeNode right = getMirrored(root.right);
            root.left = right;
            root.right = left;
        }
        return root;
    }
    
    private static boolean isSubtree(TreeNode s, TreeNode t) {
        if(equals(s,t)) return true;
        return (s!=null) && (isSubtree(s.left,t) || isSubtree(s.right,t));
    }
    public static boolean equals(TreeNode x,TreeNode y)
    {
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
    }
    
    public static void main(String[] args) {
        
        //build the big tree in the example
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(4);
        tree.right.left=new TreeNode(7);
        tree.right.right=new TreeNode(8);
        
        //build the subtree in the example
        TreeNode subtree = new TreeNode(4);
        subtree.left = new TreeNode(8);
        subtree.right = new TreeNode(7);
        
        System.out.println(validate(tree, subtree));//true
        
        //if add an another layer to the big tree, the full match will fail.
        tree.right.right.left=new TreeNode(3);
        System.out.println(validate(tree, subtree));//false
    }

}
