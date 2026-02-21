package again;

import java.util.HashSet;

public class java最低票价 {
    public static void main(String[] args) {
        Solution最低票价 solution = new Solution最低票价();
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        int i = solution.mincostTickets(days, costs);
        System.out.println(i);
    }
}

class Solution最低票价 {
    public int mincostTickets(int[] days, int[] costs) {
        if(days==null){
            return 0;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        int N = days.length;
        for(int i=0;i<N;i++){
            hashSet.add(days[i]);
        }
        //取的是days最后一个元素的值，目的是知道有多少天
        //dp[i]表示第i天出去需要多少钱
        int maxDay = days[N-1];
        int[] dp = new int[maxDay+1];
        //注意这种换钱票价的题目，是i<=不是<,直接用Arrays.fill比较好
        for(int i=1;i<=maxDay;i++){
            dp[i] = Integer.MAX_VALUE-100;
        }
        dp[0] = 0;

        for(int i=1;i<=maxDay;i++){
            //旅行计划有这天，需要花钱
            //可以用set来检查是否存在，也可以先把旅行的日子dp[i]==-1，然后if判断
            if(hashSet.contains(i)){
                    //因为他不仅考虑钱，还考虑票有效的日子(1,7,30)，所以就不用循环了
                    if(i>=30){
                            dp[i] = Math.min(dp[i],dp[i-1]+costs[0]);
                            dp[i] = Math.min(dp[i],dp[i-7]+costs[1]);
                            dp[i] = Math.min(dp[i],dp[i-30]+costs[2]);

                    }else if (i>=7 &&i<30){
                            dp[i] = Math.min(dp[i],dp[i-1]+costs[0]);
                            dp[i] = Math.min(dp[i], dp[i - 7] + costs[1]);
                            dp[i] = Math.min(dp[i],dp[0]+costs[2]);
                    }else if(i>=1 &&i<7){
                            dp[i] = Math.min(dp[i],dp[i-1]+costs[0]);
                            dp[i] = Math.min(dp[i],dp[0]+costs[1]);
                            //本来是不用加的，但是有个傻逼例子，月票是最便宜的,所以一直买月票最划算
                            dp[i] = Math.min(dp[i],dp[0]+costs[2]);
                    }
                } else{//旅行计划没有这天，就不用花钱，和之前的钱是一样的
                dp[i] = dp[i-1];
            }
        }
        return dp[maxDay];
    }
}
