package shousi;

import java.util.ArrayDeque;
import java.util.Deque;

public class java栈的压入弹出 {
    public static void main(String[] args) {

    }
}

class Solution栈的压入弹出 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = pushed.length;
        int i = 0;
        int j = 0;
        for(i=0;i<n;i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
