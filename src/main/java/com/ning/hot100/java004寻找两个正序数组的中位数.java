package com.ning.hot100;

public class java004寻找两个正序数组的中位数 {
    public static void main(String[] args) {

    }
}

class Solution004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N = nums1.length;
        int M = nums2.length;
        int sum = N + M;
        int indexA = 0;
        int indexB = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i <= sum / 2; i++) {
            left = right;
            if (indexA < N && (indexB >= M || (nums1[indexA] < nums2[indexB]))) {
                right = nums1[indexA++];
            }else{
                right = nums2[indexB++];
            }
        }
        if(sum%2==0){
            return (left+right)/2.0;
        }else{
            return right;
        }
    }
}


//class Solution {
//    public double findMedianSortedArrays(int[] A, int[] B) {
//        int m = A.length;
//        int n = B.length;
//        int len = m + n;
//        //left是上一次循环的值，用于偶数
//        int left = -1, right = -1;
//        //这个是index
//        int aStart = 0, bStart = 0;
//        //因为是中位数，所以只要循环一半的时间
//        for (int i = 0; i <= len / 2; i++) {
//            left = right;
//            //首先是aStart要小于A的长度，同时要么B已经结束了，要么A比B小
//            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
//                right = A[aStart++];
//            } else {
//                right = B[bStart++];
//            }
//        }
//        if ((len & 1) == 0)
//            return (left + right) / 2.0;
//        else
//            return right;
//    }
//}