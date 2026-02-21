package com.ning.hot100;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class java394字符串解码 {
    public static void main(String[] args) {
        Solution394 solution394 = new Solution394();
        String s = solution394.decodeString("3[a]2[bc]");
        System.out.println(s);
    }
}

class Solution394 {
    public String decodeString(String s) {
        //既是临时变量，也是最后的结果
        StringBuffer ans = new StringBuffer();
        ArrayDeque<Integer> number = new ArrayDeque<>();
        ArrayDeque<StringBuffer> singleStr = new ArrayDeque<>();

        int mutil = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '[') {
                number.push(mutil);
                singleStr.push(ans);
                ans = new StringBuffer();
                mutil = 0;
            } else if (c[i] == ']') {
                StringBuffer sb = singleStr.pop();
                int time = number.pop();
                for(int j=0;j<time;j++){
                    sb.append(ans);
                }
                ans = sb;
            } else if (Character.isDigit(c[i])) {
                mutil = mutil * 10 + Integer.parseInt(c[i] + "");
            } else {
                //此时是临时变量
                ans.append(c[i]);
            }
        }
        return ans.toString();
    }
}