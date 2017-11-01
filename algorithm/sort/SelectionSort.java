package sort;

public class SelectionSort {
	public static int sort(double[] nums){
		int counter = 0;
		int length = nums.length;
		for(int i=0;i<length-1;i++){
			for(int j=i+1;j<length;j++){
				counter++;
				if(nums[i]>nums[j]) {
					double t = nums[i];
					nums[i]=nums[j];
					nums[j]=t;
					//System.out.println("Swapped "+ nums[j]+" "+nums[i]);
				}
			}
			//System.out.println(Arrays.toString(nums));
		}
		return counter;
	}
}
