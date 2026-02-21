package com.ning.week2;

import java.util.Arrays;

public class java055字符串相乘 {
    public static void main(String[] args) {
        Solution055 solution055 = new Solution055();
        String multiply = solution055.multiply("1234", "10");
        System.out.println(multiply);
    }
}

class Solution055 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        StringBuffer result = new StringBuffer();
        //num2的每一位[j]和num1相乘，temp就是相乘的结果
        for (int j = num2.length() - 1; j >= 0; j--) {
            int n2 = num2.charAt(j) - '0';
            //判断进位
            int sign = 0;
            StringBuffer temp = new StringBuffer();
            //填零，这个zero要>0,因为第一个不会填零，以此类推
            for (int zero = (num2.length() - 1) - j; zero > 0; zero--) {
                temp.append(0);
            }
            //num2的每一位[j]和num1的每一位[i]相乘
            for (int i = num1.length() - 1; i >= 0; i--) {
                int n1 = num1.charAt(i) - '0';
                int ans = n1 * n2 + sign;
                sign = ans / 10;
                temp.append(ans % 10);
            }
            if (sign != 0) {
                temp.append(sign);
            }
            //此时temp就是num2的第j位和num1相乘的结果的倒序
            temp = temp.reverse();
            result = result.reverse();
            //两数相加，要求字符串是正序，所以上面要再倒序一次
            result = add(result, temp);
        }
        return result.reverse().toString();
    }
    public StringBuffer add(StringBuffer result, StringBuffer temp) {
        String sResult = result.toString();
        String sTemp = temp.toString();
        StringBuffer sb = new StringBuffer();
        int i = sResult.length() - 1;
        int j = sTemp.length() - 1;
        int sign = 0;
        while (i >= 0 || j >= 0) {
            int n = i >= 0 ? sResult.charAt(i) - '0' : 0;
            int m = j >= 0 ? sTemp.charAt(j) - '0' : 0;
            int ans = n + m + sign;
            sign = ans / 10;
            sb.append(ans % 10);
            i--;
            j--;
        }
        if (sign > 0) {
            sb.append(1);
        }
        return sb;
    }

}