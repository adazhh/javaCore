package algorithmBuck.arrayIndex;

public class A06RotateMatrix {
    public static void rotate(int[][] matrix){
        int tRow = 0, tCol = 0;
        int dRow = matrix.length - 1, dCol = matrix[0].length - 1;
        while (tRow < dRow){
            rotateEdge(matrix, tRow++, tCol++, dRow--, dCol--);
        }
    }
    public static void rotateEdge(int[][] matrix, int tRow, int tCol, int dRow, int dCol){
        int count = dCol - tCol; // 记录需要交换的次数
        int tmp = 0;
        for (int i = 0; i < count; i++) {
            tmp = matrix[tRow][tCol+i];
            matrix[tRow][tCol+i] = matrix[dRow-i][tCol];
            matrix[dRow-i][tCol] = matrix[dRow][dCol-i];
            matrix[dRow][dCol-i] = matrix[tRow+i][dCol];
            matrix[tRow+i][dCol] = tmp;
        }
    }
    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }
}
