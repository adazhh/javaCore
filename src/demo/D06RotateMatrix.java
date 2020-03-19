package demo;

public class D06RotateMatrix {
    public static void rotateMatrix(int[][] arr){
        if (arr == null) return;
        int leftRow = 0, leftCol = 0;
        int rightRow = arr.length - 1, rightCol = arr[0].length - 1;
        while (leftRow < rightRow){
            rotate(arr, leftRow++, leftCol++, rightRow--, rightCol--);
        }
    }
    private static void rotate(int[][] arr, int leftRow, int leftCol, int rightRow, int righCol){
        int times = righCol - leftCol;
        int tmp = 0;
        for (int i = 0; i < times; i++) {
            tmp = arr[leftRow][leftCol+i];
            arr[leftRow][leftCol+i] = arr[rightRow-i][leftCol];
            arr[rightRow-i][leftCol] = arr[rightRow][righCol-1];
            arr[rightRow][righCol-1] = arr[leftRow+i][leftCol];
            arr[leftRow-i][leftCol] = tmp;
        }
    }
}
