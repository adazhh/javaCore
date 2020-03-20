package algorithmBuck.arrayIndex;

import java.util.Stack;

public class A13MountainsAndFlame {
    public static class Pair{
        public int value;
        public int counts;

        public Pair(int value) {
            this.value = value;
            this.counts = 1;
        }
    }
    public static int countPair(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        int maxIndex = 0;
        int size = arr.length;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            maxIndex = (arr[maxIndex] > arr[i]) ? maxIndex : i;
        }
        int index = nextIndex(maxIndex, size);
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(arr[maxIndex]));
        while (index != maxIndex) {
            while (stack.peek().value < arr[index]){
                int counts = stack.pop().counts;
                res += getintelnalSum(counts) + 2*counts;
            }
            if (stack.peek().value == arr[index]){
                stack.peek().counts++;
            } else {
                stack.push(new Pair(arr[index]));
            }
            index = nextIndex(index, size);
        }
        while (!stack.isEmpty()){
            int counts = stack.pop().counts;
            res += getintelnalSum(counts);
            if (stack.size() > 1){
                res += 2*counts;
            } else if (stack.size() == 1){
                res += (stack.peek().counts > 1) ? 2*counts : counts;
            }
        }
        return res;
    }

    private static int nextIndex(int index, int size){
        return  (index+1 < size) ? index+1 : 0;
    }
    private static long getintelnalSum(int n){
        return n == 1 ? 0L : (long)n * (long)(n-1) /2L;
    }
}
