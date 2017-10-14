package bit;

public class Solution5_3 {
  public static int getLongestSequence(int n){
    int cur=0, pre=0, max=1;
    while(n!=0){
      if( (n&1)==1 ) cur++;
      else if( (n&1)==0 ){
        pre=(n&2)==0?0:cur;
        cur=0;
      }
      max=Math.max(pre+cur+1,  max);
      n >>>= 1;
    }
    return max;
  }
  
  public static void main(String[] args) {
    System.out.println(getLongestSequence(1775));
  }

}
