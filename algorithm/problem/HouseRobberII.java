package problem;

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
}
