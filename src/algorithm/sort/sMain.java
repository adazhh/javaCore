package algorithm.sort;

import java.util.Arrays;

public class sMain {
    public static void main(String[] args) {
        int[] arr = new int[]{28,4,23,45,12,3,33,7,55,12,9,19,16,2,10,8};
        // 插入排序
        InsSort.insSort01(arr.clone());
        // 选择排序
        SelectionSort.sort(arr.clone());
        // 冒泡排序
        BubSort.sort(arr.clone());
        // 快速排序
        QuickSort.sort(arr.clone());
        // 归并排序
        MergeSort.sort(arr.clone());


    }
}
