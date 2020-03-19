package demo;

public class D03findInDoubleArray {
    public static boolean findInDouble(int[][] arr, int aim){
        if (arr == null || arr.length < 1 || arr[0] == null || arr[0].length < 1){
            return false;
        }
        int row = 0, col = arr[0].length - 1;
        while (row < arr.length && col > -1){
            if (arr[row][col] == aim){
                return true;
            }
            if (arr[row][col] < aim){
                row++;
            }else if (arr[row][col] > aim){
                col--;
            }
        }
        return false;
    }
}
