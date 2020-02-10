package algorithm.stackAndQueue;

import java.util.Stack;

public class Q03GetMinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Q03GetMinStack(){
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int num){
        stackData.push(num);
        if (stackMin.isEmpty()){
            stackMin.push(num);
        } else if (num < stackMin.peek()){
            stackMin.push(num);
        } else {
            stackMin.push(stackMin.peek());
        }
    }
    public int peek(){
        if (stackData.isEmpty()){
            throw new RuntimeException("the stack is empty");
        }
        return stackData.peek();
    }
    public int pop(){
        if (stackData.isEmpty()){
            throw new RuntimeException("the stack is empty");
        }
        stackMin.pop();
        return stackData.pop();
    }
    public int getMin(){
        if (stackMin.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        return stackMin.peek();
    }
}
