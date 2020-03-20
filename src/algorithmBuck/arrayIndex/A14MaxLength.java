package algorithmBuck.arrayIndex;

import java.util.HashMap;

public class A14MaxLength {
    public static int getMaxLength(int[] arr, int aim){
        if (arr == null || arr.length < 1) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // 很重要，考虑到一开始和为0
        int sum = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - aim)){
                maxLength = Math.max(maxLength, i - map.get(sum-aim));
            }
            if (!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}
