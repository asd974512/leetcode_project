package com.ning.hot100;

public class java136只出现过一次的数字 {
    public static void main(String[] args) {

    }
}

class Solution136 {
    public int singleNumber(int[] nums) {
        int element = 0;
        for(int number:nums){
            element = element ^ number;
        }
        return element;
    }
}
