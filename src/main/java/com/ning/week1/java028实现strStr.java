package com.ning.week1;

public class java028实现strStr {
    public static void main(String[] args) {
        Solution028 solution028 = new Solution028();
        String str1 = "heelojacklooerhellossc";
        String str2 = "loo";

        String str11 = "";
        String str21 = "";

        int i = solution028.strStr(str11, str21);
        System.out.println(i);
    }
}

class Solution028 {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

//