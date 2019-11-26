package algorithm.offerGuide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class O31PrintMinNumber {
    public static void main(String[] args) {
        O31PrintMinNumber printMinNumber = new O31PrintMinNumber();
        System.out.println(printMinNumber.PrintMinNumber(new int[]{5, 51, 12, 3, 32, 321}));
    }
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        ArrayList<Integer> list = new ArrayList<>(numbers.length);
        for (int i : numbers) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder builder = new StringBuilder();
        for (Integer i : list) {
            builder.append(i);
        }
        return builder.toString();
    }
}
