package array;

/* URLify: Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has suf cient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string.
 * (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
 * EXAMPLE: Input: "Mr John Smith ", 13 Output: "Mr%20John%20Smith":
 */
public class Solution1_3{
	public static String URLify(String input, int length){
		if(input == null) return null;
		char[] chars = input.toCharArray();
		int left = length - 1, right = chars.length - 1;
		while(left >= 0){
			if(chars[left] == ' '){
				chars[right--] = '0';
				chars[right--] = '2';
				chars[right--] = '%';
				left--;
			} else {
			       chars[right--] = chars[left--];
			}
		}

		return String.valueOf(chars, right+1, chars.length - right - 1);
	}

	public static void main(String[] args){
		String input = "Mr John Smith         ";
		int length = 13;
		System.out.println(URLify(input, length));
	}
}
//Time: O(n); Space: O(n)
