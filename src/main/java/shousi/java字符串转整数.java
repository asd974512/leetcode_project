package shousi;

public class java字符串转整数 {
    public static void main(String[] args) {

    }
}

class Solution字符串转整数 {
    public int sToInt(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int index = 0;
        //sigi表示正负符号
        int sign = 1;
        //result表示返回的结果
        int result = 0;
        //去除掉前面的空格
        while (index < length && chars[index] == ' ') {
            index++;
        }
        //全是空格"    "的特殊情况
        if (index == length) {
            return 0;
        }
        char c = chars[index];
        if (c == '-') {
            index++;
            sign = -1;
        }
        while (index < length) {
            c = chars[index];
            //说明不是数字了，直接跳出
            if (c < '0' || c > '9') {
                break;
            }
            //如果是数字，但不合法（溢出了）
            if(result> Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && (c-'0')>Integer.MAX_VALUE%10 )){
                return Integer.MAX_VALUE;
            }
            if(result< Integer.MIN_VALUE/10 ||result==Integer.MAX_VALUE/10 && (c-'0')>-(Integer.MIN_VALUE%10)){
                return Integer.MIN_VALUE;
            }


            //如果是数字，且合法
            //由于必须在循环里面判断是否溢出，所以不能采取全部计算完后，再乘上符号
            //因此必须在循环的时候，就乘上符号
            result = result * 10 + sign*(c - '0');
        }
        return result;
    }
}