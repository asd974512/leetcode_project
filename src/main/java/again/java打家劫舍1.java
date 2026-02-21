package again;

public class java打家劫舍1 {
    public static void main(String[] args) {

    }
}
class Solution打家劫舍1 {
    public int rob(int[] nums) {
        int N = nums.length;
        if(N==0){
            return 0;
        }else if(N==1){
            return nums[0];
        }else if (N==2){
            return Math.max(nums[0],nums[1]);
        }
        //到达第i间房间，能拿最多多少钱
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2;i<=N;i++){
            dp[i] = Math.max(dp[i-1]+0,dp[i-2]+nums[i-1]);
        }
        return dp[N];
    }
}
