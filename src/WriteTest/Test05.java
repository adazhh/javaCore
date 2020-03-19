package WriteTest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Test05 {
    private static int[] height;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.valueOf(scanner.nextLine());
        if (row <= 0) {
            System.out.println(0);
            return;
        }
        String next = scanner.nextLine();
        int col = next.length();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < next.length(); i++) {
            matrix[0][i] = Integer.valueOf(next.charAt(i)-'0');
        }
        int j = 0;
        for (int i = 1; i < row; i++) {
            String input = scanner.nextLine();
            j = 0;
            for (int k = 0; k < input.length(); k++) {
                matrix[i][j++] = Integer.valueOf(input.charAt(k)-'0');
            }
        }
        System.out.println(search_matrix(matrix));
    }
    private static int search_matrix(int[][] arr){
        height = new int[arr[0].length];
        int res = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        int width = 0;
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            getHeight(arr, i);
            for (int j = 0; j < height.length; j++) {
                while (!stack.isEmpty() && height[j] <= height[stack.peek()]){
                    int temp = stack.pop();
                    width = (stack.isEmpty()) ? temp + 1 : temp - stack.peek();
                    min = Math.min(width, height[temp]);
                    res = Math.max(res, min * min);
                }
                stack.push(j);
            }
            while (!stack.isEmpty()){
                int temp = stack.pop();
                width = (stack.isEmpty()) ? height.length : height.length - 1 - stack.peek();
                min = Math.min(width, height[temp]);
                res = Math.max(res, min * min);
            }
        }
        return res;
    }
    private static void getHeight(int[][] arr, int i){
        System.out.println(Arrays.toString(height));
        for (int j = 0; j < height.length; j++) {
            if (arr[i][j] == 0){
                height[j] = 0;
            }else if(arr[i][j] == 1) {
                height[j]++;
            }
        }
    }
}
