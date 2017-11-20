package tree;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySearchTreeTest {

  TreeNode root=null;
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    
  }

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void test() {
    int[] nodes={1,8,3,5,7,9,10,4};
    root=BinarySearchTree.buildMinBST(nodes);
    Assert.assertTrue(false==BinarySearchTree.isValidBST(root));
    BinaryTree.print(root);
    
    Arrays.sort(nodes);
    TreeNode tree=BinarySearchTree.buildMinBST(nodes);
    BinaryTree.print(tree);
    Assert.assertTrue(true==BinarySearchTree.isValidBST(tree));
    
  }

}
