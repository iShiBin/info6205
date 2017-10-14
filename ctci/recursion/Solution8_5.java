package recursion;

public class Solution8_5 {
  
  static long multiply(int x, int y){
    if(x>y) return multiply(y,x);
    
    if(x==0){
      return 0;
    }else if(x==1){
      return y;
    }else{
      boolean isEven= (x%2==0);
      if(isEven){
        return multiply(x>>1, y)+multiply(x>>1, y);
      }else{
        return multiply(x>>1, y)+multiply(x>>1, y)+y;
      }
    }
  }

  public static void main(String[] args) {
    int x=19, y=10;
    System.out.println(multiply(x,y));

  }

}
