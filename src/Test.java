import java.util.Arrays;

public class Test{
  
  public static void main(String[] args){
    int i=0b10011101;
    int n=1;
    System.out.println(n -= (i >>> 31));
  }
}