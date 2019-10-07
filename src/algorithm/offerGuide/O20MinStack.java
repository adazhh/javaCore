package algorithm.offerGuide;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 */
public class O20MinStack {
    private O20MinStack stack;

    public static void main(String[] args) {
        O20MinStack stack = new O20MinStack();
        stack.push(3);
        stack.min();
        stack.push(4);
        stack.min();
        stack.push(2);
        stack.min();
        stack.push(3);
        stack.min();
        stack.pop();
        stack.min();
        stack.pop();
        stack.min();
        stack.pop();
        stack.min();
        stack.push(0);
        stack.min();

    }

    Stack<Integer> comStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        comStack.push(node);
        if (minStack.isEmpty() || minStack.peek() > node) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        minStack.pop();
        comStack.pop();
    }

    public int top() {
        return comStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
