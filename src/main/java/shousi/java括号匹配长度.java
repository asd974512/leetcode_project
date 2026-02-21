package shousi;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class java括号匹配长度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int solution = solution(s);
        System.out.println(solution);
    }

    public static int solution(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        Deque<Character> deque = new ArrayDeque<>();
        deque.addLast(s.charAt(0));
        int i = 1;
        int maxSize = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c == '(') {
                deque.addLast(c);
                maxSize = Math.max(maxSize, deque.size());
            } else if (c == ')') {
                deque.pop();
            }
            i++;
        }
        return maxSize;
    }
}
