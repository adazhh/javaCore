package algorithm.offerGuide;

/**
 * 使用while循环进行二分查找
 */
public class O36GetNumOfK {
    public static void main(String[] args) {
        O36GetNumOfK getNum = new O36GetNumOfK();
        int[] arr = {1,2,3,3,3,3};
        int i = getNum.GetNumberOfK(arr, 3);
        System.out.println(i);
    }
    public int GetNumberOfK(int [] array , int k) {
        int firstK = binarySearchLeft(array, k);
        int lastK = binarySearchRight(array, k);
        if (firstK != -1 && lastK != -1){
            return lastK-firstK+1;
        }
        return 0;
    }
    public int binarySearchLeft(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int mid = (left + right) >> 1;
        while (left <= right){
            if (nums[mid] > target){
                right = mid + 1;
            } else if (nums[mid] < target){
                left = mid-1;
            } else if (mid-1>=0 && nums[mid-1] == target){
                right = mid - 1;
            } else {
                return mid;
            }
            mid = (left + right) >> 1;
        }
        return -1;
    }
    public int binarySearchRight(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int mid = (left + right) >> 1;
        while (left <= right){
            if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else if (mid+1 < nums.length && nums[mid+1] == target){
                left = mid + 1;
            } else {
                return mid;
            }
            mid = (left + right) >> 1;
        }
        return -1;
    }

}
