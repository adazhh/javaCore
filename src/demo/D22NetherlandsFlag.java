package demo;

import java.util.Arrays;

public class D22NetherlandsFlag {
    public static void netherlandsFlags(int[] arr, int aim){
        if (arr == null || arr.length < 2) return;
        int index = 0;
        int less = -1, more = arr.length;
        while (index < more){
            if (arr[index] < aim){
                swap(arr, ++less, index++);
            }else if (arr[index] == aim){
                index++;
            }else if (arr[index] > aim){
                swap(arr, --more, index);
            }
        }
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 6, 10, 11, 6, 99, 2};
        netherlandsFlags(arr, 6);
        System.out.println(Arrays.toString(arr));
    }
}
