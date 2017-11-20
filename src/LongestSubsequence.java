import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Assert;

/**
 * Longest Increasing Subsequence. (homework of class 1119) Given an unsorted
 * array of integers, find the length of longest increasing subsequence.
 * 
 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18], The longest increasing
 * subsequence is [2, 3, 7, 101], therefore the length is 4.
 * 
 * <link>
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 * 
 * @author bin
 */
class LongestSubsequence {

//  binary search approach. O(n*log(n))
//  https://leetcode.com/problems/longest-increasing-subsequence/solution/
  public int[] getLIS(int[] nums) {
    int[] dp = new int[nums.length];
    int len = 0;
    for (int num : nums) {
      int i = Arrays.binarySearch(dp, 0, len, num);
      // System.out.println(i);
      // System.out.println(Arrays.toString(dp));
      if (i < 0) {
        i = -(i + 1);
      }
      dp[i] = num;
      if (i == len) {
        len++;
      }
    }
    return Arrays.copyOf(dp, len);
  }
  
//  dynamic approach. O(n^2)
  public int[] getLISDP(int[] nums){
    int[] memo=buildMemo(nums);
    
    int max=0, index=0;
    for(int i=0;i<memo.length;i++){
      if(memo[i]>max){
        max=memo[i];
        index=i;
      }
    }
    
    int[] path=new int[max];
    for(int i=index;i>=0 && max>0;i--){
      if(memo[i]==max){
        path[--max]=nums[i];
      }
    }
    
    return path;
  }
  
  private int[] buildMemo(int[] nums) {
    if (nums == null || nums.length == 0)
      return null;
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);
    int max = 1;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1;
          if (max < dp[i])
            max = dp[i];
        }
      }
    }
    return dp;
  }

  public static void main(String[] args) {
    LongestSubsequence test=new LongestSubsequence();
    int[] nums={10, 9, 2, 5, 3, 7, 101};
    System.out.println(Arrays.toString(test.getLIS(nums)));
    System.out.println(Arrays.toString(test.getLISDP(nums)));
    
    for(int i=1;i<100;i++){
      nums=new Random().ints(i).toArray();
      int l1=test.getLIS(nums).length;
      int l2=test.getLISDP(nums).length;
      Assert.assertTrue(l1==l2);
//      System.out.println(Arrays.toString(test.getLIS(nums)));
//      System.out.println(Arrays.toString(test.getLISDP(nums)));
    }
  }

}
