package algorithmBuck.recursionAndDynamic;

public class R11MinCoins {
    public static int minCoins1(int[] arr, int aim){
        if (arr == null || arr.length < 1 || aim < 0){
            return 0;
        }
        return process1(arr, 0, aim);
    }
    private static int process1(int[] arr, int index, int aim){
        if (index == arr.length) {
            return aim == 0 ? 0 : -1;
        }
        int res = -1;
        for (int i = 0; i * arr[index] <= aim; i++) {
            int next = process1(arr, index + 1, aim - i * arr[index]);
            if (next != -1){
                res = (res == -1) ? next + i : Math.min(next+i, res);
            }
        }
        return res;
    }
    public static int minCoins2(int[] arr, int aim){
        if (arr == null || arr.length < 1 || aim < 0){
            return 0;
        }
        int row = arr.length + 1;
        int[][] dp = new int[row][aim+1];
        dp[row-1][0] = 0;
        for (int col = 1; col < dp[0].length; col++) {
            dp[row-1][col] = -1;
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
                if (dp[i+1][j] != -1){
                    dp[i][j] = dp[i+1][j];
                }
                if (j >= arr[i] && dp[i][j-arr[i]] != -1){
                    if (dp[i][j] == -1){
                        dp[i][j] = dp[i][j-arr[i]] + 1;
                    } else {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j-arr[i]] + 1);
                    }
                }
            }
        }
        return dp[0][aim];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 3};
        int aim = 20;
        System.out.println(minCoins1(arr, aim));
        System.out.println(minCoins2(arr, aim));
    }
}