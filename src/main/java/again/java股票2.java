package again;

import java.util.Scanner;

public class java股票2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split(" ");
        int[] nums = new int[strs.length];
        for(int i=0;i<strs.length;i++){
            nums[i] = Integer.parseInt(strs[i]);
        }
        int i = new Solution股票2().maxProfit(nums);
        System.out.println(i);
    }
}

class Solution股票2 {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        if(N<=1||prices==null){
            return 0;
        }
        //表示dp在第i天的资金情况
        int[][] dp = new int[N + 1][2];
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        for(int i=2;i<=N;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i-1]);
        }
        return dp[N][0];
    }
//    public int maxProfit(int[] prices) {
//        int N = prices.length;
//        if(prices==null || N <=1){
//            return 0;
//        }
//        //dp[i+1][0]表示第i天的资金情况;
//        //0表示没有股票，1表示有股票
//        int[][] dp = new int[N][2];
//        dp[0][0] = 0;
//        //今天买了股票
//        dp[0][1] = - prices[0];
//        for(int i=1;i<N;i++){
//            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
//            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
//        }
//        return dp[N-1][0];
//    }
}
