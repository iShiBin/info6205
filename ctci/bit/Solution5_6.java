package bit;

public class Solution5_6 {
  public static int flipToConvert(int a, int b){
    int c=a^b;
    int n=0;
    while(c!=0){
      n+= (c&1);
      c>>>=1;
    }
    return n;
  }
  
  public static int bitSwapRequired(int a, int b){
    int count=0;
    for(int c=a^b;c!=0;c=c&(c-1)){
      count++;
    }
    return count;
  }

  public static void main(String[] args){
    int a=29, b=15;
    System.out.print(flipToConvert(a,b));
  }
}
