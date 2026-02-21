package again;

public class java最大子数组和 {
    public static void main(String[] args) {

    }
}

class Solution最大子数组和 {
    public int maxSubArray(int[] nums) {
        int N = nums.length;
        if (N == 0 || nums == null) {
            return 0;
        }
        if (N == 1) {
            return nums[0];
        }
        int[] dp = new int[N];
        dp[0] = nums[0];
        for (int i = 1; i < N; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
        }
        int max = Integer.MIN_VALUE+10;
        for(int i=0;i<dp.length; i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
