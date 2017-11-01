package dynamicprogramming;

/**
 * 图像压缩: 黑白图像存储
像素点灰度值 : 0∼255，为8位二进制数 图像的灰度值序列 : { p1, p2, ... , pn}，pi
为第i个像素点灰度值 图像存储:每个像素的灰度值占8位，
总计空间为 8n

图像变位压缩的概念
变位压缩存储: 将{p1, p2,...,pn}分成 m 段 S1, S2, ... , Sm
同一段的像素占用位数相同
第 t 段有 l[t]个像素，每个占用 b[t]位 段头:记录l[t](8位)和b[t](3位)需要11位
总位数为
b[1]⋅l[1]+b[2]⋅l[2]+... +b[m]⋅l[m]+11m

实例
P={10,12,15,255,1,2,1,1,2,2,1,1}
分法1: S1= {10, 12, 15}，S2={255}, S3={1, 2, 1, 1, 2, 2, 1, 1}
分法2:S1={10,12,15,255,1,2,1,1,2,2,1,1} 分法3: 分成12组，每组一个数
存储空间
分法1:11×3+4×3+ 8×1+2×8 = 69
分法2:11×1+8×12 =107
分法3:11×12+4×3+8×1+1×5+2×3=163

测试：
P = <10, 12, 15, 255, 1, 2>.
S[1]=15, S[2]=19, S[3]=23, S[4]=42, S[5]=50
l[[1]=1, l[2]=2, l[3]=3, l[4]=1, l[5]=2
最优解 57, 分段<10, 12, 15, 255} {1, 2>.
 * @author bin
 * @since 2017/04/18
 */
import java.util.*;
public class GreyPicture {
	private int[] pixels;
	private int minStoreSpace = -1;
	private List<List<Integer>> optimizedSection = new ArrayList<>();
	
	public GreyPicture(){};
	public GreyPicture(int[] pixels){
		this.pixels = pixels;
	};
	
	public List<List<Integer>> getOptimizedSection(){
		if(minStoreSpace == -1) this.compress();
		return this.optimizedSection;
	}
	
	public int getMinStoreSpace(){
		if(minStoreSpace == -1) this.compress();
		return this.minStoreSpace;
	}
	
	private void compress(){
		final int maxPixelsInSection=256, headerLength=11, n=pixels.length+1;
		int[] S=new int[n], l=new int[n], b=new int[n]; // b stores the length of each pixel in pixels[]
		
		for(int i=1;i<n;i++){ // WRONG The index somewhere is not right!
			b[i] = this.getBitLength(pixels[i-1]);
			int bmax = b[i];
			S[i] = S[i-1] + bmax;
			l[i] = 1;
			for(int j=2;j<Math.min(i,maxPixelsInSection);j++){
				bmax = Math.max(bmax, b[i-j+1]);
				if(S[i]>S[i-j] + j*bmax){
					S[i]=S[i-j] + j*bmax;
					l[i]=j;
				}
			}
			S[i] += headerLength;
		}

		System.out.println(Arrays.toString(S));
		System.out.println(Arrays.toString(l));
		this.minStoreSpace = S[n-1];
	}
	
	private int getBitLength(int n){
		Double d = Math.log(n+1)/Math.log(2);
		return d.intValue()+1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] P={10,12,15,255,1,2};
		GreyPicture pic = new GreyPicture(P);
		int space = pic.getMinStoreSpace();
		System.out.println(space);
	}

}
