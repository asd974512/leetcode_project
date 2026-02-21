package shousi;

import java.util.HashMap;

public class java最长不含重复字符的子串 {
    public static void main(String[] args) {
        Solution最长不含重复字符的子串 main = new Solution最长不含重复字符的子串();
        String s = "bbcdvevbc";
        int i = main.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}

class Solution最长不含重复字符的子串 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n<=1){
            return n;
        }
        char[] chars = s.toCharArray();
        int length = 1;
        int maxLength = 1;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put(chars[0],0);
        for(int i=1;i<n;i++){
            //之前的子串里面有这个字符
            if(hashMap.containsKey(chars[i])){
                length = Math.min(i-hashMap.get(chars[i]),length+1);
                hashMap.put(chars[i],i);
            }else{
                //子串里面没有这个字符
                length++;
                hashMap.put(chars[i],i);
            }
            maxLength = Math.max(maxLength,length);
        }
        return maxLength;
    }
}
