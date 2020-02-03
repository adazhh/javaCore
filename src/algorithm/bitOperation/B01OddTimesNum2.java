package algorithm.bitOperation;

public class B01OddTimesNum2 {
    public static void printOddTimesNums2(int[] arr){
        int eO = 0;
        for (int i : arr) {
            eO ^= i; // eO最终等于两个奇数的异或，必定不是0，必定有一个位置是1
        }
        int rightOne = eO & (~eO + 1); // 得到最右的1
        int onlyOne = 0;
        for (int i : arr) {
            if ((i & rightOne) != 0){
                onlyOne ^= i;
            }
        }
        System.out.println(onlyOne + "and " + (onlyOne ^ eO));
    }
}
