package array;

//Check Permutation: Given two strings,write a method to decide if one is a permutation of the other.
public class Solution1_2{
	public static boolean isPermutation(String s, String t){
		if(s.length() != t.length()) return false;
		int[] count = new int[128];
		for(char ch:s.toCharArray()){
			count[ch] += 1;
		}

		for(char ch:t.toCharArray()){
			count[ch] -= 1;
		}

		for(int i=0; i<count.length;i++){
			if(count[i] != 0) return false;
		}

		return true;
	}

	public static void main(String[] args){
		String s = "permutation";
		String t = "tiontaumrep";
		System.out.println(isPermutation(s,t));//true

		t = "permutati*n";
		System.out.println(isPermutation(s,t));
	}
}
//time: O(min(m,n)); space: O(1)
