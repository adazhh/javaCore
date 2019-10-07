import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class test {
    public static void main(String[] args) {
        // ArrayList<String> list = new ArrayList<>(100);
        // System.out.println(list.size());
        // list.add(2, "hello");

        String a  = "CAT";
        String b = a;
        a = a.toLowerCase();
        a.replace("c", "W");
        System.out.println(a);
        System.out.println(b);
        System.out.println(a==b);
        System.out.println(a.equals(b));
        System.out.println(a.toLowerCase());
        System.out.println(b.replace("C", "w"));
        System.out.println(b);

        System.out.println("--------------------");

        Integer i1 = 2;
        Integer i2 = i1;
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
        i1++;
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));

        System.out.println("===========");
        Object o1 = new Object();
    }
}
