package algorithm.recursionAndDynamic;

public class R09CoinsWay {
    // 方法一：使用递归的方式的到结果
    public static int coinsWay1(int[] arr, int aim){
        if (arr == null || arr.length < 1 || aim < 0){
            return 0;
        }
        return process1(arr, 0, aim);
    }
    private static int process1(int[] arr, int index, int aim){
        if (index == arr.length){
            return aim==0 ? 1 : 0;
        }
        int res = 0;
        for (int i = 0; i * arr[index] <= aim; i++) {
            res += process1(arr, index+1, aim - i * arr[index]);
        }
        return res;
    }
}
