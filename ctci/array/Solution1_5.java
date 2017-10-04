package array;
/* One Way
 * There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. 
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true pales, pale -> true pale, bale -> true pale, bake -> false
*/
public class Solution1_5{
	public boolean isOneAway(String a, String b){
		if(a == null && b == null ) return true;
		if(a == null || b == null ) return false;
		if(a.equals(b)) return true;
		if(Math.abs(a.length() - b.length()) > 1) return false;

		return validate(a,b);
	}

	private boolean validate(String a, String b){
		int i = 0, j=0, edit = 0;
		while(i < a.length() && j < b.length() && edit < 2 ) {
			if(a.charAt(i) != b.charAt(j)) {
				edit++;
				if(a.length() >= b.length()) i++;
				if(a.length() <= b.length()) j++;
			} else { i++; j++; }
		}
		return edit < 2;
	}
}
//Time: O(n) n=the length of the shorter string.
//Space: O(1)
//https://leetcode.com/problems/one-edit-distance/description/
