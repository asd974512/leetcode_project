package again;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class java有效的括号 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            solution(s);
        }
    }

    public static void solution(String s) {
        if (s.length() % 2 != 0) {
            System.out.println("false");
            return;
        }
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //说明是右括号，要求左边一定要有对应的才行
            if (hashMap.containsKey(ch)) {
                //
                if (stack.isEmpty() || stack.peek()!=hashMap.get(ch)) {
                    System.out.println("false");
                    return;
                }else{
                    //右括号对应上了，stack弹出
                    stack.pop();
                }
            } else {
                //左括号，加进去就行
                stack.push(ch);
            }
        }
        System.out.println(stack.isEmpty());
    }
}
