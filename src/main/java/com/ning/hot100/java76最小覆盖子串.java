package com.ning.hot100;

import java.util.HashMap;

public class java76最小覆盖子串 {
    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        String s = solution76.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}

class Solution76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hashMapS = new HashMap<>();
        HashMap<Character, Integer> hashMapT = new HashMap<>();
        for(int i=0;i<t.length();i++){
            hashMapT.put(t.charAt(i),hashMapT.getOrDefault(t.charAt(i),0)+1);
        }
        String ans = "";
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        for(int left = 0,right=0;right<s.length();right++){
            hashMapS.put(s.charAt(right),hashMapS.getOrDefault(s.charAt(right),0)+1);
            if(hashMapT.containsKey(s.charAt(right))){
                if(hashMapS.get(s.charAt(right))<=hashMapT.get(s.charAt(right))){
                    count++;
                }
            }
            while(left<right && (!hashMapT.containsKey(s.charAt(left)) || hashMapS.get(s.charAt(left))>hashMapT.get(s.charAt(left)))){
                hashMapS.put(s.charAt(left),hashMapS.get(s.charAt(left))-1);
                left++;
            }

            if(count==t.length() && right-left+1<minLength){
                minLength = right-left+1;
                ans = s.substring(left,right+1);
            }
        }
        return ans;
    }
}
