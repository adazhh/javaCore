package algorithmBuck.sort;

import java.util.Arrays;

public class S00HeapSort {
    // 如果用户直接一次给很多个元素，可以看作是一颗完全二叉树，只需要调用heapify
    // 叶子节点可以看作是满二叉树了，从倒数第二层开始计算 时间复杂度O(N)
    // 建立堆的时间复杂度是O(N*logN)
    public static void heapSort(int[] arr){
        if (arr == null && arr.length < 2){
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        while (size > 1){
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }

    // 0...index-1已经是堆了，把index的数加入到堆中
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]){
            swap(arr, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }
    // 某个数在index位置，看能否可以往下沉，不断和左右孩子比较
    private static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size){
            int largest = (left+1<size && arr[left+1] > arr[left]) ?
                    left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (index == largest){
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }


    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
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

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }

}
