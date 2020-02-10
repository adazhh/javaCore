package algorithm.stackAndQueue;


import java.util.Stack;

public class Q04TwoStackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;
    public Q04TwoStackQueue(){
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }
    public void add(int num){
        stackPush.push(num);
    }
    public int poll(){
        pushToPop();
        if (stackPop.isEmpty()){
            throw new RuntimeException("the queue is empty");
        }
        return stackPop.pop();
    }
    public int peek(){
        pushToPop();
        if (stackPop.isEmpty()){
            throw new RuntimeException("the queue is empty");
        }
        return stackPop.peek();
    }
    private void pushToPop(){
        if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }
}
