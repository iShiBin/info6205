package tree;

import static org.junit.Assert.*;


import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;


public class BinaryTreeUnitTest {
  
/**
 * String representation of the following tree should be "[1,2,3,null,null,4,5]"
 *  1
   / \
  2   3
     / \
    4   5
 */
  
  private TreeNode buildTestTree(){
    TreeNode root=new TreeNode(1);
    root.left=new TreeNode(2);
    root.right=new TreeNode(3);
    
//    root.left.left=new TreeNode(6);
    root.right.left=new TreeNode(4);
    root.right.right=new TreeNode(5);
    return root;
  }
  
  @Test
  public void toStringTest(){
    TreeNode root=buildTestTree();
    String expected="[1, 2, 3, null, null, 4, 5]";
    String fact=BinaryTree.toString(root);
    Assert.assertTrue(fact.equals(expected));
  }
  
  @Test
  public void buildTest(){
    TreeNode root=new TreeNode(1);
    root.left=new TreeNode(2);
    root.right=new TreeNode(3);
    root.right.left=new TreeNode(4);
    root.right.right=new TreeNode(5);
    
//    System.out.println(root.toDeepString());
    TreeNode expected=BinaryTree.build(root.toDeepString());
//    BinaryTree.print(expected);
    Assert.assertTrue(root.equals(expected));
  }
  
  @Test
  public void traversePreorderTest(){
    TreeNode root=BinaryTree.build("[40,20,60,null,30,50]");
    List<TreeNode> preorder=BinaryTree.traversePreorder(root);
    String expected="[40, 20, 30, 60, 50]";
    Assert.assertEquals(expected, preorder.toString());
  }
  
  @Test
  public void traversePreorderIterativlyTest(){
    TreeNode root=BinaryTree.build("[40,20,60,null,30,50]");
    List<TreeNode> preorder=BinaryTree.traversePreorderIterativly(root);
    String expected="[40, 20, 30, 60, 50]";
    Assert.assertEquals(expected, preorder.toString());
  }
  
  @Test
  public void getAllLevelsTest(){
    TreeNode root=this.buildTestTree();
    List<List<TreeNode>> list=BinaryTree.getRealLevels(root);
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
    System.out.println(BinaryTree.getLeftBoundary(root));
    
    System.out.println("right boundary");
    System.out.println(BinaryTree.getRightBoundary(root));
    
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
    TreeNode root=BinaryTree.build("[1,2,3,4,5,5,null,23,8,10]");
    List<LinkedList<TreeNode>> list = BinaryTree.getPaths(root);
    BinaryTree.print(root);
    System.out.println("getPathsTest");
    list.stream().forEach(l->System.out.println(l));
    this.printSeperateLine();
    
    List<List<TreeNode>> list2 = BinaryTree.getPaths2(root);
    list2.stream().forEach(l->System.out.println(l));
    this.printSeperateLine();
  }
  @Test
  public void getVerticalSumTest(){
    TreeNode root=BinaryTree.build("[1,2,3,6,7,4,5]");
    int[] sum=BinaryTree.getVerticalSum(root);
    System.out.println("The sum is: " + Arrays.toString(sum));
    int[] expected={6,2,12,3,5};
    Assert.assertArrayEquals(expected, sum);
    this.printSeperateLine();
  }
  
//  @Test
//  public void getMaxTest(){
//    int[] nums=DataBuilder.getNumbersInRange(10, 30);
//    TreeNode root=BinaryTree.build(Arrays.toString(nums));
//    int max=IntStream.of(nums).max().getAsInt();
//    int expected=BinaryTree.getMax(root);
//    Assert.assertTrue(max==expected);
//  }
  
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
  /******************************************************/
  
  void printSeperateLine(){
    System.out.println("================");
  }
}
