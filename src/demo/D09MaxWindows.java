package demo;

import java.util.LinkedList;

public class D09MaxWindows {
    public static int[] getMaxWindows(int[] arr, int w){
        if (arr == null) return null;
        if (arr.length < w){
            int max = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                max = Math.max(max, arr[i]);
            }
            return new int[]{max};
        }
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!list.isEmpty() && arr[list.peekLast()] <= arr[i]){
                list.pollLast();
            }
            list.add(i);
            if (list.peekFirst() == i - w){
                list.pollLast();
            }
            if (i + 1 > w){
                res[index++] = arr[list.peekFirst()];
            }
        }
        return res;
    }
}
