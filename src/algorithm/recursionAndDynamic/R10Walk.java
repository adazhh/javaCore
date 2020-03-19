package algorithm.recursionAndDynamic;

public class R10Walk {
    // N:位置为1-N
    // cur：当前位置，rest：剩余步数
    // P：目标位置
    public static int ways1(int N, int cur, int rest, int P){
        if (N < 2 || rest < 1 || cur < 1 || cur > N || P < 1 || P > N){
            return 0;
        }
        return walk(N, cur, rest, P);
    }
    public static int walk(int N, int cur, int rest, int P){
        if (rest == 0){
            return cur == P ? 1 : 0;
        }
        int res = 0;
        if (cur == 1){
            res = walk(N, 2, rest-1, P);
        } else if (cur == N){
            res = walk(N, N - 1, rest - 1, P);
        } else {
            res = walk(N, cur+1, rest - 1, P) +
                    walk(N, cur - 1, rest - 1, P);
        }
        return res;
    }

    public static int ways2(int N, int cur, int rest, int P){
        if (N < 2 || rest < 1 || cur < 1 || cur > N || P < 1 || P > N){
            return 0;
        }
        int[][] dp = new int[rest+1][N];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = (i == P-1) ? 1 : 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length-1; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
            }
            dp[i][0] = dp[i-1][1];
            dp[i][N-1] = dp[i-1][N-2];
        }
        return dp[rest][cur-1];
    }

    public static void main(String[] args) {
        System.out.println(ways1(7, 4, 9, 5));
        System.out.println(ways2(7, 4, 9, 5));
    }
}
