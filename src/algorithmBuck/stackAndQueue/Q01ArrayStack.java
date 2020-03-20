package algorithmBuck.stackAndQueue;

public class Q01ArrayStack {
    private Integer[] arr;
    private Integer size;

    public Q01ArrayStack(int initSize){
        if (initSize < 0){
            throw new IllegalArgumentException("less than 0");
        }
        arr = new Integer[initSize];
    }
    public Integer peek(){
        if (size == 0){
            return null;
        }
        return arr[size - 1];
    }
    public void push(int num){
        if (size == arr.length){
            throw new ArrayIndexOutOfBoundsException("the stack is full");
        }
        arr[size++] = num;
    }
    public int pop(){
        if (size == 0){
            throw new ArrayIndexOutOfBoundsException("the stack is empty");
        }
        return arr[--size];
    }
}
