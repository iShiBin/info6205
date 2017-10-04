/*Is Unique: Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?
 */
package array;
public class Solution1_1{
  public static boolean isUnique(String str){
    if(str.length()>128) return false;
    boolean[] mark = new boolean[128];
    for(char ch:str.toCharArray()){
      if(mark[ch]) return false;
      mark[ch] = true;
    }
    return true;
  }

  public static void main(String[] args){
    String string = "This is not a unique string.";
    System.out.println(isUnique(string));

    string = "Unique";
    System.out.println(isUnique(string));
  }
}
//time: O(1), space: O(1)
