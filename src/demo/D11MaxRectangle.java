package demo;

import java.util.Stack;

public class D11MaxRectangle {
    public static int maxRec(int[][] arr){
        if (arr == null) return 0;
        int[] height = new int[arr.length];
        int maxRec = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        int weight = 0;
        for (int i = 0; i < arr.length; i++) {
            getHeight(arr, height, i);
            for (int j = 0; j < height.length; j++) {
                while (!stack.isEmpty() && height[j] <= height[stack.peek()]){
                    int tmp = stack.pop();
                    weight = stack.isEmpty() ? tmp + 1 : tmp - stack.peek();
                    maxRec = Math.max(maxRec, weight*height[tmp]);
                }
                stack.push(j);
            }
            while (!stack.isEmpty()){
                int tmp = stack.pop();
                weight = stack.isEmpty() ? height.length : height.length - 1 - stack.peek();
                maxRec = Math.max(maxRec, weight*height[tmp]);
            }
        }
        return maxRec;
    }

    private static void getHeight(int[][] arr, int[] height, int i) {
        for (int j = 0; j < height.length; j++) {
            if (arr[i][j] == 0){ // 当前行是0，则直接为0
                height[j] = 0;
            }else {
                height[j]++; //如果当前行不是0，则累加高度
            }
        }
    }
}
