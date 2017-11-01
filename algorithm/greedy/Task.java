package greedy;

import java.util.Arrays;

/**
 * 最小延迟调度 问题: 客户集合A，∀i∈A，ti 为服务时间，di 为 要求完成时间，ti, di为正整数. 一个调度 f : A→N，f(i)为客户 i
 * 的开始时间. 求 最大延迟达到最小的调度，即求 f 使得 min{max{f(i)+ti −di}} ∀i,j∈A,i≠j,f(i)+ti ≤f(j)
 * or f(j)+tj ≤ f(i)
 * 
 * 实例:调度1 A = {1, 2, 3, 4, 5}, T = <5, 8, 4, 10, 3>, D = <10, 12, 15, 11, 20>
 * 调度1:顺序安排 f1(1)=0, f1(2)=5, f1(3)=13, f1(4)=17, f1(5)=27 各任务延迟:0, 1, 2, 16,
 * 10; 最大延迟:16
 * 
 * 更优的调度2（胜出）:按截止时间从前到后安排 f2(1)=0, f2(2)=15, f2(3)=23, f2(4)=5, f2(5)=27 各任务延迟:0,
 * 11, 12, 4, 10; 最大延迟:12
 * 
 * 贪心策略 贪心策略1:按照 ti 从小到大安排 贪心策略2:按照 di − ti 从小到大安排 贪心策略3:按照 di 从小到大安排（胜出）
 * 
 * 
 * @author bin
 *
 */
public class Task {
	private int serveTime, demandTime;
	
	public Task(){}
	public Task(int serveTime, int demandTime){
		this.serveTime=serveTime;
		this.demandTime=demandTime;
	}
	public String toString(){
		return "["+serveTime+","+demandTime+"]";
	}
	
	public static int getMaxDeplayTime(Task[] tasks){
		
		Arrays.sort(tasks, (a,b)->a.demandTime-b.demandTime);
		System.out.println(Arrays.toString(tasks));
		int finishTime=0, delayTime=0, maxDelay=-1;
		
		for(int i=0;i<tasks.length;i++){
			finishTime+=tasks[i].serveTime;
			delayTime=Math.max(finishTime-tasks[i].demandTime,0);
			maxDelay=Math.max(maxDelay, delayTime);
		}
		return maxDelay;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] T=new int[]{5,8,4,10,3};
		int[] D=new int[]{10,12,15,11,20};
		
		Task[] tasks = new Task[T.length];
		for(int i=0;i<T.length;i++){
			tasks[i]=new Task(T[i],D[i]);
		}
		
		int delay = Task.getMaxDeplayTime(tasks);
		System.out.println(delay);
	}

}
