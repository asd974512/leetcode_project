package com.ning.hot100;

public class java647回文子串 {
    public static void main(String[] args) {

    }
}

class Solution647 {
    public int countSubstrings(String s) {
        int num = 0;
        if(s.length()==0){
            return 0;
        }
        for(int i=0;i<s.length();i++){
            int left = i;
            int right = i;
            while(right<s.length() && s.charAt(left)==s.charAt(right)){
                num++;
                right++;
            }
            left--;
            while(left>=0 &&right<s.length() &&s.charAt(left)==s.charAt(right)){
                num++;
                left--;
                right++;
            }
        }
        return num;
    }
}