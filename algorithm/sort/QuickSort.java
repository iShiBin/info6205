package sort;

import java.util.*;
import java.util.stream.IntStream;

import org.junit.Assert;

//https://en.wikipedia.org/wiki/Quicksort

public class QuickSort {
  public static void sort(int[] nums) {

    if (nums.length < 1)
      return;
    sort(nums, 0, nums.length - 1);
  }

  private static void sort(int[] arr, int low, int high) {
    int index = partition(arr, low, high);
    if (low < index - 1)
      sort(arr, low, index - 1);
    if (index < high)
      sort(arr, index, high);
  }

//Hoare partition scheme, it is more efficient than the Lomuto partition scheme
//  because it does three times fewer swaps on average
  public static int partition(int[] nums, int low, int high) {
    int pivot = low+(high-low)/2;
    
    while(low <= high) {
      while(nums[low] < nums[pivot]) {
        low++;
      }
      while(nums[high] > nums[pivot]) {
        high--;
      }
      if(low <= high) {
        swap(nums, low, high);
        low++;
        high--;
      }
    }
    return low;
  }
  
  private static void swap(int[] nums, int i, int j){
    int t=nums[i];
    nums[i]=nums[j];
    nums[j]=t;
  }
  
  public static int findKth(int[] nums, int k){
    k-=1;//find the element with index (k-1) instead
    if(k>nums.length-1) k=nums.length-1;
    if(k<0) k=0;
    
    int low=0, high=nums.length-1;
    while(low<high){
      final int index=partition(nums, low, high);
      if(index<k) low=index+1;
      else if (index>k){
        high=index-1;
      }else{
        break;
      }
    }
    
    return nums[k];
  }
  
  
  public static int findKthLargest(int[] nums, int k){
    return findKth(nums, nums.length+1-k);
  }

  public static void main(String[] args) {
    Random r=new Random();
    int[] nums={3,2,1,5,6,4};
    int k=2;
    
//    verify sort
    for(int i=1;i<100;i++){
      nums=new int[]{2,1}; //r.ints(i, -i, i).distinct().toArray();
      int[] expected=Arrays.copyOf(nums, nums.length);
      sort(nums);
      Arrays.sort(expected);
      Assert.assertArrayEquals(nums, expected);
    }
    
//    find k-th
    for(int i=1;i<100;i++){
      nums = r.ints(i, -i, i).distinct().toArray();
      k= r.nextInt(nums.length)+1;
      assert findKth(nums, k) == IntStream.of(nums).sorted().skip(k-1).findFirst().getAsInt();
      assert findKthLargest(nums, k) == IntStream.of(nums).sorted().skip(nums.length-k).findFirst().getAsInt();
    }
    
  }
}
