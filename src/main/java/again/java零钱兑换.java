package again;

import java.util.Arrays;

public class java零钱兑换 {
    public static void main(String[] args) {

    }
}

class Solution零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int length = coins.length;
        if(amount==0){
            return 0;
        }
        if(length==0){
            return -1;
        }

        //dp[i]表示凑齐i的数需要最少多少的硬币
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,Integer.MAX_VALUE-10);
        dp[0] = 0;
        //外循环是钱的数目
        for(int i=1;i<=amount;i++){
            //内循环是硬币的种类
            for(int j=0;j<length;j++){
                if(i>=coins[j]){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]);
                }
            }
            dp[i]++;
        }
        if(dp[amount]>amount){
            return -1;
        }else{
            return dp[amount];
        }
    }
}