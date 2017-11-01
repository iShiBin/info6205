package dynamicprogramming;
/**
 * 投资问题的建模
问题:m 元钱，n项投资， fi (x): 将 x 元投入第 i 个项目的效益. 求使得总 效益最大的投资方案.
建模:
问题的解是向量 < x1, x2, ..., xn >，
xi 是投给项目i 的钱数，i =1, 2, ... , n. 目标函数 max{f1(x1)+f2(x2)+...+fn(xn)} 约束条件 x1+x2+...+xn=m，xiN

实例:5万元钱，4个项目 效益函数如下表所示
x=0; profit = {0,0,0,0}
x=1; profit = {11,0,2,20}
x=2; profit = {12,5,10,21}
x=3; profit = {13,10,30,22}
x=4; profit = {14,15,32,23}
x=5; profit = {15,20,40,24}
解:x1=1, x2= 0, x3= 3, x4=1，F4(5) = 61
 * @author bin
 * @date 2017/04/12
 */
import java.util.*;

public class Investment {
	private int money, project;
	private int[][] profit;
	
	private int maxProfit=-1;
	private int[] investSolution;
	
	public Investment() {};
	public Investment(int money, int project, int[][] profit){
		this.money = money;
		this.project = project;
		this.profit = profit;
	}
	
	public int getMaxProfit(){
		return maxProfit==-1?make():maxProfit;
	}
	
	public int[] getSolution(){
		if(maxProfit==-1) make();
		return investSolution;
	}
	private int make(){
		int[][] F = new int[money+1][project];
		int[][] X = new int[money+1][project];
		Arrays.fill(F[0], 0);
		Arrays.fill(X[0], 0);
		
		for(int x=1;x<=money;x++) { 
			F[x][0]=profit[x][0] ;
			X[x][0] = x;
			}
		
		for(int k=1;k<project;k++){ //this is the key part!
			for(int x=1;x<=money;x++){
				int p = 0;
				for(int i=0;i<=x;i++){
					p = this.profit[i][k] + F[x-i][k-1]; //***
					if(p>F[x][k]){
						F[x][k] = p;
						X[x][k] = i;
					}
				}
//				System.out.println("**profix matrix**");
//				this.printF(F);
//				
//				System.out.println("**track solution**");
//				this.printF(X);
			}
		}
		
		//track the solution and update investSolution
		this.investSolution = new int[project];
		for(int n=project-1, m = money;n>=0;n--){
			this.investSolution[n] = X[m][n];
			m -= X[m][n];
		}
		
		maxProfit = F[money][project-1];
		return maxProfit;
	}
	
	private void printF(int[][] f){
		for(int[] n:f){
			System.out.println(Arrays.toString(n));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] profitMatrix = {
				{0,0,0,0},
				{11,0,2,20},
				{12,5,10,21},
				{13,10,30,22},
				{14,15,32,23},
				{15,20,40,24}
		};
		
		int money = profitMatrix.length - 1;
		int project = profitMatrix[0].length;
		
		Investment ivst = new Investment(money, project, profitMatrix);
		System.out.println(ivst.getMaxProfit());
		System.out.println(Arrays.toString(ivst.getSolution()));
	}

}
