package algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class S00MergeSort {
    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low == high) return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= high) temp[k++] = arr[j++];
        // int i1 = 0;
        // for (int i2 : temp) {
        //     arr[i++] = i2;
        // }
        for (i = low, k = 0; i <= high; i++) {
            arr[i] = temp[k++];
        }
        temp = null;
    }

}
