package com.ning;

import java.util.Arrays;

public class quicksortTest {
    public static void main(String[] args) {
        quicksortTest test = new quicksortTest();
        int[] nums = {1,5,4,7,5,2,1,2,3,9,5,6,8,7,9,5,3};
//        test.partition(nums,0,nums.length-1);
        test.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    //先预判断
    public void quickSort(int[] nums){
        if(nums==null || nums.length<=1){
            return;
        }
        quickSort(nums,0,nums.length-1);
    }
    //快排是一个递归，判断条件是L<R就执行
    //每次快排，都是让一个数确定它的位置,所以还要写一个荷兰国旗的函数
    public void quickSort(int[] nums, int L,int R){
        if(L<R){
            //用来确定，每次选择一个数，让它到正确的位置上去
            int[] part = partition(nums, L, R);
            quickSort(nums,L,part[0]-1);
            quickSort(nums,part[1]+1,R);

        }
    }

    public int[] partition(int[] nums,int L,int R){
        int left = L-1;
        int right = R+1;
        int index = L;
        //随机选个数，数的范围是[L,R]
        int target = nums[L+(int)(Math.random()*(R-L+1))];
        while(index<right){
            if(nums[index]<target){
                swap(nums,index++,++left);
            }else if (nums[index]==target){
                index++;
            }else if(nums[index]>target){
                swap(nums,index,--right);
            }
        }
        return new int[]{left+1,right-1};
    }

    public void swap(int[] nums,int L,int R){
        int temp = nums[L];
        nums[L] = nums[R];
        nums[R] = temp;
    }
}
