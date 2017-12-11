package finalterm;

/**
 * In a 2D matrix, if one of its number is changed to a new value,
 * any surrounding number (all directions, 8 numbers in total) will also change to this new value if they has the save value old value.
 * This process will happen recursively in this matrix.
 * 
 * Note: The new value after change may be an existing value in this matrix. In this case, this existing number won't flood.
 * 
 * Example:
 * [1, 2, 1, 0]
 * [0, 0, 0, 1]
 * [1, 0, 1, 0]
 * [0, 1, 1, 0]
 * 
 * If we want to change matrix[2,2] from 1 to a new value 2. This matrix will become the following in the end.
 * [1, 2, 2, 0]
 * [0, 0, 0, 2]
 * [2, 0, 2, 0]
 * [0, 2, 2, 0]
 * 
 * Explanation:
 * The first number to change it matrix[2,2], and the new value is 2. The the matrix becomes:
 * [1, 2, 1, 0]
 * [0, 0, 0, 1]
 * [1, 0, 2, 0]
 * [0, 1, 1, 0]
 * 
 * Then its first layer neighbors will also be updated if they have the some value.
 * [1, 2, 1, 0]
 * [0, 0, 0, 2]
 * [1, 0, 2, 0]
 * [0, 2, 2, 0]
 * 
 * Further more, matrix[0][2] will also be updated to 2 because it has a value of 1, 
 * and it is in the neighborhood of the changed matrix[1][3].
 * 
 * For the same reason, matrix[2][0] will also be updated to 2. Here is the matrix in the end.
 * [1, 2, 2, 0]
 * [0, 0, 0, 2]
 * [2, 0, 2, 0]
 * [0, 2, 2, 0]
 * 
 * However, the upper left value matrix[0][0] will not change because its surroundings do not have a value 1 (the very first original value)
 * even through it is '1' and it is next to 2 (this 2 is the original value rather than after flooding). Thus, this flood start from matrix[2,2] won't reach.
 * 
 */

/*
 * Algorithm: Use breadth first search with the help of queue
 * Because the number after change could be an existing number in the matrix, so I cannot do this in place. 
 * Instead, I need to use a queue to store all the positions which should be change at last.
 * 
 * In the meanwhile, I use keep the visiting status to avoid over calculation.
 * 
 * Here is the flow of this algorithm.
 * 1. Put the very first number's indexes ([row, column]) to a temporary queue.
 * 2. Start the breadth first search but polling one element, the head element normally, 
 *    and save it to the queue (indexQueue) of all the indexes whose value to be changed).
 * 3. Check all the 8 surrounding numbers, if a surrounding number has the same value, then add this number's index to the temp queue. 
 * 4. Set the visited flag to true any way no matter it has the same value of not because we have processed this node.
 * 5. When there is no element in the temp queue, we stop searching.
 * 6. At last, for each indexes in the indexQueue, we need to change the corresponding value in the matrix to the new value.
 * 
 * Complexity:
 * Time Complexity: O(n). Every node will be examined only once with the help of state flag.
 * Space Complexity: O(n). The temp queue will only take 9 elements at the most so it is O(1). However, each of the indexQueue and state take a O(n) space.
 */

import java.util.*;

class FloodFill {
    private Queue<int[]> indexQueue = new ArrayDeque<>();
    boolean[][] state;
    
    public void flip(int x, int y, int change, int[][] matrix) {
        if(matrix==null || matrix.length==0) return ;
        //assume x, y and valid index
        state = new boolean[matrix.length][matrix[0].length];
        state[x][y] = true;
        int target = matrix[x][y];
        Queue<int[]> temp = new ArrayDeque<>();
        temp.add(new int[]{x,y});
        
        while(temp.peek()!=null){
            int[] index = temp.poll();
            flip(index[0],index[1], matrix, target, temp);
            indexQueue.offer(index);
        }
        
        for(int[] pos:indexQueue){
            matrix[pos[0]][pos[1]] = change;
        }
    }
    
    private void flip(int i, int j, int[][] matrix, int target, Queue<int[]> temp) {
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length) return ;
        
        for (int m = i - 1; m >= 0 && m <= Math.min(i + 1, matrix.length-1); m++) {
            for (int n = j - 1; n >= 0 && n <= Math.min(j + 1, matrix[i].length - 1) && state[m][n]==false; n++) {
                if (matrix[m][n] == target) {
                    int[] pos = { m, n };
                    temp.offer(pos);
//                    System.out.println(Arrays.toString(pos));
                } 
                state[m][n] = true;
            }
        }
    }
    

    public static void main(String[] args) {
        FloodFill test = new FloodFill();
        int[][] matrix = {
                {1,2,1,0},
                {0,0,0,1},
                {1,0,1,0},
                {0,1,1,0}
        };
        
        test.flip(2,2,2,matrix);
        
        for(int[] m:matrix){
            System.out.println(Arrays.toString(m));
        }
        /*
         *  [1, 2, 2, 0]
            [0, 0, 0, 2]
            [2, 0, 2, 0]
            [0, 2, 2, 0]
         */
    }

}