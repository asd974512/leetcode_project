package shousi;

import java.util.Arrays;

public class java最长公共子串 {
    public static void main(String[] args) {
    }
}

class Solution最长公共子串 {
    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            minLength = Math.min(minLength,strs[i].length());
        }
        if(minLength==0){
            return "";
        }
        Arrays.sort(strs);
        int length = 0;
        while(length<minLength){
            if(strs[0].charAt(length)==strs[strs.length-1].charAt(length)){
                length++;
            }else{
                break;
            }
        }
        return strs[0].substring(0,length);
    }
}