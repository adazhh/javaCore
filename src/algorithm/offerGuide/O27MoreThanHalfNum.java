package algorithm.offerGuide;

public class O27MoreThanHalfNum {
    public static void main(String[] args) {
        O27MoreThanHalfNum halfNum = new O27MoreThanHalfNum();
        int[] arr = new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(halfNum.MoreThanHalfNum_Solution(arr));
        System.out.println(halfNum.MoreThanHalfNum_Solution(new int[]{4,2,4,1,4,2}));
    }
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length <= 0) return 0;
        if (array.length == 1) return array[0];
        int temp = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == temp){
                times++;
            } else {
                if (times-- == 0){
                    temp = array[i];
                    times++;
                }
            }
        }
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (temp == array[i]){
                num++;
            }
        }
        return (num > array.length/2) ? temp:0;
    }
}
