package greedy;

import java.util.*;

/**
 * 活动选择问题
输入:S = {1, 2, ... , n}为n 项活动的 集合， si , fi 分别为活动 i 的开始和 结束时间.
活动i与j相容⇔ si ≥fj 或sj ≥fi . 求:最大的两两相容的活动集 A
示例：{1,4},{3,5},{2,6},{5,7},{4,9},{5,9},{6,10},{8,11},{2,13},{8,12}
结果：[1,4], [5,7], [8,11]
 * @author bin
 * 
 */
public class Activity implements Comparable<Activity> {
	private float startTime, endTime;
	public Activity(){};
	public Activity(float start, float end) {this.startTime=start;this.endTime=end;}
	
	//To sort the activities by end endTime
	public int compareTo(Activity activity){
		if(this.endTime>activity.endTime) return 1;
		else if(this.endTime<activity.endTime) return -1;
		else return 0;
	}
	public static ArrayList<Activity> getMaxContNum(Activity[] activities){
		ArrayList<Activity> maxContActivities = new ArrayList<>();
		Arrays.sort(activities);
//		System.out.println(Arrays.toString(activities));
		
		float lastEnd = 0f;
		for(Activity a:activities){
			if(a.startTime>=lastEnd){
				maxContActivities.add(a);
				lastEnd = a.endTime;
			}
		}
		return maxContActivities;
	}
	public String toString(){
		return "["+this.startTime+","+this.endTime+"]";
	}
	public static void main(String[] args){
		int[][] times = new int[][]{{1,4},{3,5},{2,6},{5,7},{4,9},{5,9},{6,10},{8,11},{2,13},{8,12}};
		Activity[] activities = new Activity[times.length];
		for(int i=0;i<times.length;i++){
			activities[i] = new Activity(times[i][0], times[i][1]);
		}
		System.out.println(Activity.getMaxContNum(activities));
	}

}
