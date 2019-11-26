package algorithm.offerGuide;

public class O30FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        O30FindGreatestSumOfSubArray maxSum = new O30FindGreatestSumOfSubArray();
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] arr1 = {-1, -2, -1, -1, -1, -2};
        System.out.println(maxSum.FindGreatestSumOfSubArray(arr));
        System.out.println(maxSum.FindGreatestSumOfSubArray(arr1));
    }    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length==0 || array==null) {
            return 0;
        }
        int curSum = 0;
        int greatestSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (curSum <= 0){
                curSum = array[i];
            } else {
                curSum += array[i];
            }
            if (curSum > greatestSum){
                greatestSum = curSum;
            }
        }
        return greatestSum;
    }
}
