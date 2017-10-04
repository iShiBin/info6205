package assignment;

import java.util.*;

public class Assignment3 {    
    public static int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else if (nums[mid] > nums[mid + 1]) {
                high = mid; // trick
            }
        }
        return nums[low];
    }

    public static int[] findClosestToZero(int[] nums) {
        if (nums == null || nums.length < 2)
            throw new IllegalArgumentException();
        Arrays.sort(nums);

        int low = 0, high = nums.length - 1;
        while (low < high - 1) {
            int sum = nums[low] + nums[high];
            if (sum == 0)
                break;
            else if (sum < 0) {
                if(Math.abs(nums[low+1]+nums[high]) > Math.abs(sum)) break;
                low++;
            } else {
                if(Math.abs(nums[low]+nums[high-1]) > Math.abs(sum)) break;
                high--;
            }
        }
        return new int[] { nums[low], nums[high] };
    }
    
    public static void main(String[] args) {
        List<int[]> list=new ArrayList<>();
        list.add(new int[]{1,3});
        list.add(new int[]{1,9,-5,3});
        list.add(new int[]{-1,5,9,3});
        list.add(new int[]{9,5,-3,1});
        
        for(int[] nums:list){
            System.out.println(Arrays.toString(findClosestToZero(nums)));
        }
    }
}

