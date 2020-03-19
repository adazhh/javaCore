package demo;

public class D05PrintEdge {
    public static void printRotateMtrix(int[][] arr){
        if (arr == null) return;
        int leftRow = 0, leftCol = 0;
        int rightRow = arr.length - 1, rightCol = arr[0].length - 1;
        while (leftRow <= rightRow && leftCol <= rightCol){
            printEdge(arr, leftRow++, leftCol++, rightRow--, rightCol--);
            System.out.println("");
        }
    }
    private static void printEdge(int[][] arr, int leftRow, int leftCol,
                                  int rightRow, int rightCol){
        if (leftRow == rightRow){
            while (leftCol <= rightCol){
                System.out.print(arr[leftRow][leftCol++] + " ");
            }
        }else if (leftCol == rightCol){
            while (leftRow <= rightRow){
                System.out.print(arr[leftRow++][leftCol] + " ");
            }
        }else {
            int curRow = leftRow;
            int curCol = leftCol;
            while (curCol != rightCol) {
                System.out.print(arr[leftRow][curCol++] + " ");
            }
            while (curRow != rightRow){
                System.out.print(arr[curRow++][rightCol] + " ");
            }
            while (curCol != leftCol){
                System.out.print(arr[rightRow][curCol--] + " ");
            }
            while (curRow != leftRow){
                System.out.print(arr[curRow--][leftCol] + " ");
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }};
        printRotateMtrix(matrix);
    }
}
