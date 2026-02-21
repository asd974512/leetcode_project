package shousi;

import java.sql.PreparedStatement;

public class java变态跳台阶 {
    public static void main(String[] args) {
        int process = process(5);
        System.out.println(process+"   "+(1<<4));
    }

    public static int process(int n) {
        if (n == 0) {
            return 0;
        }
        if(n==1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]+=dp[i-j];
            }
        }
        return dp[n];
    }

    public static int process2(int[] cost){
        int n = cost.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return cost[0];
        }
        if(n==2){
            return Math.min(cost[0],cost[1]);
        }
        //跳到第n的台阶需要的花费(第n个台阶不需要跳)，那么顶楼就是n+1
        int[] dp = new int[n+1];
        //可以从0或者1开始跳，所以不需要花费
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = Math.min(cost[0],cost[1]);
        for(int i=3;i<=n;i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }
}

