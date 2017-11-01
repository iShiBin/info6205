package backtrack;

//with duplicated or not
public class Permutation {

  // copy
  void permutations(String str, int n) {
    if (str.length() == 0 || n <= 0)
      return;

    int[] result = new int[n];
    permutations(result, 0, n, str);
  }

  private static void permutations(int[] result, int current, int n, String str) {
    if (current == n) {// print;}
      
    }

    for (int i = 0; i < str.length(); i++) {
      if(isValid(result, current, i)){
        result[current] = i;
        permutations(result, current + 1, n, str);
      }
    }
  }
  
  private static boolean isValid(int[] result, int current, int num){
    for(int i=0;i<current;i++){
      if(result[i] == num) return false;
    }
    return true;
  }
}