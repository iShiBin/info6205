package sort;
import java.util.Arrays;

public class SelectionSort {

	public static void sort (int[] nums){
		if (nums==null || nums.length == 0 ) return;

		for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
//				if(nums[i]>nums[j]) swap(nums,i,j);
			}
		}
		
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {6,5,3,1,8,7,2,4};
		SelectionSort.sort(n);
		System.out.println(Arrays.toString(n));
	}

}
