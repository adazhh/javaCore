package algorithmBuck;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        String s = scanner.next();
        int col = s.length();
        int[][] arr = new int[row][col];
        for (int j = 0; j < col; j++) {
            arr[0][j] = s.charAt(j) - '0';
        }
        for (int i = 1; i < row; i++) {
            s = scanner.next();
            for (int j = 0; j < col; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(arr[i]));;
        }
    }
}
