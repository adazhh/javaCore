package algorithm.sort;

import java.util.Arrays;

public class InsSort {
    public void insSort01(int[] arr){
        for (int i=1; i<arr.length; i++){
            int temp = arr[i];
            for (int j=i-1; j>=0; j--){
                if (temp < arr[j]){
                    arr[j+1] = arr[j];
                }else {
                    arr[j+1] = temp;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
