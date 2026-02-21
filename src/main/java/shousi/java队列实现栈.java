package shousi;

import java.util.ArrayDeque;
import java.util.Deque;

public class java队列实现栈 {
    public static void main(String[] args) {
//        MyStack stack = new MyStack();
//        stack.push(1);
//        stack.push(2);
//        System.out.println(stack.top());
//        System.out.println(stack.pop());

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);
        deque.poll();
        deque.pop();
    }
}

class MyStack{
    Deque<Integer> deque1;
    Deque<Integer> deque2;

    MyStack(){
        deque1 = new ArrayDeque<>();
        deque2 = new ArrayDeque<>();
    }
    public void push(int x){
        deque1.add(x);
    }
    public int pop(){
        while(deque1.size()>1){
            deque2.add(deque1.poll());
        }
        Integer pop = deque1.pop();
        while(!deque2.isEmpty()){
            deque1.add(deque2.pop());
        }
        return pop;
    }

    public int top(){
        while(deque1.size()>1){
            deque2.push(deque1.poll());
        }
        Integer peek = deque1.peek();
        deque2.push(deque1.poll());
        while(!deque2.isEmpty()){
            deque1.push(deque2.pop());
        }
        return peek;
    }

    public boolean empty(){
        if(deque1.isEmpty() && deque2.isEmpty()){
            return true;
        }
        return false;
    }
}