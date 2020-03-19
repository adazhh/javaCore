package demo;

public class D13OddTimesNum {
    public static int[] getOddTimesNums(int[] arr){
        if (arr == null) return null;
        int eO = 0;
        for (int i : arr) {
            eO ^= i;
        }
        int rightOne = (eO & (~eO + 1));
        int eo2 = 0;
        for (int i : arr){
            if ((i & rightOne) != 0){
                eo2 ^= i;
            }
        }
        return new int[]{eo2, eO^eo2};
    }
}
