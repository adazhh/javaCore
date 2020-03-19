package demo;

public class D16QuickSort {
    public static void sort(int[] arr){
        if (arr == null) return;
        quickSort(arr, 0, arr.length - 1);
    }
    private static void quickSort(int[] arr, int left, int right){
        if (left == right) return;
        int random = left + (int) Math.random() * (right - left + 1);
        swap(arr, random, right);
        int[] p = partition(arr, left, right);
        quickSort(arr, left, p[0]);
        quickSort(arr, p[1], right);
    }
    private static int[] partition(int[] arr, int left, int right){
        int less = left - 1;
        int more = right;
        while (left < more){
            if (arr[left] < arr[right]){
                swap(arr, ++less, left++);
            }else if (arr[left] > arr[right]){
                swap(arr, --more, left);
            }else if ( arr[left] == arr[right]){
                left++;
            }
        }
        swap(arr, more, right);
        return new int[]{less+1, more};
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[i];
    }
}
