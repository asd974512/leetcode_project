package com.ning.week1;

/**
 * 2022/3/2 10:10
 * 2022/3/2 10:55
 */

public class java014最长公共前缀 {
    public static void main(String[] args) {
        Solution014 solution014 = new Solution014();
        String[] strings1 = {"flox", "flow", "fly", "flx", "fx"};
        String[] strings2 = {"ab", "a"};
        String s = solution014.longestCommonPrefix(strings1);
        System.out.println(s);

    }
}

class Solution014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String preStr = strs[0];  //最长前缀
        int length = strs.length;
        //用前缀和当前的元素进行比较，得到最新的前缀
        for (int i = 1; i < length; i++) {
            preStr = getPrefix(preStr, strs[i]);
            if (preStr.length() == 0) {  //length==0说明前缀为“”，就可以返回了
                return "";
            }
        }
        return preStr;
    }

    public String getPrefix(String preStr, String nowStr) {
        int index =0;
        int minLength = Math.min(preStr.length(),nowStr.length());
        while(index<minLength && preStr.charAt(index)==nowStr.charAt(index)){
            index++;
        }
        return preStr.substring(0,index);
    }
}


/**
 * 看看人家的代码，多简洁
 */
/*
class Solution014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                //这个代码写得好，第一个条件等于找到最短元素，所以不会越界
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}*/



/*class Solution014 {  //纵向比较
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        } //只有一个就返回自己
        boolean flag = true; // false时，说明前缀中断了
        int length = strs.length;  //字符串数组的长度
        int minLength = strs[0].length();
        for (int i = 1; i < length; i++) {  //字符串数组元素的长度最短的元素【的长度】
            minLength = Math.min(minLength, strs[i].length());
        }
        if (minLength == 0) { //如果最短为0，说明有一个“”空串，就没有公共前缀了
            return "";
        }
        for (int i = 0; i < minLength; i++) {  //字符串组中最短子串的长度
            for (int j = 1; j < length; j++) {  //字符串组中的元素个数
                //用第一个元素的【i位置】一直比较其他元素的【i位置】
                //如果不相等，说明前缀就只有之前的i那么长了
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) { //说明前缀寻找中断了
                return strs[0].substring(0, i);
            }
        }//把最短长度都遍历了，如果前面没有return，说明最短前缀就是最短长度的那个元素
        return strs[0].substring(0, minLength);
    }
}*/