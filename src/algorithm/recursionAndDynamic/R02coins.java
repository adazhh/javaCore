package algorithm.recursionAndDynamic;

import java.util.Scanner;

public class R02coins {
    public static void main(String[] args) {
       solve();
    }
    private static void solve(){
        Scanner scanner = new Scanner(System.in);
        String[] str= scanner.nextLine().split(" ");
        int len = Integer.valueOf(str[0]);
        int target = Integer.valueOf(str[1]);
        str = scanner.nextLine().split(" ");
        int[] arr = new int[len];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.valueOf(str[i]);
        }
        System.out.println(dp2(arr, target));
    }
    //递归实现
    private static int recur(int[] arr, int target, int index){
        if (target == 0){
            return 1;
        }
        if (index == arr.length) return 0;
        int res = 0;
        for (int i = 0; i * arr[index] <= target ; i++) {
            res += recur(arr, target - i*arr[index], index + 1);
        }
        return res;
    }
    // 动态规划实现
    private static int dp(int[] arr, int target){
        int mod = (int) (Math.pow(10, 9) + 7);
        int[][] dp = new int[arr.length][target + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i * arr[0] <= target; i++) {
            dp[0][i*arr[0]] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < target+1; j++) {
                dp[i][j] = dp[i-1][j];
                dp[i][j] = (dp[i][j] + ((j >= arr[i]) ? dp[i][j-arr[i]] : 0)) % mod;
            }
        }
        return dp[arr.length-1][target];
    }
    // 压缩空间版递归
    private static int dp2(int[] arr, int target){
        int mod = (int) (Math.pow(10, 9) + 7);
        int[] dp = new int[target+1];
        for (int i = 0; i*arr[0] < dp.length; i++) {
            dp[i*arr[0]] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                dp[j] = (dp[j] + ((j >= arr[i]) ? dp[j-arr[i]] : 0)) % mod;
            }
        }
        return dp[target];
    }
}
