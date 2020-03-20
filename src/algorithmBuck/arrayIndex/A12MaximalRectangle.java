package algorithmBuck.arrayIndex;

import java.util.Arrays;
import java.util.Stack;

public class A12MaximalRectangle {
    public static int maxRecSize(int[][] arr){
        if (arr == null) return 0;
        int[] height = new int[arr[0].length];
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        int width = 0;
        for (int i = 0; i < arr.length; i++) { // 一次求出以0行--最下面一行为底的矩阵大小
            getHeightNum(arr, i, height); //获得以i行为底的矩阵高度
            for (int j = 0; j < height.length; j++) { // 单调栈结构，求两边最近比j高度小的位置
                while (!stack.isEmpty() && height[j] <= height[stack.peek()]){
                    int tmp = stack.pop();
                    width = (stack.isEmpty()) ? tmp + 1 : tmp-stack.peek();
                    maxArea = Math.max(maxArea, height[tmp] * width);
                }
                stack.push(j);
            }
            while (!stack.isEmpty()){
                int tmp = stack.pop();
                width = (stack.isEmpty()) ? height.length : height.length - 1 - stack.peek();
                maxArea = Math.max(maxArea, height[tmp] * width);
            }
        }
        return maxArea;
    }
    private static void getHeightNum(int[][] arr, int i, int[] height){
        System.out.println(Arrays.toString(height));
        for (int j = 0; j < height.length; j++) {
            if (arr[i][j] == 0){ // 当前行是0，则直接为0
                height[j] = 0;
            }else {
                height[j]++; //如果当前行不是0，则累加高度
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {4,3,5,6};
        int[][] map = {
                {1,0,1,1},
                {1,1,1,1},
                {1,1,1,0},
                {1,1,1,1}};
        int maxRecSize = maxRecSize(map);
        System.out.println(maxRecSize);
        // int result = maxRecSize(a);
        // System.out.println(result);
    }
}
