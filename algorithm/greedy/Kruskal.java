package greedy;

import java.util.*;

/**计算最小生成树的Kruskal算法（061Kruskal算法.pdf）
 * @author bin
 *
 */
class Edge implements Comparable<Edge>{
	int weight;
	int A, B;
	public Edge(){}
	public Edge(int w, int x, int y){
		weight = w;
		A = x;
		B = y;
	}
	public String toString(){
		return weight+":"+A+"--"+B; 
	}
	public int compareTo(Edge e){
		if(this.weight != e.weight){
			return this.weight - e.weight;
		}else{
			return this.A-e.A==0?this.B-e.B:this.A-e.A;
		}
	}
}

public class Kruskal {
	
	public static int getMSTWeight(int[][] graph){
		
		Set<Edge> edges = new TreeSet<>();
		for(int i=0;i<graph.length;i++){
			for(int j=i+1;j<graph.length;j++){
				if(graph[i][j]>0){
					edges.add(new Edge(graph[i][j], i, j));
				}
			}
		}
		
		System.out.println(edges);
		
		List<Set<Integer>> route = new ArrayList<>();//! How to form a list of list?
		int weight = 0, n = 0;
		for(Edge e:edges){
			if(insertIfNotCircle(route, e)){
				weight += e.weight;
				n++;
				System.out.println("Added weight " + e.weight + " and edge:"+e);
			}
			if(n==graph.length-1) return weight;
		}
		
		return -1;
	}
	//!!judge whether a bi-direction graph was circled or not!
	private static boolean insertIfNotCircle(List<Set<Integer>> route, Edge e){
		int indexA = -1, indexB = -1;
		for(int i=0;i<route.size();i++){
			Set<Integer> chain = route.get(i);
			if(chain.contains(e.A)) {indexA = i;}
			if(chain.contains(e.B)) {indexB = i;}
			if(indexA == indexB && indexA!=-1){
				return false;
			}
		}
		
		//case 1: none of the points of e exists in route
		if(indexA==-1 && indexB==-1){
			Set<Integer> append = new HashSet<>();
			append.add(e.A); append.add(e.B);
			route.add(append);
		} else if (indexA==-1 ^ indexB==-1) {
			//case 2 either of them is in the chain 
			int max = Math.max(indexA, indexB);
			int min = Math.min(indexA, indexB);
			
			route.get(max).add(min);
		} else if (indexA!=-1 && indexB!=-1){
			//case 3: both exist but not in the same chain
			//remove one and append it the other one
			for(Integer x:route.get(indexB)) {
				route.get(indexA).add(x);
			}
			route.remove(indexB);
			
		} else {
			
		}
		
		return true;
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
		
		System.out.println(Kruskal.getMSTWeight(graph));
	}

}
