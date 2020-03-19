package demo;

import javafx.collections.ObservableArray;

import java.util.LinkedList;

public class D10CountNum {
    public static int countNum(int[] arr, int num){
        if (arr == null) return 0;
        LinkedList<Integer> maxList = new LinkedList<>();
        LinkedList<Integer> minList = new LinkedList<>();
        int res = 0;
        maxList.add(0);
        minList.add(0);
        int front = 0;
        int back = 0;
        while (front < arr.length){
            while (back < arr.length){
                while (!minList.isEmpty() && arr[minList.peekLast()] >= arr[back]){
                    minList.pollLast();
                }
                minList.add(back);
                while (!maxList.isEmpty() && arr[maxList.peekLast()] <= arr[back]){
                    maxList.pollLast();
                }
                maxList.add(back);
                if (arr[maxList.peekFirst()] - arr[minList.peekFirst()] > num){
                    break;
                }
                back++;
            }
            if (maxList.peek() == front){
                maxList.poll();
            }
            if (minList.peek() == front){
                minList.poll();
            }
            res += (back-front);
            front++;
        }
        return res;
    }
}
