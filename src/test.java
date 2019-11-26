import java.util.*;

public class test {
    public static void main(String[] args) {

        // ArrayList不能跨位置添加元素

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
        nuA(null);

        System.out.println("===========");
        Object o1 = new Object();
        // 集合不能用null来判断，要用empty()
        Stack<Object> stack = new Stack<>();
        if (stack == null){
            System.out.println("is null");
        }else {
            System.out.println("not null");
        }
    }
    public static void nuA(Integer integer){
        integer = integer * 2;
    }

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(2);
        Integer n = linkedList.removeFirst();
        if (linkedList.size() == 0) System.out.println("is empty");
        linkedList.add(3);
        linkedList.add(4);
        System.out.println(linkedList.toString());
    }
}
