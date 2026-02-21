package com.ning.week1;


import java.util.Arrays;

/**
 * 2022/3/6 16:26
 */
public class java067二进制求和 {
    public static void main(String[] args) {
        Solution067 solution067 = new Solution067();
        String a = "1010";
        String b = "1011";
        String s = solution067.addBinary(a, b);
        System.out.println(s);
    }
}

class Solution067 {
    public String addBinary(String a, String b) {
        int lengthA = a.length() - 1;
        int lengthB = b.length() - 1;
        StringBuilder builder = new StringBuilder();
        int ca = 0; //0表示没进位，1表示进位
        int sum = 0; //每一位的算数结果
        for (; lengthA >= 0 || lengthB >= 0; lengthA--, lengthB--) {
            int i = lengthA >= 0 ? a.charAt(lengthA) - '0' : 0;
            int j = lengthB >= 0 ? b.charAt(lengthB) - '0' : 0;
            sum = (ca + i + j) % 2;
            ca = (ca + i + j) / 2;
            builder.append(sum);
        }
        //最大的那位是否进1
        builder.append(ca%2==1?"1":"");
        return builder.reverse().toString();
    }
}



