/**
 * 掷骰子10次，出现6的次数最有可能是几次。
 * 解法：设出现次数是k，总共摇n次，那么出现k次6的概率是：(5^(n-k)/6^n) * kCn
 * 例如出现1次的概率是5^(10-1)/6^10 * 1C10
 * 又如出现2次的概率是5^(10-2)/6^10 * 2C10.
 * 用计算机模拟如下，总共尝试10000000轮，每次摇10下，结果如下：
	0: 0.1615319
	1: 0.3229702
	2: 0.2905771
	3: 0.1551825
	4: 0.0543104
	5: 0.013026
	6: 0.0021402
	7: 2.437E-4
	8: 1.75E-5
	9: 5.0E-7
	10: 0.0
 * 结论：出现最多的是1次，下来是2次，然后不出现6和出现3次的基本一样，其他的出现次数开始快速衰减。
 * 应用：以后玩游戏可以用这个技巧
 * 想法：其实如果按照平均分配的话，总共摇10次，那么每个数字应该是平均出现，也就是说出现在2次左右（10/6）
 * 可以快速定位是在1和2附近。
 * @author bin
 *
 */
public class Dice {
	private final static int ROUND = 1000000;
	private final static int TIMES_PER_ROUND = 12;
	public static void main(String[] args) {
		int[] rate = new int[TIMES_PER_ROUND+1];
		for(int i=1;i<=ROUND;i++){
			rate[dice()]++;
		}
		for(int i=0;i<=TIMES_PER_ROUND;i++){
			System.out.println(i+": "+ (double)rate[i]/ROUND); //~0.013024967876255
		}
		
	}
	private static int dice(){
		int[] r = new int[TIMES_PER_ROUND];
		
		int count = 0;
		for(int i=0;i<TIMES_PER_ROUND;i++){
			r[i] = (int) (Math.random() * 6 + 1);
			if(r[i]==6) count++; // target number is 6. should be the same on other values.
		}
//		System.out.println(Arrays.toString(r));
		return count;
	}
}