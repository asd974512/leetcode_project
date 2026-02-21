package com.ning.DP;

import sun.security.rsa.RSAKeyFactory;

public class java091解码方法 {
    public static void main(String[] args) {
        Solution091 solution091 = new Solution091();
        String str = "226";
        int i = solution091.numDecodings(str);
        System.out.println(i);
    }
}

class Solution091 {
    public int numDecodings(String s) {
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        for (int i = 1; i <= length; i++) {
            //当前字符是1~9
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            if (s.charAt(i - 2) != '0' &&
                    ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0')) <= 26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[length];
    }
}
