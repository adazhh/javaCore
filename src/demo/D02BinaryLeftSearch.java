package demo;

public class D02BinaryLeftSearch {
    // 如果没有，则返回的是第一个大于它的数
    // aim<任何值，返回0
    // >任何值，返回length
    public static int leftSearch(int[] arr, int aim){
        if (arr == null){
            return -1;
        }
        int left = 0, right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] >= aim){
                right = mid - 1;
            }else if (arr[mid] < aim){
                left = mid + 1;
            }
        }
        return left;
    }
}
