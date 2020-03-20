package algorithmBuck.arrayIndex;

public class A03FindInDoubleArray {
    public static boolean findInDouArray(int[][] array, int target){
        if (array == null) return false;
        int row = 0, col = array[0].length - 1;
        while (row < array.length && col > -1){
            if (array[row][col] == target) return true;
            else if (array[row][col] < target){
                row++;
            }else if (array[row][col] > target){
                col--;
            }
        }
        return false;
    }
}
