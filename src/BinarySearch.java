

class BinarySearch {
  
  public static boolean run(int[] nums, int target){
//    assert nums is a sorted integer array

    return run(nums, target, 0, nums.length - 1);
  }
  
  private static boolean run(int[] nums, int target, int start, int end){
    if(start >= end) return false;
    int mid = start + (end - start) / 2;
    if(target == nums[mid]) {
      return true;
    }else if (target < nums[mid]){
      return run(nums, target, start, mid-1);
    } else {
      return run(nums, target, mid+1, end);//exception
    }
  }
  
  public static void main(String[] args) {
    int[] nums = {1,3,5,8,10,19};
    System.out.println(BinarySearch.run(nums, 10));//true
    System.out.println(BinarySearch.run(nums, 4));//true
  }

}
