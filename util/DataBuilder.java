package util;

import java.util.*;

public class DataBuilder {
	
	// return to a random integer array having n values
	public static int[] getIntegers(int n){
		int[] numbers = new int[n];
		Random random = new Random();
		for(int i=0;i<n;i++){
			numbers[i] = random.nextInt();
		}
		return numbers;
	}
	
	// return a natrual number array of n elements in range [1,n)
	public static int[] getNumbersInRange(int n){
		int[] numbers = new int[n];
		Random random = new Random();
		for(int i=0;i<n;i++){
			numbers[i] = random.nextInt(n) + 1;
		}
		return numbers;
	}
	
	// return a natrual number array of n elements in range [1, max)
	public static int[] getNumbersInRange(int n, int max){
		int[] numbers = new int[n];
		Random random = new Random();
		for(int i=0;i<n;i++){
			numbers[i] = random.nextInt(max) + 1;
		}
		return numbers;
	}
}
