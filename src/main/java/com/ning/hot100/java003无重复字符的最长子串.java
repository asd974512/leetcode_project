package com.ning.hot100;

import java.util.HashMap;
import java.util.HashSet;

public class java003无重复字符的最长子串 {
    public static void main(String[] args) {
        Solution003 solution003 = new Solution003();
        String s = "tmmzuxt";
        int i = solution003.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}

class Solution003 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s==""){
            return 0;
        }
        char[] chars = s.toCharArray();
        int length = s.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left =0;
        //right就是i，滑动窗口右指针
        int right =0;
        int maxLength =0;
        for(int i=0;i<s.length();i++){
            if(hashMap.containsKey(s.charAt(i))){
                //left移动到之前重复字符的后一个位置
                left = Math.max(left,hashMap.get(s.charAt(i))+1);
                hashMap.put(s.charAt(i),i);
                maxLength = Math.max(maxLength,i-left+1);
            }else{
                hashMap.put(s.charAt(i),i);
                maxLength = Math.max(maxLength,i-left+1);
            }
        }
        return maxLength;
    }
}
