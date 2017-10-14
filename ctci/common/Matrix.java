package common;

import java.util.*;
import java.util.Random;

public class Matrix {
  
  //create a m*m matrix with all elements are false
  public static boolean[][] createBooleanMatrix(int m){
    boolean[][] matrix=new boolean[m][m];
    return matrix; 
  }
  
  public static boolean[][] createBooleanMatrix(int m, int n){
    boolean[][] matrix=new boolean[m][n];
    return matrix; 
  }
  
  public static void fill(boolean[][] matrix, boolean b){
    for(boolean[] row:matrix){
      Arrays.fill(row, b);
    }
  }
  
  //create some random points (<n) which have a value of false (not accessible)
  public static void createRandomOffLimits(boolean[][] matrix, int n){
    if(matrix==null||matrix.length==0) return;
    int row=matrix.length, col=matrix[0].length;
    n=n%(row*col);
    Random random=new Random();
    for(int i=0;i<n;i++){
      matrix[random.nextInt(row)][random.nextInt(col)]=false;
    }
  }
  
  // O is true; X if false
  public static String[][] toString(boolean[][] matrix){
    if(matrix==null || matrix.length==0) return null;
    int row=matrix.length, col=matrix[0].length;
    String[][] cells=new String[row][col];
    for(int i=0;i<row;i++){
      for(int j=0;j<col;j++){
        if(matrix[i][j]) cells[i][j]="O";
        else cells[i][j]="X";
      }
    }
    return cells;
  }
  
  public static void setPath(String[][] matrix, List<int[]> dots){
    if(matrix==null || dots==null || dots.size()==0) return;
    for(int[] p:dots){
      matrix[p[0]][p[1]] = "*";
    }
  }
  
  public static void print(String[][] matrix){
    for(String[] line:matrix){
      System.out.println(Arrays.toString(line));
    }
  }
  
  public static void main(String[] args){
    int n=10;
    boolean[][] m=createBooleanMatrix(n);
    fill(m,true);
    createRandomOffLimits(m,30);
    for(String[] s:toString(m)){
      System.out.println(Arrays.toString(s));
    }
    
  }
  
}
