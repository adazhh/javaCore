package algorithmBuck.offerGuide;

import java.util.ArrayList;
//
public class O29GetLeastNum2 {
    public static void main(String[] args) {
        O29GetLeastNum num = new O29GetLeastNum();
        int[] arr = new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = num.GetLeastNumbers_Solution(arr, 6);
        System.out.println(list.toString());
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length < k || k == 0) return list;
        quick(input, 0, input.length-1, k);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }
    // 递归调用快速排序
    private void quick(int[] arr, int low, int high, int k){
        int mid;
        if (low < high){
            mid = partition(arr, low, high);
            quick(arr, low, mid-1, k);
            if (mid < k-1){
                quick(arr,  mid+1, high, k);
            }
        }
    }
    // 每次都和基准元素进行比较
    private int partition(int[] arr, int low, int high){
        int i=low, j=high, pivot=arr[low];
        while (i<j){
            while (i<j && pivot<arr[j]) j--; // 右边元素小于等于基准元素时，坐标左移
            if (i<j) swap(arr, i++, j); // 大于基准元素则进行交换，i右移一格
            while (i<j && pivot>=arr[i]) i++;
            if (i<j) swap(arr, i, j--);
        }
        return i;
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
