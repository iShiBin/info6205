package recursion;

import java.util.*;

class Solution8_7 {
  //approach I: building from permutations of the n-1 list. 
  //~150ms on input string "insertTo" in leetcode.com
  static List<String> permutate(String str){
    List<String> list=new ArrayList<String>();
    if(str.length()==1){
      list.add(str);
    }else{
      List<String> sub=permutate(str.substring(1));
      char ch=str.charAt(0);
      for(String s:sub){
        list.addAll(insertCharToString(s,ch));
      }
    }
    
    return list;
  }
  
  static List<String> insertCharToString(String str, char c){
    List<String> list=new ArrayList<String>();

    for(int i=0;i<=str.length();i++){
      StringBuilder builder=new StringBuilder();
      builder.append(str.substring(0, i));
      builder.append(c);
      builder.append(str.substring(i));
      list.add(builder.toString());
    }
    return list;
  }
  
  //approach II: building from permutations of all n-1 substrings
  //also, it is like divide and conquer
  //~250ms on input string "insertTo" in leetcode.com
  static List<String> getPerms(String str){
    int len=str.length();
    List<String> result=new ArrayList<String>();
    
    //base case
    if(len==0) result.add(new String());
    else{
      for(int i=0;i<len;i++){
        //remove char i and find permutations of remaining chars
        String head=str.substring(0, i);
        String tail=str.substring(i+1);
        List<String> partials=getPerms(head+tail);
        
        //prepend char i to each permutation
        for(String s:partials){
          result.add(str.charAt(i)+s);
        }
      }
    }
    
    return result;
  }

  public static void main(String[] args) {
    String str = "insertTo";
    // for(String s:permutate(str)) System.out.println(s);
    // for(String s:getPerms(str)) System.out.println(s);
    // permutate(str);
    getPerms(str);

    // for(String s:insertCharToString(str,'*')) System.out.println(s);

  }

}
