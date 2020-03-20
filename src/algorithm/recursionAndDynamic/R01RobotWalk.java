package algorithm.recursionAndDynamic;

import java.util.Scanner;

public class R01RobotWalk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int range = scanner.nextInt();
        int cur = scanner.nextInt();
        int step = scanner.nextInt();
        int target = scanner.nextInt();
        // 2<=N<=5000）、M(1<=M<=N)、K(1<=K<=5000)、P(1<=P<=N
        if (!(2<=range && range<=5000) || !(1<=cur && cur<= range)
        || !(1<=step || step<= 5000) || !(1<=target || target <= range)){
            return;
        }
        System.out.println(dp(range, cur, step, target));
    }

    private static long process(int range, int cur, int step, int target){
        if (step == 0){
            return (cur==target) ? 1 : 0;
        }
        long res = 0;
        if (cur == 1){
            res = process(range, cur+1, step-1, target);
        }else if (cur == range){
            res = process(range, cur - 1, step - 1, target);
        } else {
            res = process(range, cur-1, step-1, target) +
                    process(range, cur+1, step-1, target);
        }
        return res;
    }
    private static long dp(int range, int cur, int rest, int target){
        // int mod = (int)1e9+7;
        int mod = (int) (Math.pow(10, 9) + 7);
        int[][] dp = new int[rest+1][range];
        dp[0][target-1] = 1;
        for (int i = 1; i < rest+1; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][range-1] = dp[i-1][range-2];
            for (int j = 1; j < range-1; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
            }
        }
        return dp[rest][cur-1];
    }
}
