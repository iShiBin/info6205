package recursion;
import common.*;
import java.util.*;
/* 8.2 Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right  and down, but certain cells are "off limits" such that
 * the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to the bottom right.
 */
public class Solution8_2 {
  //O(2^(r+c))
  public static List<int[]> getPath(boolean[][] maze){
    if(maze==null || maze.length==0) return null;
    List<int[]> path=new LinkedList<>();
    if(getPath(maze, maze.length-1, maze[0].length-1, path)) return path;
    return null;
  }
  
  private static boolean getPath(boolean[][] maze, int row, int col, List<int[]> path){
    //if out of bounds or not available, return
    if(col<0||row<0||!maze[row][col]) return false;
    boolean reachOrigin = (row==0) && (col==0);
    //if there is a path from the start to here, add my location.
    if(reachOrigin || getPath(maze,row,col-1,path)||getPath(maze,row-1,col,path)){
      int[] point={row, col};
      path.add(point);
      return true;
    }
    return false;
  }
  
  public static List<int[]> getPathI(boolean[][] maze){
    if(maze==null || maze.length==0) return null;
    List<int[]> path=new LinkedList<>();
    Set<int[]> set=new HashSet<>(); 
    if(getPathI(maze, maze.length-1, maze[0].length-1, path, set)) return path;
    return null;
  }
  
  private static boolean getPathI(boolean[][] maze, int row, int col, List<int[]> path, Set<int[]> failedPoints){
    //if out of bounds or not available, return
    if(col<0||row<0||!maze[row][col]) return false;
    
    int[] point={row, col};
    //if this cell cannot reach, return false *
    if(failedPoints.contains(point)) return false;
    
    boolean reachOrigin = (row==0) && (col==0);
    //if there is a path from the start to here, add my location.
    if(reachOrigin || getPathI(maze,row,col-1,path,failedPoints)||getPathI(maze,row-1,col,path,failedPoints)){
      path.add(point);
      return true;
    }
    
    //cache result *
    failedPoints.add(point);    
    return false;
  }
  
  public static void main(String[] args) {
    int n=3;
    boolean[][] matrix=Matrix.createBooleanMatrix(n);
    Matrix.fill(matrix, true);
//    Matrix.createRandomOffLimits(matrix, n);
//    set the most up-left and down-right to true
//    matrix[0][0]=true;matrix[n-1][n-1]=true;
    matrix[1][0]=false; matrix[1][n-1]=false;
    
    List<int[]> list=getPathI(matrix);
    String[][] sMatrix = Matrix.toString(matrix);
    Matrix.setPath(sMatrix, list);
    Matrix.print(sMatrix);
  }

}
