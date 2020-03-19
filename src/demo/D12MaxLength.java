package demo;

import java.util.HashMap;

public class D12MaxLength {
    public static int getMax(int[] arr, int aim){
        if (arr == null) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - aim)){
                maxLen = Math.max(maxLen, i - map.get(sum-aim));
            }
            if (!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
