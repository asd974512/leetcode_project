package com.ning.week1;

import javax.lang.model.element.VariableElement;
import java.util.Arrays;

public class java066加一 {
    public static void main(String[] args) {
        Solution066 solution066 = new Solution066();
        int[] num = {9,9,9,9};
        int[] ints = solution066.plusOne(num);
        System.out.println(Arrays.toString(ints));
    }
}

class Solution066 {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        digits[length-1]++;
        for (int i=length-1;i>=1;i--){
            if(digits[i]==10){
                digits[i] = 0;
                digits[i-1]++;
            }
        }
        if(digits[0] == 10){
            int[] newNum = new int[length + 1];
            newNum[0]= 1;
            return newNum;
        }else{
            return digits;
        }
    }
}