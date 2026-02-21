package com.ning.hot100;


import java.util.Stack;

public class java32最长有效括号 {
    public static void main(String[] args) {
        String str = "()(()";
        Solution32 solution32 = new Solution32();
        int i = solution32.longestValidParentheses(str);
        System.out.println(i);
    }
}

class Solution32 {
    public int longestValidParentheses(String s) {
        int length = s.length();
        if(length==0){
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        if(s.charAt(0)=='('){
            stack.push(s.charAt(0));
        }
        int maxLength = 0;
        int nowLength = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()){
                    nowLength=0;
                }else{
                    stack.pop();
                    nowLength+=2;
                    maxLength = Math.max(maxLength,nowLength);
                }
            }
        }
        return maxLength;
    }
}