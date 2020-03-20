package algorithmBuck.arrayIndex;

public class A01BinarySearch {
    public static int binarySearch(int[] arr, int target){
        if (arr == null) return -1;
        int left = 0, right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target){
                left = mid + 1;
            }else if (arr[mid] > target){
                right = mid - 1;
            }
        }
        return -1;
    }
    /**
     *为什么 while 循环的条件中是 <=，而不是 < ？
     因为初始化 right 的赋值是 nums.length - 1，即最后一个元素的索引，而不是 nums.length。
     这二者可能出现在不同功能的二分查找中，区别是：前者相当于两端都闭区间 [left, right]，
     后者相当于左闭右开区间 [left, right)，因为索引大小为 num；如果是length则用<，length-1用<=
     */
}
