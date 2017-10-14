package recursion;
/* 8.1 Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible way the child can run up the stairs.
 */
public class Solution8_1 {

  public static long count(int n){
    /* define count(0)==1 will make the base case number less
    if(n==1) return 1;
    if(n==2) return 2;
    if(n==3) return 4;
    */
    if(n<0) return 0;
    else if(n==0) return 1;
    else return count(n-1)+count(n-2)+count(n-3);
  }
  
  public static long countI(int n){
    long[] memo=new long[n+1];
    countI(n, memo);
    return memo[n];
  }
  private static long countI(int n, long[] memo){
    if(n<0) return 0;
    else if(n==0) return 1;
    else if(memo[n]==0){
      // which to calculate first doesn't matter here.
      memo[n] = countI(n-1, memo)+countI(n-2,memo)+countI(n-3,memo);
    }
    return memo[n];
  } 
  
  public static long countII(int num){
    if(num<=0) return 0;
    long n1=1,n2=2,n3=4;
    for(int i=4;i<num;i++){
      long n=n1+n2+n3;
      n1=n2;
      n2=n3;
      n3=n;
    }
    return n1+n2+n3;
  }
  
  public static void main(String[] args) {
    int n=50;
//    System.out.println(count(n));
    System.out.println(countI(n));
    System.out.println(countII(n));
  }

}