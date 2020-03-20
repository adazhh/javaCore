package algorithmBuck.sort;

public class S04NetherlandsFlag {
    // 返回值的区域的左边界和右边界，两个整数
    // 如果无等于区域，返回值的左边界大于右边界
    public static int[] partition(int[] arr, int left, int right, int p){
        int less = left - 1;
        int more = right + 1;
        int index = left;
        while (index < more){
            if (arr[index] < p){
                // 把这个数加入边界的下一个格子
                swap(arr, ++less, index++);
            } else if (arr[index] > p){
                swap(arr, --more, index);
            }else if (arr[index] == p){
                index++;
            }
        }
        return new int[]{less + 1, more + 1};
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
        }
        return arr;
    }
    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test = generateArray();

        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 1);
        printArray(test);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
