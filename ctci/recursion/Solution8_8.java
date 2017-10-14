//8.8 Permutations with Duplicates @todo

package recursion;

import java.util.*;

class Solution8_8 {
  // approach I: use set to remove the duplicates
  static Set<String> permutate(String str) {
    Set<String> list = new HashSet<String>();
    if (str.length() == 1) {
      list.add(str);
    } else {
      Set<String> sub = permutate(str.substring(1));
      char ch = str.charAt(0);
      for (String s : sub) {
        list.addAll(insertCharToString(s, ch));
      }
    }

    return list;
  }

  static List<String> insertCharToString(String str, char c) {
    List<String> list = new ArrayList<String>();

    for (int i = 0; i <= str.length(); i++) {
      StringBuilder builder = new StringBuilder();
      builder.append(str.substring(0, i));
      builder.append(c);
      builder.append(str.substring(i));
      list.add(builder.toString());
    }
    return list;
  }

//  // approach II: use a set to cache all the past chars, avoid to process again.
//  **This is not working!** 
//  Set<Character> set = new HashSet<>();
//
//  List<String> permutateUnique(String str) {
//    System.out.println(set);
//    List<String> list = new ArrayList<String>();
//    if (str.length() == 1) {
//      char c0 = str.toCharArray()[0];
//      list.add(str);
//      set.add(c0);
//    } else {
//      List<String> sub = permutateUnique(str.substring(1));
//      char ch = str.charAt(0);
//      for (String s : sub) {
//        list.addAll(insertCharToString(s, ch, false));
//        set.add(ch);
//      }
//    }
//    return list;
//  }
//  
//  static List<String> insertCharToString(String str, char c, boolean isUnique) {
//    List<String> list = new ArrayList<String>();
//
//    for (int i = 0; i <= str.length(); i++) {
//      StringBuilder builder = new StringBuilder();
//      builder.append(str.substring(0, i));
//      if(i==str.length() || c!=str.charAt(i)) builder.append(c);
//      builder.append(str.substring(i));
//      list.add(builder.toString());
//    }
//    return list;
//  }
  
//  approach II: from the book
  public static HashMap<Character, Integer> buildFreqTable(String s) {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for (char c : s.toCharArray()) {
      if (!map.containsKey(c)) {
        map.put(c, 0);
      }
      map.put(c, map.get(c) + 1);
    }
    return map;
  }
  
  public static void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
    if (remaining == 0) {
      result.add(prefix);
      return;
    }
    
    for (Character c : map.keySet()) {
      int count = map.get(c);
      if (count > 0) {
        map.put(c,  count - 1);
        printPerms(map, prefix + c, remaining - 1, result);
        map.put(c,  count);
      }
    }
  }
  
  public static ArrayList<String> printPerms(String s) {
    ArrayList<String> result = new ArrayList<String>();
    HashMap<Character, Integer> map = buildFreqTable(s);
    printPerms(map, "", s.length(), result);
    return result;
  }
  
  public static void main(String[] args) {
    String s = "aba";
    ArrayList<String> result = printPerms(s);
    System.out.println("Count: " + result.size());
    System.out.println(result);
  }

}
