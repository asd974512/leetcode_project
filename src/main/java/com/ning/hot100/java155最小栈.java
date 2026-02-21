package com.ning.hot100;

import javax.lang.model.element.VariableElement;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class java155最小栈 {


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(5);
        minStack.push(1);
        minStack.push(-2);
        minStack.push(3);
        minStack.push(5);

        for(int i=0;i<6;i++){
            minStack.pop();
        }

    }



}


class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.add(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(minStack.peek(),val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }
    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}