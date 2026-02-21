package com.ning.week1;


/**
 * Start Time 2022/3/1 16:08
 * End Time 2022/3/1 16:55
 */
public class java09回文数 {
    public static void main(String[] args) {
        Solution09 solution = new Solution09();
        int x = 121;
        boolean palindrome = solution.isPalindrome(x);
        System.out.println(palindrome);
    }
}

class Solution09 {  //更好的解法
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && (x != 0))) {
            return false;
        }
        int reverseNum = 0;
        int last = 0;
        while (reverseNum < x) {
            last = x % 10;
            reverseNum = reverseNum * 10 + last;
            x = x / 10;
        }
        if (x == reverseNum) {
            return true;
        } else if (x == reverseNum / 10) {
            return true;
        } else {
            return false;
        }
    }
}
/*class Solution09 {
    public boolean isPalindrome(int x) {
        if(x<0){  //负数肯定不是
            return false;
        }
        String s = String.valueOf(x);  //先把整数变成String
        char[] chars = s.toCharArray();    //再把String变成char[]
        int length = chars.length;
        for(int i=0;i<length/2;i++){        //比较char[]头尾两端是否相等
            if(chars[i]!=chars[length-1-i]){
                return false;
            }
        }
        return true;
    }
}*/
