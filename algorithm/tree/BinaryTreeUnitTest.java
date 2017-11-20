package tree;

import static org.junit.Assert.*;


import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;


public class BinaryTreeUnitTest {
  
/**
 * String representation of the following tree should be "[1,2,3,null,null,4,5]"
         1
       /   \
      2     3
       \   / \
        7 4   5
*/
  
  private TreeNode buildTestTree(){
    TreeNode root=new TreeNode(1);
    root.left=new TreeNode(2);
    root.left.right=new TreeNode(7);
    
    root.right=new TreeNode(3);    
    root.right.left=new TreeNode(4);
    root.right.right=new TreeNode(5);
    return root;
  }
  
  @Test
  public void toStringTest(){
    TreeNode root=buildTestTree();
    String fact=BinaryTree.toString(root);
  }
  
  @Test
  public void buildTest(){
    TreeNode root=new TreeNode(1);
    root.left=new TreeNode(2);
    root.right=new TreeNode(3);
    root.right.left=new TreeNode(4);
    root.right.right=new TreeNode(5);
    
//    System.out.println(root.toDeepString());
    TreeNode expected=BinaryTree.buildTree(root.toDeepString());
//    BinaryTree.print(expected);
    Assert.assertTrue(root.equals(expected));
  }
  
  @Test
  public void traversePreorderTest(){
    TreeNode root=BinaryTree.buildTree("[40,20,60,null,30,50]");
    List<TreeNode> preorder=BinaryTree.traversePreorder(root);
    String expected="[40, 20, 30, 60, 50]";
    Assert.assertEquals(expected, preorder.toString());
  }
  
  @Test
  public void traversePreorderIterativlyTest(){
    TreeNode root=BinaryTree.buildTree("[40,20,60,null,30,50]");
    List<TreeNode> preorder=BinaryTree.traversePreorderIterativly(root);
    String expected="[40, 20, 30, 60, 50]";
    Assert.assertEquals(expected, preorder.toString());
  }
  
  @Test
  public void getAllLevelsTest(){
    TreeNode root=this.buildTestTree();
    List<List<TreeNode>> list=BinaryTree.getLevelsReal(root);
    for(List<TreeNode> l:list){
      System.out.println(l);
    }
    printSeperateLine();
  }
  
  @Test
  public void traverseZipzipTest(){
    TreeNode root=this.buildTestTree();
    List<List<TreeNode>> list=BinaryTree.traverseZipzap(root);
    System.out.println("The zipzap traverse is:");
    for(List<TreeNode> l:list){
      System.out.println(l);
    }
    printSeperateLine();
  }
  
  @Test
  public void getLevelsNoNull(){
    TreeNode root=this.buildTestTree();
    List<List<TreeNode>> list=BinaryTree.getLevelsNoNull(root);
    System.out.println("The no null traverse is:");
    for(List<TreeNode> l:list){
      System.out.println(l);
    }
    printSeperateLine();
  }
  
  @Test
  public void boundaryTest(){
    /*
        1
       / \
      2   3
     /|  / \
    6 7 4   5
     */
    TreeNode root=new TreeNode(1);
    root.left=new TreeNode(2);
    root.right=new TreeNode(3);
    
    root.left.left=new TreeNode(6);
    root.left.right=new TreeNode(7);
    
    root.right.left=new TreeNode(4);
    root.right.right=new TreeNode(5);
    
    System.out.println(root.toDeepString());
    System.out.println("left boundary");
    System.out.println(BinaryTree.getBoundaryLeft(root));
    
    System.out.println("right boundary");
    System.out.println(BinaryTree.getBoundaryRight(root));
    
    System.out.println("leaves");
    System.out.println(BinaryTree.getLeaves(root));
    
    
    System.out.println("boundary");
    System.out.println(BinaryTree.getBoundary(root));
    this.printSeperateLine();
  }
  
