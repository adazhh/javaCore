package algorithmBuck.arrayIndex;

public class A05PrintMatrixSpiralOrder {
    public static void printRotateMtrix(int[][] matrix){
        int tRow = 0;
        int tCol = 0;
        int dRow = matrix.length - 1;
        int dCol = matrix[0].length - 1;
        while (tRow <= dRow && tCol <= dCol){
            printEdge(matrix, tRow++, tCol++, dRow--, dCol--);
        }
    }
    private static void printEdge(int[][] matrix, int tRow, int tCol, int dRow, int dCol){
        if (tRow == dRow){
            for (int i = tCol; i <= dCol; i++){
                System.out.println(matrix[tRow][i] + " ");
            }
        } else if (tCol == dCol){
            for (int i = tRow; i <= dRow ; i++) {
                System.out.println(matrix[i][tCol] + " ");
            }
        } else {
            int curRow = tRow;
            int curCol = tCol;
            while (curCol != dCol){
                System.out.println(matrix[tRow][curCol]);
                curCol++;
            }
            while (curRow != dRow){
                System.out.println(matrix[curRow][dCol]);
                curRow++;
            }
            while (curCol != tCol){
                System.out.println(matrix[dRow][curCol]);
                curCol--;
            }
            while (curRow != tRow){
                System.out.println(matrix[curRow][tCol]);
                curRow--;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }};
        printRotateMtrix(matrix);

    }
}
