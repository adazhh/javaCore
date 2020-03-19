package algorithm.bitOperation;

import java.util.HashMap;

public class B03MostEOR {
    public int mostEOR(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int eor = 0;
        // dp[i]的含义是如果在arr[0..i]上做分割，异或和为 0 的子数组最多能有多少个
        int[] dp = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        dp[0] = (arr[0] == 0) ? 1 : 0;
        map.put(dp[0], 0);
        for (int i = 1; i < dp.length; i++) {
            eor ^= arr[i];
            if (map.containsKey(eor)){
                // eorIndexPre相当于k值，也就是最后一次出现的使得包括i在内的数组异或和为0的数
                int eorIndexPre = map.get(eor);
                // 此时的dp[i]为最后一个异或和为0的子数组必须包含i
                dp[i] = (eorIndexPre == -1) ? 1 : dp[eorIndexPre]+1;
            }
            // 两种情况，一种是不包含i，一种是包含i
            dp[i] = Math.max(dp[i-1], dp[i]);
            map.put(eor, i);
        }
            return dp[dp.length - 1]; // 最后一个位置就是最大划分数
    }
}
