package demo;

public class D15PartitionSort {
    public static void sort(int[] arr){
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }
    private static void quickSort(int[] arr, int left, int right){
        if (left == right) return;
        int num = left + (int)(Math.random() * (right - left + 1));
        swap(arr, num, right);
        int p = partition(arr, left, right);
        quickSort(arr, left, p-1);
        quickSort(arr, p+1, right);
    }
    private static int partition(int[] arr, int left, int right){
        int less = left - 1;
        int more = right;
        while (left < more){
            if (arr[left]<=arr[right]){
                swap(arr, ++less, left++);
            }else {
                swap(arr, --more, left);
            }
        }
        swap(arr, more, right);
        return more;
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
