package dynamicprogramming;

/**House Robber
 * <link> https://leetcode.com/problems/house-robber/description/
 * 
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money sashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author bin
 *
 */
class HouseRobber {
  
  /* #Dynamic Programming
   * f(i): the max money the robber can get by robbing house 0...i
   * f(i+1) = max of:
   * f(i): do not rob house i+1 (because house i has been robbed)
   * f(i-1) + nums[i+1]: rob house i+1, but do not rob hours i
   * O(n); O(n)
   */
  public int robDPI(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1], (i < 2 ? 0 : dp[i - 2]) + nums[i]);
    }
    return dp[dp.length - 1];
  }
  
  /**
   * Reduce the space complexity to O(1) by using 3 variables
   * @param args
   */
  public int robDPII(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int max = 0;
    int i2 = 0, i1 = 0;
    for (int i = 0; i < nums.length; i++) {
      max = Math.max(i1, i2 + nums[i]);
      i2 = i1;
      i1 = max;
    }
    return max;
  }
  
  /*Note: By setting i2 as the prevMax, and i1 is the currMax, we can get some similar code as:
   * <link>  https://leetcode.com/problems/house-robber/solution/
   * 
   */
  public int robDPIII(int[] num) {
    int prevMax = 0;
    int currMax = 0;
    for (int x : num) {
      int temp = currMax;
      currMax = Math.max(prevMax + x, currMax);
      prevMax = temp;
    }
    return currMax;
  }
  
}
