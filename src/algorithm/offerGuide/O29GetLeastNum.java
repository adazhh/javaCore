package algorithm.offerGuide;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

// 1. 可以用排序再选择前面几个数
// 2. 优先队列（优先队列基于堆实现） 23ms 9736k
public class O29GetLeastNum {
    public static void main(String[] args) {
        O29GetLeastNum num = new O29GetLeastNum();
        int[] arr = new int[]{1,6,9,3,2,7,100,2};
        ArrayList<Integer> list = num.GetLeastNumbers_Solution(arr, 4);
        System.out.println(list.toString());
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length < k || k == 0) return list;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (maxHeap.size() != k){
                maxHeap.offer(input[i]);
            } else if (input[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            list.add(integer);
        }
        return list;
    }

}
