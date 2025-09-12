package interview;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Stack2Queue {
    /**
     * 形成一个U字形的链表 instack上方是队尾 outstack上方是队首 outstack空时搬迁元素
     */
    Deque<Integer> inStack;
    Deque<Integer> outStack;
    public Stack2Queue() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

}
