package huisu;

import java.util.ArrayList;

public class java416分割等和子集 {
    public static void main(String[] args) {
        Solution416 solution416 = new Solution416();
        boolean b = solution416.canPartition(new int[]{1,3,2,2,2,4,5,1});
        System.out.println(b);
    }
}

class Solution416 {
    public boolean canPartition(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        //前i个数在sum容量下的最大值
        int[][] dp = new int[length + 1][sum/2 + 1];
        for (int i = 0; i <= length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= sum/2; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= sum/2; i++) {
            if (i >= nums[0]) {
                dp[1][i] = nums[0];
            }
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                }
            }
        }
        //记录路径
        int j =sum/2;
        //从下往上回溯找路径
        for(int i=length;i>0;i--){
            while(j-nums[i-1]>=0){
                if(dp[i][j]>dp[i-1][j]){
                    //因为i的索引是从1开始，所以是num[i-1]
                    j-=nums[i-1];
                    System.out.print(nums[i-1]+" ");
                }else{
                    break;
                }
            }
        }

        return dp[length][sum/2]==sum/2;
    }
}


/**
 * 这个是回溯法，超时了
 */
//    boolean flag = false;
//
//    public boolean canPartition(int[] nums) {
//        int length  = nums.length;
//        if(length<=1){
//            return false;
//        }
//        int sum = 0;
//        for(int i=0;i<nums.length;i++){
//            sum+=nums[i];
//        }
//        if(sum%2!=0){
//            return false;
//        }
//        int result = 0;
//        dfs(nums,sum/2,true,0);
//        dfs(nums,sum/2,false,0);
//        return flag;
//    }
//    public void dfs(int[] nums,int target,boolean isTake,int index){
//        if (isTake){//我要这个数
//            target = target-nums[index];
//        }else{
//            target = target;
//        }
//
//        if(target==0){
//            flag = true;
//            return;
//        }
//        if(index>=nums.length){
//            return;
//        }
//        dfs(nums,target,true,index+1);
//        dfs(nums,target,false,index+1);
//    }