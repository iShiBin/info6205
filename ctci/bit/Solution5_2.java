package bit;

public class Solution5_2 {
  
  // this is from the book
  public static String printBinary(double num) {
    if (num >= 1 || num <= 0) {
      return "ERROR";
    }
  
    StringBuilder binary = new StringBuilder();
    binary.append(".");
    while (num > 0) {
      /* Setting a limit on length: 32 characters */
      if (binary.length() > 32) {
        return "ERROR";
      }
      double r = num * 2;
      if (r >= 1) {
        binary.append(1);
        num = r - 1;
      } else {
        binary.append(0);
        num = r;
      }
    }
    return binary.toString();
  }
  
//  this is not correct!
//  public static String toBinaryStringUsingInteger(double d){
//    String s=String.valueOf(d).substring(2);
//    return "."+Integer.toBinaryString(Integer.valueOf(s));   
//  }
  
  public static void main(String[] args) {
//    System.out.println(Integer.toBinaryString(72));
    double d=0.72;
    System.out.println(printBinary(d));
//    System.out.println(toBinaryStringUsingInteger(d));
    
    for(int i=0;i<1000;i++){
      double num=1.0*i/1000;
//      if(!printBinary(num).equals(toBinaryStringUsingInteger(num))){
        System.out.println(num+":"+printBinary(num));
//      }
    }
  }
}
