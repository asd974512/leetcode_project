package com.ning.week1;

/**
 * 2022/3/6 9:30
 */
public class java058最后一个单词的长度 {
    public static void main(String[] args) {
        Solution058 solution058 = new Solution058();
        String s = "joyboy  ";
        int i = solution058.lengthOfLastWord(s);
        System.out.println(i);
    }
}

class Solution058 {
    public int lengthOfLastWord(String s) {
        int index = s.length()-1;
        int wordLength = 0;
        while(s.charAt(index) == ' '){
            index--;
        }
        //此时index指的值!= ' '
        while(index>=0 && s.charAt(index)!= ' '){
            index--;
            wordLength++;
        }
        return wordLength;
    }
}

//class Solution058 {
//    public int lengthOfLastWord(String s) {
//        String[] splits = s.split(" ");
//        return splits[splits.length-1].length();
//    }
//}

