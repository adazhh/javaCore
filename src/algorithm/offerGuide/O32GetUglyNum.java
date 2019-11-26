package algorithm.offerGuide;

import java.util.ArrayList;

public class O32GetUglyNum {
    public static void main(String[] args) {
        O32GetUglyNum uglyNum = new O32GetUglyNum();
        System.out.println(uglyNum.GetUglyNumber_Solution(1));
    }
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        ArrayList<Integer> list = new ArrayList<>(index);
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (list.size() < index){
            int m2 = 2 * list.get(i2);
            int m3 = 3 * list.get(i3);
            int m5 = 5 * list.get(i5);
            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);
            if (m2 == min) i2++;
            if (m3 == min) i3++;
            if (m5 == min) i5++;
        }
        return list.get(index - 1);
    }
}
