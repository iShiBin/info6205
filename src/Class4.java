import java.util.Arrays;

public class Class4 {
    // todo: divide an array in three part. [less..., equal, greater...]
    // use 3 pointers, left, mid, right. 
    
    // Kadane: Maximum sub-array problem
    // homework1: find the index where it starts and end
//    https://leetcode.com/problems/maximum-subarray/description/
    public static int getMaxSub(int[] nums){
        int max=nums[0], sum=nums[0];
        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(max<sum) max=sum;
            if(sum<0){
                sum=0;
            }
        }
        return max;
    }
    
//    replace with the next greatest
    public static int[] replaceWithNextGreatest(int[] nums){
        int max=nums[nums.length-1];
        nums[nums.length-1]=Integer.MAX_VALUE;
        for(int i=nums.length-2;i>=0;i--){
            nums[i]=max;
            if(nums[i]>max) max=nums[i];
        }
        return nums;
    }
    
    //todo: use bit for same element
    public static boolean isPalindromePermutationBit(String str){
        int flag=0;
//        str=str.toLowerCase(); 'A'=0b1000001 so no need to convert
        for(char c:str.toCharArray()){
            if(c!=' ') flag^=c;
        }
        System.out.println("hi"+flag);
        return flag==0 || ('A'<=flag&&flag<='z');
    }
    
    private static boolean checkAlphaXor(){
        //a-z: 97-122
        for(int i=97;i<=122;i++){
            for(int j=i+1;j<=122;j++){
                int xor=i^j;
                if(97<=xor && xor<=122) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums={1,-2,4,6,0,3,-5,1};
//        System.out.println(getMaxSub(nums));
        System.out.println(Arrays.toString(replaceWithNextGreatest(nums)));
        String str="abc";
        
        System.out.println(isPalindromePermutationBit(str));
        
        for(int i='a';i<='c';i++){
            System.out.println(Integer.toBinaryString(i));
        }

    }

}
