package WriteTest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Test06 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] dp = getDp(arr);
        int[] res = generateLIS(arr, dp);
        System.out.println(Arrays.toString(res));
    }

    private static int[] generateLIS(int[] arr, int[] dp) {
        int len = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            if (len < dp[i]){
                len = dp[i];
                index = i;
            }
        }
        int[] res = new int[len];
        res[--len] = arr[index];
        for (int i = index; i >= 0; i--) {
            if (arr[i] < res[len] && dp[i] == dp[index] - 1){
                res[--len] = arr[i];
                index = i;
            }
        }
        return res;
    }

    public static int[] getDp(int[] arr){
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]){
                    res[i] = Math.max(res[j]+1, res[i]);
                }
            }
        }
        return res;
    }
}
