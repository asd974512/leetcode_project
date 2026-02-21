package com.ning.hot100;

public class java005最长回文子串 {
    public static void main(String[] args) {
        Solution005 solution005 = new Solution005();
        String str = "aba";
        String s = solution005.longestPalindrome(str);
        System.out.println(s);

    }
}

class Solution005 {
    public String longestPalindrome(String s) {
        if(s.length()==0 || s==null){
            return "";
        }
        int left =0;
        int right =0;
        int maxLength =0;
        int maxStart = 0;
        char[] str = s.toCharArray();
        for(int i=0;i<str.length;i++){
            left = i-1;
            right = i+1;
            int length = 1;
            while(left>=0 && str[left]==str[i]){
                left--;
                length++;
            }
            while(right<s.length() && str[right]==str[i]){
                right++;
                length++;
            }
            while(left>=0 &&right<s.length() &&str[left]==str[right]){
                left--;
                right++;
                length+=2;
            }
            if(length>maxLength){
                maxStart = left;
                maxLength = length;
            }
        }
        return s.substring(maxStart+1,maxStart+maxLength+1);
    }
}
