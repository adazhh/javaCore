package algorithmBuck.sort;

import java.util.Arrays;
// 选择排序，从前往后选择最小的数放到前面去
public class S00SelectionSort {
    public static void sort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i=0; i<arr.length; i++){
            int minIndex = i;
            for (int j=i+1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            if (minIndex != i){
              swap(arr, i, minIndex);
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
