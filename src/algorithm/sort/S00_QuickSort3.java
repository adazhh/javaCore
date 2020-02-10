package algorithm.sort;

import java.util.Arrays;

public class S00_QuickSort3 {
    public static void sort(int[] arr){
        quick(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    // 递归调用快速排序
    private static void quick(int[] arr, int low, int high){
        int min;
        if (low < high){
            min = partition1(arr, low, high);
            quick(arr, low, min-1);
            quick(arr, min+1, high);
        }
    }
    // 每次都和基准元素进行比较
    private static int partition1(int[] arr, int low, int high){
        int i=low, j=high, pivot=arr[low];
        while (i<j){
            while (i<j && pivot<arr[j]) j--; // 右边元素小于等于基准元素时，坐标左移
            if (i<j) swap(arr, i++, j); // 大于基准元素则进行交换，i右移一格
            while (i<j && pivot>=arr[i]) i++;
            if (i<j) swap(arr, i, j--);
        }
        return i;
    }
    // 方法一的改良版，每次让比基准元素大的和小的进行交换，可以减少交换次数
    private static int partition2(int[] arr, int low, int high){
        int i=low, j=high, pivot=arr[low];
        while(i<j){
            while (i<j && pivot < arr[j]) j--;
            while (i<j && pivot >= arr[i]) i++;
            if (i<j) swap(arr, i++, j--);
        }
        if (arr[i] > pivot){
            swap(arr, i-1, low);
            return i-1;
        }else {
            swap(arr, i, low);
            return i;
        }
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
