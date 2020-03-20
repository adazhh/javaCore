package algorithmBuck.arrayIndex;

public class A07printMatrixZigZag {
    public static void printMatrixZigZag(int[][] matrix) {
        int tRow = 0, tCol = 0;
        int dRow = 0, dCol = 0;
        int endRow = matrix.length-1, endCol = matrix[0].length - 1;
        boolean upToDown = true;
        while (tRow <= endRow){
            printLevel(matrix, tRow, tCol, dRow, dCol, upToDown);
            tRow = (tCol == endCol) ? tRow+1 : tRow;
            tCol = (tCol == endCol) ? tCol : tCol+1;
            dCol = (dRow == endRow) ? dCol+1 : dCol;
            dRow = (dRow == endRow) ? dRow : dRow+1;
            upToDown = !upToDown;
        }
    }

    public static void printLevel(int[][] m, int tRow, int tCol, int dRow, int dCol,
                                  boolean upToDown) {
        if (upToDown){
            while (tRow <= dRow){
                System.out.print(m[tRow++][tCol--] + " ");
            }
            System.out.print("\n");
        } else {
            while (dRow >= tRow){
                System.out.print(m[dRow--][dCol++] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);
    }
}
