package algorithmBuck.stackAndQueue;

public class Q02ArrayQueue {
    private Integer[] arr;
    private int size;
    private int first;
    private int last;

    public Q02ArrayQueue(int initSize){
        if (initSize < 0){
            throw new IllegalArgumentException("less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
        first = 0;
        last = 0;
    }
    public Integer peek(){
        if (size == 0){
            return null;
        }
        return arr[first];
    }
    public void push(int num){
        if (size == arr.length){
            throw new ArrayIndexOutOfBoundsException("the queue is full");
        }
        size++;
        arr[last] = num;
        last = (last == arr.length - 1) ? 0 : last+1;
    }
    public Integer pop(){
        if (size == 0){
            throw new ArrayIndexOutOfBoundsException("the queue is empty");
        }
        size--;
        int tmp = first;
        first = (first == arr.length - 1) ? 0 : first + 1;
        return arr[tmp];
    }
}
