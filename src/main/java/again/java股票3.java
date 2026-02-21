package again;

public class java股票3 {
    public static void main(String[] args) {
        int[] nums = {3,3,5,0,0,3,1,4};
        int i = maxProfit(nums);
        System.out.println(i);
    }

    public static int maxProfit(int[] prices) {
        int N = prices.length;
        if (N <= 1 || prices == null) {
            return 0;
        }
        //dp[i][0][0] 表示第i+1天， 第几次买卖中,1是买，2是卖
        //注意是k次交易是k+1个维度，买卖是3个维度
        int[][][] dp = new int[N][3][3];
        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][1][2] = 0;//第1天买了又卖了
        dp[0][2][1] = -prices[0];
        dp[0][2][2] = 0;
        for (int i = 1; i < N; i++) {
            dp[i][0][0] = 0;
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
            //之前就卖了，     或者     昨天还没卖，今天卖了，所以加钱
            dp[i][1][2] = Math.max(dp[i - 1][1][2], dp[i - 1][1][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][2] - prices[i]);
            dp[i][2][2] = Math.max(dp[i - 1][2][2], dp[i - 1][2][1] + prices[i]);
        }
        return dp[N - 1][2][2];
    }

//    public int maxProfit(int[] prices) {
//        int N = prices.length;
//        if (N <= 1 || prices == null) {
//            return 0;
//        }
//
//        //dp[i][0][0] 表示第i+1天， 卖了几次,是否有股票
//        int[][][] dp = new int[N][3][2];
//        dp[0][0][0] = 0;
//        dp[0][0][1] = -prices[0];
//        dp[0][1][0] = 0;//第1天买了又卖了
//        dp[0][1][1] = -prices[0];
//        dp[0][2][0] = 0; //不存在021的情况，因为只准买卖两次,卖两次后就只有无股票情况【0没有股票，1有股票】
//        for (int i = 1; i < N; i++) {
//            dp[i][0][0] = 0;
//            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i - 1]);
//            //之前就卖了，     或者     昨天还没卖，今天卖了，所以加钱
//            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i - 1]);
//            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i - 1]);
//            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i - 1]);
//        }
//        return dp[N - 1][2][0];
//    }
}
