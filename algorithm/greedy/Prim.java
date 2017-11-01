package greedy;

import java.util.*;

/** Prim算法 - 060Prim算法.pdf
 * 输入:图 G=(V,E,W), V={1,2,...,n} 输出:最小生成树 T
 * 设计思想: 初始 S = {1}，
 * 选择连接 S 与 V−S 集合的最短边 e = { i, j }，其中i∈S, j∈V−S. 将e加入树 T，j 加入 S.
 * 继续执行上述过程，直到 S=V 为止.
 * @author bin
 *
 */
public class Prim {
	
	//get the weight of the minimum spanning tree of this graph
	private static int getMSTWeight(int[][] graph){ 
		int weight = 0;
		
		Set<Integer> S = new HashSet<>(), V = new HashSet<>();
		
		S.add(0);// Put the first vertex in the starting set S
		for(int i=1;i<graph.length;i++){
			V.add(i);
		}// V contains all the left vertexes now
		
		/*Get the shortest distance from V to S and return the vertex number,
		add this vertex to S and remove it from V. Then add this distance to weight*/
		while(S.size()<graph.length){
			int distance = Integer.MAX_VALUE;
			int vertex = -1;
			for(int s:S){
				for(int v:V){
					if(graph[s][v]>0 && graph[s][v]<distance){
						distance = graph[s][v];
						vertex = v;
					}
				}
			}
			if(vertex > -1 ){
				S.add(vertex);
				V.remove(vertex);
				weight += distance;
				System.out.println((vertex+1) +","+ distance);
			} else {
				System.out.println("The graph is not full connected!");
				break;
			}
		}
		
		return weight;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph = new int[][]{
			{0,6,1,5,0,0},
			{6,0,5,0,3,0},
			{1,5,0,5,6,4},
			{5,0,5,0,0,2},
			{0,3,6,0,0,6},
			{0,0,4,2,6,0}
		};
		
		System.out.println(Prim.getMSTWeight(graph));
	}

}
