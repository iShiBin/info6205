package backtrack;

import java.util.*;

public class BinarySequence {
  
  //0s and 1s
  public static List<int[]> generate(int n){
    List<int[]> list=new ArrayList<>();
    int[] nums=new int[n];
    generate(list, nums, 0);
    return list;
  }
  //todo
  private static void generate(List<int[]> list, int[] temp, int start){
    if(start==temp.length) list.add(Arrays.copyOf(temp, temp.length));
    for(int i=0;i<2;i++){
      temp[start]=i;
      generate(list, temp, start+1);
    }
  }

//  todo: mCn
  
  public static void main(String[] args) {
    System.out.println(generate(3));
  }

}