  @Test
  public void getLowestCommonAncestorTest(){
    /*
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

    System.out.println("getLowestCommonAncestorTest");
    System.out.println(BinaryTree.getLowestCommonAncestor(root,root.right, new TreeNode(30)));
  }
  
  @Test
  public void getPathsTest(){
    TreeNode root=this.buildTestTree();
    List<LinkedList<TreeNode>> path1= BinaryTree.getPaths(root);
    List<List<TreeNode>> path2 = BinaryTree.getRootToLeafPaths(root);
    System.out.println("getPathsTest");
    for(int i=0;i<path1.size();i++){
//      System.out.println(path1.get(i));
      Assert.assertArrayEquals(path1.get(i).stream().mapToInt(e->e.val).toArray(), path2.get(i).stream().mapToInt(e->e.val).toArray());
    }
  }
  @Test
  public void getVerticalSumTest(){
    TreeNode root=BinaryTree.buildTree("[1,2,3,6,7,4,5]");
    int[] sum=BinaryTree.sumVertical(root);
    System.out.println("The sum is: " + Arrays.toString(sum));
    int[] expected={6,2,12,3,5};
    Assert.assertArrayEquals(expected, sum);
    this.printSeperateLine();
  }
  
  @Test
  public void getMaxSumPathTest(){
    int[] nums=new Random().ints(30, 0, 20).distinct().toArray();
    TreeNode root=BinaryTree.buildTree(nums);
    
    System.out.println("getMaxSumPathTest");
    System.out.println(BinaryTree.getMaxSumPath(root));
    
    System.out.println("another way");
    List<List<TreeNode>> path=BinaryTree.getRootToLeafPaths(root);
    for(List<TreeNode> l:path){
      System.out.println(l);
    }
    this.printSeperateLine();
  }
  
  @Test
  public void getLevelOfNode(){
     /*
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
    
    int expected=2;
    int fact=BinaryTree.getLevelOfNode(root, root.right.left);
    Assert.assertTrue(expected==fact);

  }
  
  @Test
  public void getDistanceOfNodeTest(){
    /*
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
    
    int fact=BinaryTree.getDistanceOfNode(root, root.left.left);
    int expectecd=-2;
    Assert.assertTrue(fact==expectecd);
    
    TreeNode node = new TreeNode(10);
    fact=BinaryTree.getDistanceOfNode(root, node);
    expectecd=Integer.MIN_VALUE;
    Assert.assertTrue(fact==expectecd);
  }
  
  @Test
  public void solutionTest(){
    /*
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
    System.out.println("Solution");
    BinaryTree.print(root);
    
    List<TreeNode> list=BinaryTree.traverseInorder(root);
    System.out.println(list);
    
    list=BinaryTree.traversePostorder(root);
    System.out.println(list);
    this.printSeperateLine();
  }
  
  @Test
  public void sumOfLeavesTese(){
   TreeNode root=null;
   
   System.out.println("Sum:"+BinaryTree.sumOfLeaves(root));
  }
  
  @Test
  public void areSiblings(){
    TreeNode root=this.buildTestTree();
    Assert.assertTrue("areSiblings failed", BinaryTree.areSiblings(root, root.right.left, root.right.right)==true);

    Assert.assertTrue("areSiblings failed", BinaryTree.areSiblings(root, root.right, root.right.right)==false);
  }
  
  @Test
  public void areCousins(){
    TreeNode root=this.buildTestTree();
    Assert.assertTrue("areCousins failed", BinaryTree.areCousins(root, root.left.right, root.right.right)==true);
    
    Assert.assertTrue("areCousins failed", BinaryTree.areCousins(root, root.left, root.right.right)==false);
  }
  
  @Test
  public void maxSumFromRootToLeaf(){
    TreeNode root = this.buildTestTree();
    root.left.right=new TreeNode(10);
    System.out.println("max sum");
    System.out.println(BinaryTree.maxSumRootToLeaf(root));
    this.printSeperateLine();
  }
  /******************************************************/
  
  void printSeperateLine(){
    System.out.println("================");
  }
}
