package algorithm.sort;

import java.util.Arrays;

public class InsSort {
    // 插入排序，注意点j=i
    public static void insSort01(int[] arr){
        for (int i=1; i<arr.length; i++){
            int temp = arr[i];
            for (int j=i; j>=0; j--){
                if ( j>0 && arr[j-1] > temp){
                    arr[j] = arr[j-1];
                }else {
                    arr[j] = temp;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
