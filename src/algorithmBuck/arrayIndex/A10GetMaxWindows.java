package algorithmBuck.arrayIndex;

import java.util.LinkedList;

public class A10GetMaxWindows {
    public static int[] getMaxWindows(int[] arr , int w) {
        if (arr == null) return null;
        if (arr.length <= w){
            int max = Integer.MIN_VALUE;
            for (int i : arr) {
                max = arr[i] > max ? arr[i] : max;
            }
            return new int[]{max};
        }
        int[] res = new int[arr.length - w + 1];
        LinkedList<Integer> deque = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]){
                deque.pollLast();
            }
            deque.add(i);
            if (deque.peek() == i - w){
                deque.poll();
            }
            if (i + 1 >= w){
                res[index++] = arr[deque.peek()];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {4,3,5,4,3,3,6,7};
        int[] maxWindows = getMaxWindows(arr, 3);
        for(int i = 0; i < maxWindows.length; i++)
        {
            System.out.print(maxWindows[i] + " ");
        }

    }
}
