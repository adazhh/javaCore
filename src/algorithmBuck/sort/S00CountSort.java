package algorithmBuck.sort;

public class S00CountSort {
    public static void countSort(int[] arr){
        if (arr == null && arr.length < 2){
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] bucket = new int[max];
        for (int i = 0; i < arr.length; i++){
            bucket[arr[i]]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0){
                arr[i++] = j;
            }
        }
    }
}
