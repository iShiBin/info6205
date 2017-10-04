package array;
/* String Compression
 * Implement a method to perform basic string compression using the counts of repeated characters. 
 * For example, the string aabcccccaaa would become a2blc5a3. 
 * If the "compressed" string would not become smaller than the original string, your method should return the original string. 
 * You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class Solution1_6{
	/*
	public String compress(String str){
		if(str == null) return null;
		int n = str.length();
		if(n < 2) return str;

		StringBuffer sb = new StringBuffer();
		char[] chs = str.toCharArray();
		for(int i=1;i<n;i++){
			int count = 1;
			while(i<n && chs[i] == chs[i-1]) {
				i++;
				count++;
			}
			sb.append(String.valueOf(chs[i-1]));
		        sb.append(String.valueOf(count));
		}

		// deal with the last char if it is different than the previous one
		if(n > 1 && chs[n-1] != chs[n-2]) {
			sb.append(chs[n-1]);
			sb.append(1);
		}
		return sb.length() < n?sb.toString():str;
	}
	*/
	// improved logic: learn this code style
	public String compress(String str){
		StringBuilder compressed = new StringBuilder();
		int count = 0;
		for(int i = 0; i < str.length(); i++){
			count++;
			//if next char is different that current, append this char to result.
			if( i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				compressed.append(str.charAt(i));
				compressed.append(count);
				count = 0;
			}
		}
		return compressed.length() < str.length() ? compressed.toString() : str;
	}
}

