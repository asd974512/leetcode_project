package again;

public class java股票4 {
    public static void main(String[] args) {
        int i = maxProfit(2, new int[]{2, 4, 1, 3, 8, 7, 4, 1, 3, 0, 6, 8, 4});
        System.out.println(i);
    }

    public static int maxProfit(int k, int[] prices) {
        int N = prices.length;
        if (N <= 1 || k == 0 || prices == null) {
            return 0;
        }
        //第i天，k次交易中，1表示买股票，2表示卖股票
        //注意，i的索引从0开始，k是索引从1开始
        int[][][] dp = new int[N][k + 1][3];
        dp[0][0][0] = 0;
        for (int i = 1; i <= k; i++) {
            //第一天买了股票
            dp[0][i][1] = -prices[0];
            //第一天买了又卖了股票
            dp[0][i][2] = 0;
        }
        for (int i = 1; i < N; i++) {

            dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i - 1][0][0] - prices[i]);
            dp[i][1][2] = Math.max(dp[i-1][1][2], dp[i - 1][1][1] + prices[i]);
            for (int j = 2; j <= k; j++) {
                //第i天的第j次交易时期，买股票的情况
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2] - prices[i]);
                //第i天的第j次交易时期，卖股票的情况
                dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j][1] + prices[i]);
            }
        }
        return dp[N-1][k][2];
    }
}
