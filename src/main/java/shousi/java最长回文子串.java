package shousi;

public class java最长回文子串 {
    public static void main(String[] args) {
        Solutionjava最长回文子串 solution = new Solutionjava最长回文子串();
        System.out.println(solution.longestPalindrome("babad"));
    }
}

class Solutionjava最长回文子串 {
    public String longestPalindrome(String s) {
        int length = s.length();
        if(length<=1){
            return s;
        }
        int left = 0;
        int right = 0;
        int maxLength =0;
        int MaxLeft = 0;
        for(int i=0;i<s.length();i++){
            left = i-1;
            right = i+1;
            //当前长度
            int L = 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
                L++;
            }
            while(right<s.length()&&s.charAt(right)==s.charAt(i)){
                right++;
                L++;
            }
            while(left>=0 && right<s.length() &&
                    s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                L = L+2;
                }
            if(L>=maxLength){
                maxLength = L;
                MaxLeft = left+1;
            }
        }
        return s.substring(MaxLeft,MaxLeft+maxLength);
    }
}
