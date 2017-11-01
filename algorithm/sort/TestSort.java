package sort;

import java.util.Arrays;

public class TestSort {
	private static int SIZE = 5000000;
	private static double[] nums = new double[SIZE];

	public static void main(String[] args) {
		Double db = Double.parseDouble("65.5693658536586");
		
		System.out.println(db);
		
	
		// TODO Auto-generated method stub
		/*
		generateData();
		long startTime, endTime;
		
		
		double[] data1 = Arrays.copyOfRange(nums, 0, SIZE);
		startTime=System.currentTimeMillis();
		Selection.sort(data1);
		endTime = System.currentTimeMillis();
		System.out.println("Selection:\t"+(endTime-startTime));//+Arrays.toString(data1));

		double[] data2 = Arrays.copyOfRange(nums, 0, SIZE);
		startTime=System.currentTimeMillis();
		Insertion.sort(data2);
		endTime = System.currentTimeMillis();
		System.out.println("Insertion:\t"+(endTime-startTime));//+Arrays.toString(data1));

		
		double[] data3 = Arrays.copyOfRange(nums, 0, SIZE);
		startTime=System.currentTimeMillis();
		Arrays.sort(data3);
		endTime = System.currentTimeMillis();
		System.out.println("ArraysSort:\t"+(endTime-startTime));//+Arrays.toString(data1));
		data3=null;
		
		double[] data4 = nums;//Arrays.copyOfRange(nums, 0, SIZE);
		startTime=System.currentTimeMillis();
		Arrays.parallelSort(data4);
		endTime = System.currentTimeMillis();
		System.out.println("ParallelSort:\t"+(endTime-startTime));//+Arrays.toString(data1));
		data4=null;
		*/
		
	}
	
	private static void generateData(){
		for(int i=0;i<SIZE;i++){
			nums[i]=Math.random();
		}
	}

}
