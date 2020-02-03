package algorithm.bitOperation;

public class B01OddTimesNum {
    public static void printOddTimesNums(int[] arr){
        int e = 0;
        for (int i : arr) {
            e ^= i;
        }
        System.out.println(e);
    }


}
