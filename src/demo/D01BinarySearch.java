package demo;

public class D01BinarySearch {
    public static void main(String[] args) {

    }
    public static int binary(int[] arr, int aim){
        if (arr == null){
            return -1;
        }
        int left = 0, right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] == aim){
                return mid;
            } else if (arr[mid] < aim){
                left = mid+1;
            }else if (arr[mid] > aim){
                right = mid-1;
            }
        }
        return -1;
    }
}
