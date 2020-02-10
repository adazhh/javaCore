package algorithm.sort;

public class S00sMain {
    public static void main(String[] args) {
        int[] arr = new int[]{28,4,23,45,12,3,33,7,55,12,9,19,16,2,10,8};
        // 插入排序
        S00InsSort.insSort01(arr.clone());
        // 选择排序
        S00SelectionSort.sort(arr.clone());
        // 冒泡排序
        S00BubSort.sort(arr.clone());
        // 快速排序
        S00_QuickSort3.sort(arr.clone());
        // 归并排序
        S00MergeSort.sort(arr.clone());


    }
}
