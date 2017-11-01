package dynamicprogramming;
import java.util.*;

/**背包问题 (Knapsack Problem)
一个旅行者随身携带一个背包. 可以放 入背包的物品有n 种, 每种物品的重量 和价值分别为 wi , vi . 
如果背包的最大 重量限制是 b, 每种物品可以放多个. 怎样选择放入背包的物品以使得背包的 价值最大? 
不妨设上述wi,vi,b都是 正整数.

实例: n = 4，b =10
v1=1, v2=3, v3=5, v4=9, 
w1= 2, w2= 3, w3= 4, w4= 7,
解 x1=0, x2=1, x3=0, x4=1，价值12
 * @author bin
 * @created 2017/04/12
 */
public class Knapsack {
	private int knapsackWeightLimit;
	private int[] weights;
	private int[] values;
	
	private int maxValue = -1;
	private int[] volume;
	
	public Knapsack(){}
	public Knapsack(int b, int[] w, int[] v){
		this.knapsackWeightLimit = b;
		this.weights = w;
		this.values = v;
	}
	
	private void pack(){
		int k = this.weights.length;
		int y = this.knapsackWeightLimit + 1;
		
		int[][] f = new int[k][y]; // keep best solution
		int[][] t = new int[k][y]; // keep track of the solution
		
		//f[][] was initialized to 0 because how java works but need to set the t[][] to -1 as the goods start counting from #0
		for(int[] n:t){
			Arrays.fill(n, -1);
		}
		
		for(int j=0;j<y;j++){ // initialize the first line by only put the #0 goods
			f[0][j] = (j/weights[0]) * values[0];
			t[0][j] = j<weights[0]?-1:0;
		}
//		System.out.println(Arrays.toString(f[0]));
		System.out.println(Arrays.toString(t[0]));
		
		for(int i=1;i<k;i++){
			for(int j=1;j<y;j++){
				int packi = j-weights[i]>=0?(f[i][j-weights[i]] + values[i]):-1;
				int nopack = f[i-1][j];
				int value = Math.max(packi, nopack);
				if(value>=f[i][j]){ // key!
					f[i][j] = value;
					t[i][j] = value==packi?i:t[i-1][j];//Note: 'i-1' is wrong, should change it to t[i-1][j];
				}
			}
//			System.out.println(Arrays.toString(f[i]));
			System.out.println(Arrays.toString(t[i]));
		}
		this.maxValue = f[k-1][y-1];
		
//		Backtrack the volume of each goods
		this.volume = new int[this.weights.length];
		int lastGoods = t[k-1][this.knapsackWeightLimit];
		int leftWeight = this.knapsackWeightLimit;
		while(leftWeight > 0 && lastGoods>=0){
			this.volume[lastGoods]++;
			leftWeight -= this.weights[lastGoods];
			if(leftWeight>0) lastGoods = t[lastGoods][leftWeight];
		}
	}
	
	public int getMaxValue(){
		if(maxValue==-1) this.pack();
		return this.maxValue;
	}
	
	public int[] getVolume(){
		if(maxValue==-1) this.pack();
		return this.volume;
	}
	
	//check the test case.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4, b=10;
		int[] w={2,3,4,7}, v={1,3,5,9};
		
		Knapsack bag = new Knapsack(b,w,v);
		int value = bag.getMaxValue();
		int[] solution = bag.getVolume();
		System.out.println("The max value this knapsack can hold: "+value);
		System.out.println("The volume of each item is: "+Arrays.toString(solution));

	}
}
