package algorithm.recursionAndDynamic;

import java.util.Arrays;
import java.util.Scanner;

public class R03BeatBall {
    public static void main(String[] args) {
        solve();
    }
    private static void solve(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i+1] = scanner.nextInt();
        }
        System.out.println(recur(arr, 1, n));
    }
    private static int recur(int[] arr, int left, int right){
        if (left == right){
            return arr[left-1] * arr[left] * arr[right+1];
        }
        int max = Math.max(
                arr[left-1] * arr[left] * arr[right+1] + recur(arr, left+1, right),
                arr[left-1] * arr[right] * arr[right+1] + recur(arr, left, right-1)
        );
        for (int i = left+1; i < right; i++) {
            max = Math.max(max, arr[left-1]*arr[i]*arr[right+1] +
                            recur(arr, left, i-1) + recur(arr, i+1, right));
        }
        return max;
    }

}
