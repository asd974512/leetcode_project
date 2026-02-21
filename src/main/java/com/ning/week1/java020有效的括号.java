package com.ning.week1;

import java.util.*;

/**
 * 2022/3/2
 * 2022/3/2  40分钟
 */

public class java020有效的括号 {
    public static void main(String[] args) {
        Solution020 solution020 = new Solution020();
        String s = "()";
        boolean valid = solution020.isValid(s);
        System.out.println(valid);
    }
}

class Solution020 {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(']','[');
        map.put(')','(');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            char c = chars[i];
            if(map.containsKey(c)){
                if(stack.isEmpty()){
                    return false;
                }else{
                    Character pop = stack.pop();
                    if(!pop.equals(map.get(c))){
                        return false;
                    }
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}