package algorithmBuck.offerGuide;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class O19PrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2},{3,4}};
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list.toString());
    }
    // 做题的时候不要一味追求简便的写法而是追求清晰的写法，高效率的写法
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        ArrayList<Integer> arr = new ArrayList<>();

        if (row == 0 || col == 0) return arr;

        int top = 0, bottom = row-1, left = 0, right = col-1;
        printEdge(arr, matrix, top, bottom, left, right);
        return arr;
    }
    private static ArrayList<Integer> printEdge(ArrayList<Integer> arr, int[][] matrix, int top,
                                         int bottom, int left, int right){
        if (top > bottom || left > right) return arr;
        if (top == bottom){
            for (int i = left; i <= right; ++i){
                arr.add(matrix[top][i]);
            }
            return arr;
        }
        if (left == right){
            for (int i = top; i <= bottom; ++i){
                arr.add(matrix[i][left]);
            }
            return arr;
        }
        for (int i = left; i <= right; ++i){
            arr.add(matrix[top][i]);
        }
        for (int i = top+1; i <= bottom; ++i){
            arr.add(matrix[i][right]);
        }
        for (int i = right-1; i >= left; --i){
            arr.add(matrix[bottom][i]);
        }
        for (int i = bottom-1; i > top; --i){
            arr.add(matrix[i][left]);
        }
        printEdge(arr, matrix, ++top, --bottom, ++left, --right);
        return arr;
    }
}
