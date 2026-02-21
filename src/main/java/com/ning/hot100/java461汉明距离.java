package com.ning.hot100;

public class java461汉明距离 {
    public static void main(String[] args) {
        Solution461 solution461 = new Solution461();
        int i = solution461.hammingDistance(1, 4);
        System.out.println(i);
    }
}

class Solution461 {
    public int hammingDistance(int x, int y) {
        int result = x ^ y;
        int count = 0;
        while(result !=0){
            count+=result&1;
            result = result>>1;
        }
        return count;
    }
}
