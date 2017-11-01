import java.util.Arrays;

public class Class3 {

  public static boolean binary(int[] nums, int target) {
    // assert nums is a sorted integer array
    return binary(nums, target, 0, nums.length - 1);
  }

  private static boolean binary(int[] nums, int target, int start, int end) {
    if (start >= end)
      return false;
    int mid = start + (end - start) / 2;
    if (target == nums[mid]) {
      return true;
    } else if (target < nums[mid]) {
      return binary(nums, target, start, mid - 1);
    } else {
      return binary(nums, target, mid + 1, end);// exception
    }
  }

  // try the flip N technique
  public static void retote(int[] nums, int times) {
    reverse(nums);
    reverse(nums, 0, times - 1);
    reverse(nums, times, nums.length);
  }

  public static void reverse(int[] nums) {
    reverse(nums, 0, nums.length - 1);
  }

  public static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int t = nums[start];
      nums[start] = nums[end];
      nums[end] = t;
    }
  }

  // ---
  public static int getOccurance(int[] nums, int target) {
    return getOccurance(nums, target, 0, nums.length - 1);
  }

  private static int getOccurance(int[] nums, int target, int start, int end) {
    if (target < nums[start] || target > nums[end])
      return 0;
    if (target == nums[start] && target == nums[end])
      return end - start + 1;

    int mid = start + (end - start) / 2;
    if (nums[mid] == target) {
      return 1 + getOccurance(nums, target, start, mid - 1) + getOccurance(nums, target, mid + 1, end);
    } else if (nums[mid] < target) {
      return getOccurance(nums, target, mid + 1, end);
    } else {
      return getOccurance(nums, target, start, mid - 1);
    }
  }

  public static int findFirstOccurance(int[] nums, int target) {

    return 0;
  }

  // homework
  public static int findLastOccurance(int[] nums, int target) {

    return 0;
  }

  // find the index of first element bigger than a target element
  public static int findCeiling(int[] nums, int target) { // ??? todo
    int start = 0, end = nums.length - 1, mid = 0;
    if (target < nums[start])
      return 0;
    if (nums[end] < target)
      return -1;

    while (start <= end) {
      mid = start + (start - end) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return mid;
  }

  public static int findFloor(int[] nums, int target) {

    return 0;
  }

  // return the peak element index :todo - iteration
  public static int findPeak(int[] nums) {
    int low = 0, high = nums.length - 1, mid = low + (low - high) / 2;

    return 0;
  }

  //
  public static int findSumClosestOrEqualTo(int[] nums, int target) {
    Arrays.sort(nums);

    int low = 0, high = nums.length - 1, sum = 0;
    
    while(low < high){
      sum = nums[low] + nums[high];
      if(sum == target){
        break;
       } else if (sum < target) {
//         if(nums[low+1]-nums[low] <= target - sum) 
         low++;
       } else {
//         if(nums[high] - nums[high - 1] <= target - sum) 
         high--;
       }
      
      //let's find the closest if the equal doesn't exist
    }
    
    return sum;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] nums = { 1, 1, 1, 3, 3, 3, 3, 5, 5, 5, 5, 5, 6, 6, 6, 6, 8, 8, 8 };
//    System.out.println(getOccurance(nums, 3));// 4

//    System.out.println(findCeiling(nums, 4));//
    
    nums = new int[]{-5, -3, 5, 8, 11, 15, 17};
//    System.out.println(findSumClosestTo(nums, 21));
  }

}
