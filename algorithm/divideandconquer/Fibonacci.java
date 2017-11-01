package divideandconquer;

/** by Bin on 2017/03/15
 ** Java Program to Implement Efficient O(log n) Fibonacci generator.
 ** The trip is to use the devide and conqure to downsize the problem from M^n to M^(n/2) * M^(n/2) (* M possibly)
 ** ,which can reduce the complexity from O(n) to O(logN).
 **/
 
import java.util.Scanner;
import java.math.BigInteger;

public class Fibonacci
{
	private static final BigInteger atom[][] = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}}; 
	
    /** function to generate nth fibonacci number **/
    public static BigInteger getNth(long n)
    {
        if (n == 0 || n == 1) { return BigInteger.valueOf(n); }
        else { return power(atom, n - 1)[0][0]; }  
    }
    /** function raise matrix to power n recursively **/
    private static BigInteger[][] power(BigInteger[][] base, long n)
    {
        if (n == 0 || n == 1) return atom;
        
        BigInteger fib[][] =  power(base, n/2);
        fib = Fibonacci.multiply(fib, fib);
        if (n%2 == 1) fib = Fibonacci.multiply(fib, base);
        
        return fib;
    }     
    /** function to multiply two 2 d matrices **/
    private static BigInteger[][] multiply (BigInteger a[][], BigInteger b[][])
    {
        BigInteger x = (a[0][0].multiply(b[0][0])).add(a[0][1].multiply(b[1][0]));
        BigInteger y = (a[0][0].multiply(b[0][1])).add(a[0][1].multiply(b[1][1]));
        BigInteger z = (a[1][0].multiply(b[0][0])).add(a[1][1].multiply(b[1][0]));
        BigInteger w = (a[1][0].multiply(b[0][1])).add(a[1][1].multiply(b[1][1]));
        
        return new BigInteger[][]{{x, y},{z, w}};
    }
    /** Main function **/
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Efficient Fibonacci Generator O(logn)\n");
        System.out.println("Enter number n to find nth fibonacci number\n");
        long n = scan.nextLong();
        for(int i=0; i<=n; i++) {
        	System.out.print(Fibonacci.getNth(i)+" ");
        }
        scan.close();
    }
}