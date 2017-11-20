package dynamicprogramming;

import java.util.*;

import org.junit.Assert;

/**
 * Count the n-th (start from 0) of fibonacci number [0,1,1,2,3,5...]
 * @author bin
 *
 */
public class Fibonacci {
  
  static long recursion(int n){
    if(n<2) return n;
    else return recursion(n-1) + recursion (n-2);
  }

  static long tabulation(int n){
    long[] nums=new long[n+1];
    nums[0]=0;
    nums[1]=1;
    for(int i=2;i<=n;i++){
      nums[i]=nums[i-1]+nums[i-2];
    }
    return nums[n];
  }
  
  static long memoization(int n){
//    could use int[] or a list
    Map<Integer, Long> map=new HashMap<>();
    map.put(0, Long.valueOf(0));
    map.put(1, Long.valueOf(1));
    return memoization(n, map);
  }
  
  private static long memoization(int n, Map<Integer, Long> map){
    if(!map.containsKey(n)){
      if(n<=1) return n;
      long n1=memoization(n-1, map);
      long n2=memoization(n-2, map);
      
      map.put(n, n1+n2);
    }
    return map.get(n);
  }
  
  static long iteration(int n){
    long fib=0;
    if(n<2) fib=n;
    else{
      long n2=0, n1=1;
      for(int i=2;i<=n;i++){
        fib=n2+n1;
        n2=n1;
        n1=fib;
      }
    }
    return fib;
  }

}
