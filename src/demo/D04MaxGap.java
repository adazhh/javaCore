package demo;

public class D04MaxGap {
    public static int maxGap(int[] arr){
        if (arr == null) return 0;
        int len = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        boolean[] hasNum = new boolean[len];
        int[] mins = new int[len];
        int[] maxs = new int[len];
        for (int i = 0; i < len; i++) {
            int index = bucketIndex(arr, i, max, min);
            mins[index] = hasNum[index] ? Math.min(mins[index], arr[i]) : arr[i];
            maxs[index] = hasNum[index] ? Math.max(maxs[index], arr[i]) : arr[i];
            hasNum[index] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        for (int i = 1; i < len; i++) {
            if (hasNum[i]){
                res = mins[i] - lastMax;
                lastMax = maxs[i];
            }
        }
        return res;
    }
    private static int bucketIndex(int[] arr, int i, int max, int min){
        return (arr[i]-min) / (max-min) * arr.length;
    }
}
