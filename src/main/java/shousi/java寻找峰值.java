package shousi;

public class java寻找峰值 {
    public static void main(String[] args) {

    }
}


class Solution寻找峰值 {
    /**
     * 寻找最后的山峰
     *
     * @param a int整型一维数组
     * @return int整型
     */
    public int solve(int[] a) {
        // write code here
        int n = a.length;
        if (n == 1) {
            return 0;
        }
        int[] mount = new int[n];
        mount[0] = a[0] - a[1] > 0 ? 1 : 0;
        mount[n - 1] = a[n - 1] - a[n - 2] > 0 ? 1 : 0;
        for(int i=1;i<n-1;i++){
            if(a[i]>a[i-1] && a[i]>a[i+1]){
                mount[i] = 1;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(mount[i]==1){
                return i;
            }
        }
        return -1;
    }
}