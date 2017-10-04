package tree;
/* Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binayr search tree with minimal height.
*/
public class Solution4_2{
	public TreeNode createMinimalBST(int[] array){
		return createMinimalBST(array,0,array.length-1);
	}
	private TreeNode createMinimalBST(int[] array, int start, int end){
		if(start>end) return null;
		int mid=(start+end)/2;
		TreeNode n=new TreeNode(array[mid]);
		n.left=createMinimalBST(array,start,mid-1);
		n.right=createMinimalBST(array,mid+1,end);
		return n;
	}
    public static void main(String[] args){
		int[] nums={1,2,3,5,6,7,9,11,29};
		TreeNode tree=new Solution4_2().createMinimalBST(nums);
		System.out.println(tree);
	}
}
