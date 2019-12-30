package WriteTest;

import java.util.LinkedList;

public class LInkedTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(1, 12);

        System.out.println(list.size());
        System.out.println(list.toString());

    }
}
