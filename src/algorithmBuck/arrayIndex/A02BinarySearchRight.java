package algorithmBuck.arrayIndex;

public class A02BinarySearchRight {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,6};
        System.out.println(bianrySearchLeft(arr, 0));
    }
    // 在该方法中，若数组中有该元素能正确返回该元素最右侧，如果没有，返回第一个小于该数的
    // target小于最小值返回-1，大于最大值返回length-1
    public static int bianrySearchLeft(int[] arr, int target){
        if (arr == null) {
            return -1;
        }
        int left = 0, right = arr.length-1;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if (arr[mid] <= target){
                left = mid + 1;
            }else if (arr[mid] > target){
                right = mid - 1;
            }
        }
        return right;
    }
}
