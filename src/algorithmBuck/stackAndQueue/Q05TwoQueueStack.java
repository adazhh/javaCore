package algorithmBuck.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Q05TwoQueueStack {
    private Queue<Integer> queue;
    private Queue<Integer> help;
    public Q05TwoQueueStack(){
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }
    public void push(int num){
        queue.add(num);
    }
    public int peek(){
        if (queue.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        while (queue.size() != 1){
            help.add(queue.poll());
        }
        int res = queue.poll();
        help.add(res);
        swap();
        return res;
    }
    public int pop(){
        if (queue.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        while (queue.size() != 1){
            help.add(queue.poll());
        }
        int res = queue.poll();
        swap();
        return res;
    }
    private void swap(){
        Queue<Integer> tmp = queue;
        queue = help;
        help = tmp;
    }
}
