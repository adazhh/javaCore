package algorithm.offerGuide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class O13reOrderArray {
    public static void main(String[] args) {
        O13reOrderArray test = new O13reOrderArray();
        int[] array = {1,2,3,4,5,6,7};
        test.reOrderArray(array);
        System.out.println(Arrays.toString(array));


    }
    // 也可以用插入排序，时间复杂度为O(n^2)
    public void reOrderArray(int [] array) {
        int pointer = 0, cursor = array.length-1;
        int i = 0, j = array.length-1;
        int[] temp = new int[array.length];
        while (pointer<array.length){
            if ((array[pointer] & 1) == 1){
                temp[i++] = array[pointer];
            }
            pointer++;
        }
        while (cursor>=0){
            if ((array[cursor] & 1) == 0){
                temp[j--] = array[cursor];
            }
            cursor--;
        }
        for (i=0; i<array.length; i++){
            array[i] = temp[i];
        }
    }
}
