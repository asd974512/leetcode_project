package again;

public class java股票1 {
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        int i = new Solution2().maxProfit(nums);
        System.out.println(i);
    }
}

class Solution2 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 1 || prices == null) {
            return 0;
        }
        //表示第i天买入的挣钱最大化
        int[] dp = new int[length + 1];
        dp[length] = 0;
        int max = 0;
        for (int i = length - 1; i >= 1; i++) {
            //明天-今天
            dp[i] = prices[i] - prices[i - 1];
            if (dp[i + 1] > 0) {
                dp[i] += dp[i + 1];
            }
            dp[i] = dp[i]>0?dp[i]:0;
            max = Math.max(dp[i],max);
        }
        return max;
    }
}