package algorithm.arrayIndex;

import java.util.LinkedList;

public class A11CountNum {
    public static int count(int[] arr, int num){
        if (arr == null) return 0;
        LinkedList<Integer> minList = new LinkedList<>();
        LinkedList<Integer> maxList = new LinkedList<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length){
            while (j < arr.length){
                while (!minList.isEmpty() && arr[minList.peekLast()] >= arr[j]){
                    minList.pollLast();
                }
                minList.add(j);
                while (!maxList.isEmpty() && arr[maxList.peekLast()] <= arr[j]){
                    maxList.pollLast();
                }
                maxList.add(j);
                if ((arr[maxList.peek()] - arr[minList.peek()]) > num){
                    break;
                }
                j++;
            }
            if (maxList.peek() == i){
                maxList.poll();
            }
            if (minList.peek() == i){
                minList.poll();
            }
            res += (j-i);
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2};
        System.out.println(count(arr, 2));
    }
}
