package com.ning.DP;

public class java055跳跃游戏 {
    public static void main(String[] args) {
        Solution055 solution055 = new Solution055();
        int[] nums = {1,0,1,0};
        boolean b = solution055.canJump(nums);
        System.out.println(b);
    }
}

class Solution055 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            //存在元素为0,需要进行跳跃判断
            //如果不为0，那肯定能跳过去
            if (nums[i] == 0) {
                flag = false;
                //元素为0前面的元素，能不能跳过0
                // 或者i是最后一个，前面的元素就只需要到达0
                for (int j = i - 1; j >= 0; j--) {
                    if(nums[j]>i-j || (i==nums.length-1 && nums[j]==i-j)){
                        flag = true;
                        break;
                    }else{
                        flag = false;
                    }
                }
                //中间就断开了,直接返回
                if(!flag){
                    return flag;
                }
            }
        }
        return flag;
    }
}