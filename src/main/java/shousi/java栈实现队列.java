package shousi;

import java.util.Stack;

public class java栈实现队列 {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        int pop = queue.pop();
        System.out.println(pop);
        System.out.println(queue.peek());
        System.out.println(queue.empty());
    }
}

class MyQueue{
    Stack<Integer> s1;
    Stack<Integer> s2;
    MyQueue(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    public void push(int x){
        s1.push(x);
    }
    public int pop(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    public int peek(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    public boolean empty(){
        if(s1.isEmpty() && s2.empty()){
            return true;
        }
        return false;
    }
}