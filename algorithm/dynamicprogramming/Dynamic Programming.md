Usually, solving and fully understanding a dynamic programming problem is a [4 step process](https://leetcode.com/problems/jump-game/solution/):

1. Start with the recursive backtracking solution
2. Optimize by using a memoization table (top-down[3] dynamic programming)
3. Remove the need for recursion (bottom-up dynamic programming)
4. Apply final tricks to reduce the time / memory complexity

All solutions presented below produce the correct result, but they differ in run time and memory requirements.

This is a pretty decent explanation on two different approaches of Dynamic Programming algorithm - [Dynamic programming and memoization: bottom-up vs top-down approaches](https://stackoverflow.com/questions/6164629/dynamic-programming-and-memoization-bottom-up-vs-top-down-approaches).

Here is the example of some solutions of get a [Fibonacci number](https://en.wikipedia.org/wiki/Fibonacci_number)

# I. Recursion

```java
  static long recursion(int n){
    if(n<0) return -1;
    else if(n<2) return n;
    else return recursion(n-1) + recursion (n-2);
  }
```

However, the problem of this algorithm is the duplicating recalculation.

<img src="https://www.cs.cmu.edu/~adamchik/15-121/lectures/Recursions/pix/fib.bmp" style="zoom:50%" />

For example, the F(0) was calculated 3 times and F(1) was 5 times. So in order to avoid the duplicated work, we can use two strategy **memoization** and **tabulation**, which are two different type of Dynamic Programming.

#II. Memorization

Some people call this top-down recursion. This approach is to memorize the calculated value. Normally, we can use a hash map to cache the solution of subproblem like below.

```java
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
```

# III. Tabulation

This is a bottom-up approach, meaning solve the a small scale sub-problem first. It is like to fill the result using a table from the small case to the big case. Sometimes, we need a 2D matrix or tree to achieve the same goal. Here is the implementation of counting Fib number using tabulation.

```java
  static long tabulation(int n){
    int[] nums=new int[n+1];
    nums[0]=0;
    nums[1]=1;
    for(int i=2;i<=n;i++){
      nums[i]=nums[i-1]+nums[i-2];
    }
    return nums[n];
  }
```

There is a variation of this approach which is to only cache the necessary intermediate result like below.

```java
  static long iteration(int n){
    long fib=-1;
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
```

# Conclusion

> Memoization is very easy to code (you can generally* write a "memoizer" annotation or wrapper function that automatically does it for you), and should be your first line of approach. The downside of tabulation is that you have to come up with an ordering.

Here is the comparation of running time for these 4 appreaches for the 50th of Fibonacci number.

| Approach    | Time (second) | Result      | Note                           |
| ----------- | ------------- | ----------- | ------------------------------ |
| recursion   | 68            | 12586269025 | It takes too long to complete! |
| memoization | 0.001         | 12586269025 | fairly good                    |
| tabulation  | 0.001         | 12586269025 | fairly good                    |
| iteration   | 0             | 12586269025 | the best                       |

>Here is some thoughts on solving [Jump Game](https://leetcode.com/problems/jump-game/) [with differenct approaches](https://leetcode.com/problems/jump-game/solution/).
>
>The question left unanswered is how should one approach such a question in an interview scenario. I would say "it depends". The perfect solution is cleaner and shorter than all the other versions, but it might not be so straightforward to figure out.

> The (recursive) backtracking is the easiest to figure out, so it is worth mentioning it verbally while warming up for the tougher challenge. It might be that your interviewer actually wants to see that solution, but if not, mention that there might be a dynamic programming solution and try to think how could you use a memoization table. If you figure it out and the interviewer wants you to go for the top-down approach, it will not generally be time to think of the bottom-up version, but I would always mention the advantages of this technique as a final thought in the interview.

> Most people are stuck when converting from top-down Dynamic Programming (expressed naturally in recursion) to bottom-up. Practicing similar problems will help bridge this gap.

# Source Code File

.\Fibonacci.java

.\FibonacciTest.java

# References

[Jump Game](https://leetcode.com/problems/jump-game/solution/) 

Challenges https://leetcode.com/tag/dynamic-programming/