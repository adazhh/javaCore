package demo;

public class D14MergeSort {
    public static void sort(int[] arr){
        if (arr == null || arr.length < 2) return;
        mergeSort(arr, 0, arr.length-1);
    }
    public static void mergeSort(int[] arr, int left, int right){
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
    public static void merge(int[] arr, int left, int mid, int right){
        int[] tmpArr = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int index = 0;
        while (p1 <= mid && p2 <= right){
            tmpArr[index++] = (arr[p1] <= arr[p2]) ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){
            tmpArr[index++] = arr[p1++];
        }
        while (p2 <= right){
            tmpArr[index++] = arr[p2++];
        }
        for (int i = 0; i < tmpArr.length; i++) {
            arr[left++] = tmpArr[i];
        }
    }
}
