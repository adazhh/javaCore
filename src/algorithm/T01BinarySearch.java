package algorithm;

public class T01BinarySearch {
    // 最基本的二分查找
    public int binarySearch1(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1; // 注意
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }
    public int binarySearchLeft(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                right = mid - 1;
            } else if (nums[mid] < target){
                left = mid+1;
            } else if (nums[mid] > target){
                right = mid - 1;
            }
        }
        return nums[left]==target ? left:-1;
    }
    public int binarySearchRight(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                left = mid + 1;
            } else if (nums[mid] < target){
                left = mid+1;
            } else if (nums[mid] > target){
                right = mid - 1;
            }
        }
        return nums[right]==target ? right:-1;
    }

}
