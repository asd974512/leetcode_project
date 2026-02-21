package again;

public class java解码方法 {
    public static void main(String[] args) {

    }

    public static int numDecodings(String s) {
        int N = s.length();
        if (N == 1) {
            return 1;
        }
        //dp[i]表示长度为i的字符，他能有几种解码方式
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1];
            int nowNum = Character.digit(s.charAt(i - 1), 10);
            int preNum = Character.digit(s.charAt(i - 2), 10);
            if (nowNum + preNum * 10 <= 26 && nowNum!=0 && preNum!=0) {
                dp[i] += dp[i - 2];
            }

        }
        return dp[N];

    }
}
