/**
 * 
 */
package bitmanuplation;

/**
 * @author bin
 *
 */
class SingleNumber {

  /**
   * Given an array of integers, every element appears twice except for one.
   * Find that single one. <link>
   * https://leetcode.com/problems/single-number/description/ Note: Your
   * algorithm should have a linear runtime complexity. Could you implement it
   * without using extra memory?
   * 
   * @param nums
   * @return
   */
  int singleNumberI(int[] nums) {
    int mask = 0;
    for (int n : nums) {
      mask ^= n;
    }
    return mask;
  }

  /**
   * Given an array of integers, every element appears three times except for
   * one, which appears exactly once. Find that single one. <link>
   * https://leetcode.com/problems/single-number-ii/description/
   * 
   * @param nums
   * @return
   */
  int singleNumberII(int[] nums) {
    int ones = 0, twos = 0;
    for (int i = 0; i < nums.length; i++) {
      ones = (ones ^ nums[i]) & ~twos;
      twos = (twos ^ nums[i]) & ~ones;
    }
    return ones;
  }

  /**
   * Given an array of numbers nums, in which exactly two elements appear only
   * once and all the other elements appear exactly twice. Find the two elements
   * that appear only once.
   * 
   * For example:
   * 
   * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
   * 
   * @param nums
   * @return
   */

  public int[] singleNumberIII(int[] nums) {
    int diff = 0;
    for (int n : nums) {
      diff ^= n;
    }

    diff &= -diff;// Bit Hack #8. Right propagate the rightmost 1-bit.

    int[] single = new int[2];
    for (int n : nums) {
      if ((n & diff) == 0)
        single[0] ^= n;
      else
        single[1] ^= n;
    }
    return single;
  }

}
