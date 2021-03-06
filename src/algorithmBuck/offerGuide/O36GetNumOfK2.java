package algorithmBuck.offerGuide;

/**
 * 递归进行二分查找
 */
public class O36GetNumOfK2 {
    public int GetNumberOfK(int [] array , int k) {
        int length = array.length;
        if(length == 0){
            return 0;
        }
        int firstK = getFirstK(array, k, 0, length-1);
        int lastK = getLastK(array, k, 0, length-1);
        if(firstK != -1 && lastK != -1){
            return lastK - firstK + 1;
        }
        return 0;
    }
    //递归写法
    private int getFirstK(int [] array , int k, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end) >> 1;
        if(array[mid] > k){
            return getFirstK(array, k, start, mid-1);
        }else if (array[mid] < k){
            return getFirstK(array, k, mid+1, end);
        }else if(mid-1 >=0 && array[mid-1] == k){
            return getFirstK(array, k, start, mid-1);
        }else{
            return mid;
        }
    }
    private int getLastK(int [] array , int k, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (end - start) / 2 + start;
        if(array[mid] > k){
            return getLastK(array, k, start, mid-1);
        }else if (array[mid] < k){
            return getLastK(array, k, mid+1, end);
        }else if(mid+1 < array.length && array[mid+1] == k){
            return getLastK(array, k, mid+1, end);
        }else{
            return mid;
        }
    }
}
