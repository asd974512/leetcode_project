package com.ning.week2;

public class java415字符串相加 {
    public static void main(String[] args) {

    }
}

class Solution415 {
    public String addStrings(String num1, String num2) {
        int lenght1 = num1.length();
        int length2 = num2.length();
        int maxLength = Math.max(lenght1,length2);
        StringBuffer sb =new StringBuffer();
        int sign = 0;//表示进位
        for(int i=0;i<maxLength;i++){
            int n1 = i<lenght1?num1.charAt(lenght1-1-i)-'0':0;
            int n2 = i<length2?num2.charAt(length2-1-i)-'0':0;
            int result = n1+n2+sign;
            sign = result/10;
            result %=10;
            sb.append(result);
        }
        if(sign!=0){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}