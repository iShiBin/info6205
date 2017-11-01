package divideandconquer;

public class Power {
	public static int calculate(int a, int n){
		
		if (n==0) return 1;
		if (n==1) return a;
		
		int divide = n/2;
		int odd = n%2==1?a:1; // if n is odd, then divide it to a^(n/2) * a^(n/2) * a
		
		int product = calculate (a, divide);
		
		return product * product * odd;
	}
}
