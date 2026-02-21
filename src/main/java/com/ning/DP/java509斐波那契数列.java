package com.ning.DP;

public class java509斐波那契数列 {
    public static void main(String[] args) {
        Solution509 solution509 = new Solution509();
        int fib = solution509.fib(4);
        System.out.println(fib);
    }
}

class Solution509 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        int q = 1;
        int p = 1;
        int r = 0;
        for (int i = 3; i <= n; i++) {
            r = q+p;
            q = p;
            p =r;
        }
        return r;
    }
}
