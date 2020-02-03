package algorithm.arrayIndex;

public class A02BinarySearchLeft {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,6};
        System.out.println(bianrySearchLeft(arr, 0));
    }
    // 在该方法中，若数组中有该元素能正确返回该元素最左侧，如果没有，返回第一个大于该数的
    // target小于最小值返回0，大于最大值返回length
    // <target的元素有多少个，第一个>=target
    public static int bianrySearchLeft(int[] arr, int target){
        if (arr == null) {
            return -1;
        }
        int left = 0, right = arr.length - 1;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if (arr[mid] >= target){
                right = mid - 1;
            }else if (arr[mid] < target){
                left = mid + 1;
            }
        }
        return left;
        // 如果要返回第一个出现的target，没有则返回-1的话如下
        // return arr[left] == target ? left : -1;
    }
}
