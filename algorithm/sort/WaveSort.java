package sort;
import java.util.Arrays;

public class WaveSort {

  // O(n*log(n))
  public static void run(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i += 2) {
      int t = nums[i];
      nums[i] = nums[i + 1];
      nums[i + 1] = t;
    }
  }

  // O(n): todo
  public static void runFaster(int[] nums) {
    if(nums.length <= 1) return ;
    
    
    
    for (int i = 1; i < nums.length; i++) {
      
    }
  }

  public static void main(String[] args) {
    int[] nums = { 1, 5, 3, 4, 7, 2, 6 };

  }

}
