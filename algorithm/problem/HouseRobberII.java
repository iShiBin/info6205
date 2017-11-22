package problem;

import java.util.Arrays;

/**
 * House Robber II
 * <link>
 * https://leetcode.com/problems/house-robber-ii/description/ 
 * 
 * Note: This is an extension of House Robber.
 * 
 * After robbing those houses on that street, the thief has found himself a new
 * place for his thievery so that he will not get too much attention. This time,
 * all houses at this place are arranged in a circle. That means the first house
 * is the neighbor of the last one. Meanwhile, the security system for these
 * houses remain the same as for those in the previous street.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author bin
 *
 */
public class HouseRobberII {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;
    if (nums.length == 1)
      return nums[0];
    if (nums.length == 2)
      return Math.max(nums[0], nums[1]);
    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
  }
  
//  Divide and conquer: https://leetcode.com/problems/house-robber-ii/discuss/
  private int rob(int[] nums, int i, int j) {
    int[] dp = new int[j + 1];
    dp[i] = nums[i];
    for (int k = i + 1; k <= j; k++) {
      dp[k] = Math.max(dp[k - 1], (k - i < 2 ? 0 : dp[k - 2]) + nums[k]);
    }
    return dp[j];
  }
  
  /* Another way to solve the problem by using the HouseRobberI is to create two new arrays.
   * One of which includes nums[0], and the other one does not include it. 
   * 
   * However, this used more space (2*n) so it is not recommended. 
   * 
   */
  public int rob2(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    if(nums.length==1) return nums[0];
    if(nums.length==2) return Math.max(nums[0], nums[1]);
        
    int[] include=Arrays.copyOf(nums, nums.length-1);
    int[] exclude=Arrays.copyOfRange(nums, 1, nums.length);
    HouseRobberI reuse=new HouseRobberI();
    return Math.max(reuse.robDP(include), reuse.robDP(exclude));
  }
}
