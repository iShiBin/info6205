package array;
/* Palindrome Permutation: 
Given a string, write a function to check if it is a permutation of a palin­ drome. 
A palindrome is a word or phrase that is the same  rwards and backwards. 
A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.

EXAMPLE:
Input: Tact Coa
Output: True (permutations: "taco cat", "atco eta", etc.)
*/

public class Solution1_4{
	public static boolean isPalindromePermutation(String str){
		boolean[] bal = new boolean[128];
		for(char ch:str.toLowerCase().toCharArray()){
			if(ch == ' ') continue;
			bal[ch] = !bal[ch];
		}
		int count = 0;
		for(boolean b:bal){
			if(b) count++;
		}

		return count<2;
	}

    public static boolean isPalindromePermutationBit(String str){
        int flag=0;
//        str=str.toLowerCase(); 'A'=0b1000001 so no need to convert
        for(char c:str.toCharArray()){
            if(c!=' ') flag^=c;
        }
        return flag==0 || ('A'<=flag&&flag<='z');
    }

}
