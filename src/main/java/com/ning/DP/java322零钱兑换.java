package com.ning.DP;

import java.util.Arrays;

public class java322零钱兑换 {
    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int i = solution322.coinChange(coins, amount);
        System.out.println(i);
    }
}

class Solution322 {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || coins == null || amount < 0) {
            return -1;
        }
        return process2(coins, 0, amount);
    }

    public int process2(int[] coins, int index, int aim) {
        int[][] dp = new int[coins.length + 1][aim + 1];
        dp[coins.length][0] = 0;  //说明凑齐了
        for (int i = 1; i <= aim; i++) {
            dp[coins.length][i] = -1;  //这些都是失效的
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[i][rest] = -1;
                //下面是存在的
                if (dp[i + 1][rest] != -1) {
                    dp[i][rest] = dp[i + 1][rest];
                }
                //左边是存在的
                if (rest - coins[i] >= 0 && dp[i][rest - coins[i]] != -1) {
                    if (dp[i][rest] == -1) {
                        dp[i][rest] = dp[i][rest - coins[i]] + 1;
                    } else {
                        dp[i][rest] = Math.min(dp[i][rest - coins[i]] + 1, dp[i][rest]);
                    }
                }
            }
        }
        return dp[index][aim];
    }


    /**
     * 这是一个不断迭代的过程
     *
     * @param coins
     * @param index  coins里面第i个数
     * @param amount 需要多少钱
     * @return 返回的是几张钱币（钱币数）
     */
    public int process(int[] coins, int index, int amount) {
        if (index == coins.length) {
            return amount == 0 ? 0 : -1;
        }
        int result = -1;//目前的钱币数量，默认为-1(无法凑齐)

        //i表示index张钱币用了i张了
        for (int i = 0; amount - i * coins[index] >= 0; i++) {
            //amount = amount - i * coins[index]; //不能这么写，这个amount在这个循环里面不能变
            //nextResult表示为index+1的钱币开始算，用了多少张
            int nextResult = process(coins, index + 1, amount - i * coins[index]);
            //说明凑成功了，如果不成功就看i+1的情况（多用一张钞票）
            if (nextResult != -1) {
                result = result == -1 ? (i + nextResult) : Math.min(result, i + nextResult);
            }
        }
        return result;
    }
}


//class Solution {
//    public int coinChange(int[] coins, int amount) {
//        if (amount == 0){
//            return 0;
//        }
//        int[] dp = new int[amount+1]; // 最多有amount个状态
//        // 最多也就是每次分1块，最多amount个，所以amount+1比谁都大
//        Arrays.fill(dp, amount + 1);
//        //0块钱需要0个硬币
//        dp[0] = 0;
//
//        for (int coin : coins){
//            for (int i = coin; i <= amount; i++){
//                dp[i] = Math.min(dp[i], dp[i-coin]+1);
//            }
//        }
//        return dp[amount] == amount + 1? -1 : dp[amount];
//    }
//}
