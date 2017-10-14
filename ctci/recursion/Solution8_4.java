package recursion;

import java.util.ArrayList;

/* Power Set: Write a method to return all subsets of a set.
 * Algorithm: Generating P(n) for the general case is just a simple generalization of
 * adding case n to case n-1. We compute P(n-1), clone the result, and then add a En
 * to each of these cloned sets.
 * Note: This is a copy from the solution in the book.
 */
public class Solution8_4 {
  
  //this method is a little bit hard to understand
  public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
    ArrayList<ArrayList<Integer>> allsubsets;
    if (set.size() == index) { // Base case - add empty set
      allsubsets = new ArrayList<ArrayList<Integer>>();
      allsubsets.add(new ArrayList<Integer>()); 
    } else {
      allsubsets = getSubsets(set, index + 1);
      int item = set.get(index);
      ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
      for (ArrayList<Integer> subset : allsubsets) {
        ArrayList<Integer> newsubset = new ArrayList<Integer>();
        newsubset.addAll(subset); 
        newsubset.add(item);
        moresubsets.add(newsubset);
      }
      allsubsets.addAll(moresubsets);
    }
    return allsubsets;
  }
  
  //this is the second way using combinatorics. clearer than the first way **
  public static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
    ArrayList<Integer> subset = new ArrayList<Integer>(); 
    int index = 0;
    for (int k = x; k > 0; k >>= 1) {
      if ((k & 1) == 1) {
        subset.add(set.get(index));
      }
      index++;
    }
    return subset;
  }
  
  public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
    ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
    int max = 1 << set.size(); /* Compute 2^n */ 
    for (int k = 0; k < max; k++) {
      ArrayList<Integer> subset = convertIntToSet(k, set);
      allsubsets.add(subset);
    }
    return allsubsets;
  }
  
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i = 1; i < 4; i++) {
      list.add(i);
    }
    ArrayList<ArrayList<Integer>> subsets = getSubsets(list, 0);
    System.out.println(subsets.toString()); 
  }
}
