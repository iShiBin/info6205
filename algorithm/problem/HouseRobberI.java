package problem;

import java.util.*;

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
 * 2017-11-22
 */

/* # Algorithm
 * Pick the max money between robbing the house i or not robbing i.
 * define rob(i)=the max money you can get from robbing house 0...i.
 * rob(i)=max(rob(i-1), rob(i-2) + nums[i]) - rob(i-1): not rob house i.
 * rob(i-2) + nums[i]: rob house i (since you cannot rob the previous house i-1,
 * so the money you can get is rob(i-2) instead.
 */
class HouseRobberI {
  /* Brute Force: O(2^n) - 21s when there are 48 houses 👎
   * Use recursion to calculate every possibility of robbing i and not robbing i.
   */
  public int robBF(int [] nums){
      if(nums==null || nums.length==0) return 0;
      return robBruteForce(nums, nums.length-1);
  }
  private int robBruteForce(int[] nums, int i){
      if(i==0) return nums[0];
      else if(i==1) return Math.max(nums[0], nums[1]);
      else return Math.max(robBruteForce(nums, i-1), robBruteForce(nums, i-2) + nums[i]);
  }
  
//  Brute Force with Memorization: O(n) - 0s when nums.length is 48
  public int robBFM(int[] nums){
    if(nums==null || nums.length==0) return 0;
    int[] memo=new int[nums.length];//Map<Integer, Integer> memo=new HashMap<>();
    Arrays.fill(memo, -1);
    robBFM(nums, nums.length-1, memo);
    return memo[memo.length-1];
  }
  
  private int robBFM(int[] nums, int i, int[] memo){
    if(memo[i]==-1){
      if(i==0) memo[i]=nums[0];
      else if(i==1) memo[i]=Math.max(nums[0], nums[1]);
      else memo[i]=Math.max(robBFM(nums, i-1, memo), robBFM(nums, i-2, memo) + nums[i]);
    }
    return memo[i];
  }
  
  /* # Dynamic Programming: O(n) 👍
   * bottom up recursion or Tabulation
   */
  public int robDP(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1], (i < 2 ? 0 : dp[i - 2]) + nums[i]);
    }
    return dp[dp.length - 1];
  }
  
  /* Reduce the space complexity to O(1) by using some variables instead of an array
   * <link>  https://leetcode.com/problems/house-robber/solution/
   */
  public int robDPO(int[] num) {
    int prevMax = 0, currMax = 0;
    for (int x : num) {
      int temp = currMax;
      currMax = Math.max(prevMax + x, currMax);
      prevMax = temp;
    }
    return currMax;
  }
  
}
