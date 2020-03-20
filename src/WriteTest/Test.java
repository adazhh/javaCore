package WriteTest;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        for (int i = 0; i < 3; i++) {
            System.out.println(list.pollFirst());
        }
    }
}
