package again;

import java.util.Arrays;

public class java跳跃游戏2 {
    public static void main(String[] args) {
        Solution跳跃游戏2 solution = new Solution跳跃游戏2();
        int[] nums= {2,3,0,1,4};
        int jump = solution.jump(nums);
        System.out.println(jump);
    }
}

class Solution跳跃游戏2 {
    public int jump(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        Arrays.fill(dp,Integer.MAX_VALUE-10);
        dp[N-1] = 0;
        for(int i=N-2;i>=0;i--){
            //一步到最后
            if((i+nums[i])>=N-1){
                dp[i] = 1;
            }else{
                //i这个位置花了1步，走到i+j的位置
                for(int j=0;j<=nums[i];j++){
                    dp[i] = Math.min(dp[i+j],dp[i]);
                }
                dp[i]++;
            }
        }
        return dp[0];
    }
}
