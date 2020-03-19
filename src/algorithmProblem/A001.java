package algorithmProblem;

import java.util.Arrays;
import java.util.Scanner;

public class A001 {
    private static int[] list;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            String[] strArr = input.split(";");
            list = new int[2];
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].length() > 1 && (strArr[i].charAt(0) == 'A' || strArr[i].charAt(0) == 'S'
                    || strArr[i].charAt(0) == 'W' || strArr[i].charAt(0) == 'D')){
                    if (strArr[i].length() == 2 && numValidity(strArr[i].charAt(1))){
                        addList(strArr[i]);
                    }
                    if (strArr[i].length() == 3 && numValidity(strArr[i].charAt(1)) &&
                    numValidity(strArr[i].charAt(2))){
                        addList(strArr[i]);
                    }
                }
            }
            System.out.println(list[0] + "," + list[1]);
        }
    }

    private static void addList(String s) {
        int num = Integer.valueOf(s.substring(1, s.length()));
        if (s.charAt(0) == 'A'){
            list[0] -= num;
        } else if (s.charAt(0) == 'S'){
            list[1] -= num;
        }else if (s.charAt(0) == 'W'){
            list[1] += num;
        }else if (s.charAt(0) == 'D'){
            list[0] += num;
        }
    }

    private static boolean numValidity(char num){
        int temp = num - '0';
        if (temp <= 9 && temp >= 0){
            return true;
        }else {
            return false;
        }
    }
}
