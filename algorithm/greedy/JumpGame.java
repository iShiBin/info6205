package greedy;

import java.util.Random;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 * Note: If there is no way to reach the end, return -1;
 * Otherwise, return the minimum number of jumps.
 * 
 * @author bin
 *
 */
class JumpGame {
  
  boolean canReach(int[] stairs){
    int reach=0;
    for(int i=0;i<stairs.length;i++){
      if(reach<i) return false;
      reach=Math.max(reach, i+stairs[i]);
    }
    return true;
  }
  
  int minStep(int[] stairs){
    if(!canReach(stairs)) return -1;
    int jumps = 0, curEnd = 0, curFarthest = 0;
    for (int i = 0; i < stairs.length - 1; i++) {
        curFarthest = Math.max(curFarthest, i + stairs[i]);
        if (i == curEnd) {
            jumps++;
            curEnd = curFarthest;
        }
    }
    return jumps;
  }

  public static void main(String[] args) {
    int[] nums=new Random().ints(100,0,10).toArray();
    System.out.println(new JumpGame().minStep(nums));
  }
}
