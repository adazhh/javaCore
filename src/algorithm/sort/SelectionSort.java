package algorithm.sort;

import java.util.Arrays;
// 选择排序，从前往后选择最小的数放到前面去
public class SelectionSort {
    public static void sort(int[] arr){
        for (int i=0; i<arr.length; i++){
            int min = i;
            for (int j=i+1; j<arr.length; j++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            if (min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
