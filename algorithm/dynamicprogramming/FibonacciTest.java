package dynamicprogramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {

  static final int N=50; 
  @Test
  public void recursionTest() {
    System.out.println(Fibonacci.recursion(N));
  }
  
  @Test
  public void tabulationTest(){
    System.out.println(Fibonacci.tabulation(N));
  }
  
  @Test
  public void memoizationTest(){
    System.out.println(Fibonacci.memoization(N));
  }

  @Test
  public void iterationTest(){
    System.out.println(Fibonacci.iteration(N));
  }
}
