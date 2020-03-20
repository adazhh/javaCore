package algorithmBuck.recursionAndDynamic;

public class R09MinPathSum {
    // 空间复杂度为O(M*N)，时间复杂度O(M*N)
    public static int minPathSum1(int[][] arr){
        if (arr == null || arr.length == 0 ||
            arr[0] == null || arr[0].length == 0){
            return 0;
        }
        int row = arr.length;
        int col = arr.length;
        int[][] dp = new int[row][col];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + arr[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j-1] + arr[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = arr[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[row-1][col-1];
    }
    // 压缩空间
    public static int minPathSum2(int[][] arr) {
        if (arr == null || arr.length < 1 || arr[0] == null || arr[0].length < 1) {
            return 0;
        }
        int[] dp = new int[arr[0].length];
        dp[0] = arr[0][0];
        for (int col = 1; col < dp.length; col++) {
            dp[col] = arr[0][col] + dp[col-1];
        }
        for (int i = 1; i < arr.length; i++) {
            dp[0] = dp[0] + arr[i][0];
            for (int j = 1; j < arr[0].length; j++) {
                dp[j] = dp[j-1] <= dp[j] ? dp[j-1]+arr[i][j] : dp[j]+arr[i][j];
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,3,5,9}, {8,1,3,4}, {5,0,6,1}, {8,8,4,0}};
        System.out.println(minPathSum1(arr));
        System.out.println(minPathSum2(arr));
    }
}
