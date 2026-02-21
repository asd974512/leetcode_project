package com.ning.week1;

/**
 * 2022/3/1
 * 2022/3/2
 */

public class java013罗马数字转整数 {
    public static void main(String[] args) {
        Solution013 solution = new Solution013();
        String str = new String("LVIII");
        int i = solution.romanToInt(str);
        System.out.println(i);

    }
}


class Solution013 {
    public int romanToInt(String s) {
        int result = 0;
        int preNum = 0;
        int nowNum = 0;
        preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            nowNum = getValue(s.charAt(i));
            if (preNum >= nowNum) {  //记得是>=，不能是= 存在“III”这种情况
                result += preNum;
            } else {
                result -= preNum;
            }
            preNum = nowNum;
        }
        result+=preNum;//循环结束了，但是最后一位还没有算，最后一位肯定是加
        return result;
    }

    public int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}


/**
 * I=1 V=5 X=10 L=50 C=100 D=500 M=1000
 */
/*
class Solution013 {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        int i;
        for ( i=0; i < chars.length-1;) { //越界出事，所以要-1
            if (chars[i] == 'I' && chars[i + 1] == 'V') {
                i+=2;
                result+=4;
            }else if (chars[i] == 'I' && chars[i + 1] == 'X'){
                i+=2;
                result+=9;
            }else if (chars[i] == 'X' && chars[i + 1] == 'L'){
                i+=2;
                result+=40;
            }else if (chars[i] == 'X' && chars[i + 1] == 'C'){
                i+=2;
                result+=90;
            }else if (chars[i] == 'C' && chars[i + 1] == 'D'){
                i+=2;
                result+=400;
            }else if (chars[i] == 'C' && chars[i + 1] == 'M'){
                i+=2;
                result+=900;
            }else{ //不是特殊情况，单个单个
                if(chars[i] == 'I'){
                    i++;
                    result++;
                }else if(chars[i] == 'V'){
                    i++;
                    result+=5;
                }else if(chars[i] == 'X'){
                    i++;
                    result+=10;
                }else if(chars[i] == 'L'){
                    i++;
                    result+=50;
                }else if(chars[i] == 'C'){
                    i++;
                    result+=100;
                }else if(chars[i] == 'D'){
                    i++;
                    result+=500;
                }else if(chars[i] == 'M'){
                    i++;
                    result+=1000;
                }
            }
        }
        if(i ==chars.length-1) //说明倒数12位是单独的
        {
            if(chars[i] == 'I'){
                i++;
                result++;
            }else if(chars[i] == 'V'){
                i++;
                result+=5;
            }else if(chars[i] == 'X'){
                i++;
                result+=10;
            }else if(chars[i] == 'L'){
                i++;
                result+=50;
            }else if(chars[i] == 'C'){
                i++;
                result+=100;
            }else if(chars[i] == 'D'){
                i++;
                result+=500;
            }else if(chars[i] == 'M'){
                i++;
                result+=1000;
            }
        }
        return result;
    }
}*/