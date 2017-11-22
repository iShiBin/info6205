package problem;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseRobberITest {

  HouseRobberI test=new HouseRobberI();
  int[] nums={114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
  int expected;
  
  @Before
  public void setUp() throws Exception {
    expected = test.robDP(nums);
  }

  @Test
  public void bruteForce() {
//    Assert.assertTrue(test.robBF(nums)==expected);
  }
  
  @Test
  public void bruteForceMemorization(){
    Assert.assertTrue(test.robBFM(nums)==expected);
  }
  
  @Test
  public void dynamicProgramming(){
    System.out.println(nums.length);
    Assert.assertTrue(test.robDP(nums)==expected);
  }

}
