package sort;

public class InsertionSort {
	public static int sort(double[] nums){
		int counter = 0;
		int length = nums.length;
		
		for(int i=0; i<length;i++){
			int ci = i;
			while(ci>0 && nums[ci]<nums[ci-1]){
				double temp = nums[ci];
				nums[ci]=nums[ci-1];
				nums[ci-1]=temp;
				ci = ci - 1;
				counter++;
			}
		}
		
		return counter;
	}
}
