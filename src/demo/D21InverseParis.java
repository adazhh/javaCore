package demo;

public class D21InverseParis {
    public static int getParis(int[] arr){
        if (arr == null || arr.length < 2) return 0;
        return mergesort(arr, 0, arr.length - 1);
    }

    private static int mergesort(int[] arr, int left, int right) {
        if (left == right) return 0;
        int mid = left + (right - left + 1) / 2;
        return mergesort(arr, left, mid) +
                mergesort(arr, mid + 1, right) +
                merge(arr, left, mid, right);
    }
    private static int merge(int[] arr, int left, int mid, int right){
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int index = 0;
        int res = 0;
        while (p1 <= left && p2 <= right){
            res += (arr[p1] > arr[p2]) ? right - p2 + 1 : 0;
            help[index++] = arr[p1] >= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){
            help[index++] = arr[p1++];
        }
        while (p2 <= right){
            help[index++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[left+i] = help[i];
        }
        return res;
    }
}
