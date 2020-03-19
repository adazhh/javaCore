package demo;

public class D07PrintMatrixZig {
    public static void printMatrixZigZag(int[][] arr){
        if (arr == null){
            return;
        }
        int upRow = 0, upCol = 0;
        int downRow =  0, downCol = 0;
        int endRow = arr.length - 1, endCol = arr[0].length - 1;
        boolean upToDown = true;
        while (upRow <= endRow){
            printLevel(arr, upRow, upCol, downRow, downCol, upToDown);
            if (upCol != endCol){
                upCol++;
            }else {
                upRow++;
            }
            if (downRow != endRow){
                downRow++;
            }else {
                downCol++;
            }
            upToDown = !upToDown;
        }
    }
    private static void printLevel(int[][] arr, int upRow, int upCol,
                                   int downRow, int downCol, boolean upToDown){
        if (upToDown){
            while (upRow <= downRow){
                System.out.print(arr[upRow++][upCol--]);
            }
            System.out.print("\n");
        }else {
            while (upRow <= downRow){
                System.out.print(arr[downRow--][downCol++]);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);
    }
}
