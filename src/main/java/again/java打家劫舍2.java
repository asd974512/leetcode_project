package again;

public class java打家劫舍2 {

}
class Solutionjava打家劫舍2 {
    public int rob(int[] nums) {
        int length = nums.length;
        if(length==0){
            return 0;
        }else if(length==1){
            return nums[0];
        }else if(length==2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(process(nums,0,length-2),process(nums,1,length-1));
    }
    public int process(int[] nums,int begin,int end){
        int N = end-begin+1;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = nums[begin];
        for(int i=2;i<=N;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i+begin-1]);
        }
        return dp[N];
    }
}
