package com.ning.hot100;

import java.util.ArrayList;
import java.util.List;

public class java139单词拆分 {
    public static void main(String[] args) {
        Solution139 solution139 = new Solution139();
        String str = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        boolean b = solution139.wordBreak(str, list);
        System.out.println(b);
    }
}

class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {

        //dp[i]表示第i个字符结尾，能不能由字典拼出来,从1开始
//        boolean[] dp = new boolean[s.length()];
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        int[] wordSize = new int[wordDict.size()];
        for(int i=0;i<wordDict.size();i++){
            wordSize[i] = wordDict.get(i).length();
        }
        //初始化，只要有一个为true，那么这个长度的都是true
        for(int i=0;i<wordSize.length;i++){
            //wordSize不能超过s的长度，超过肯定是false
            if(wordSize[i]<s.length()){
                boolean equals = s.substring(0, wordSize[i]).equals(wordDict.get(i));
                dp[wordSize[i]] = dp[wordSize[i]] || equals;
            }
        }
        for(int i=1;i<s.length();i++){
            //判断字典里面每一个词是否对应
            for(int j=0;j<wordSize.length;j++){
                //i的索引从0开始，而长度从1开始
                if(i>=wordSize[j]){
                    boolean equals = s.substring(i - wordSize[j], i).equals(wordDict.get(j));
                    dp[i] = dp[i] || (dp[i-wordSize[j]] &&  equals);
                }
            }
        }
        return dp[s.length()];
    }
}