/**
 * 
 */
package tree;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;


/**
 * @author bin
 *
 */
public class MinHeadTest {

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void test() {
    MinHeap heap = null;
    
    for(int i=0;i<1000;i++){
      int[] nums=new Random().ints(i+1).toArray();
      heap=new MinHeap(nums);
//      System.out.println(heap);
      Assert.assertTrue(true==heap.isValid());
    }
    
  }

}
