import java.util.*;

public class test {
    public static void main(String[] args) {

        // ArrayList不能跨位置添加元素
        // ArrayList<String> list = new ArrayList<>(100);
        // System.out.println(list.size());
        // list.add(2, "hello");

        // 集合不能用null来判断，要用empty()
        Stack<Object> stack = new Stack<>();
        if (stack == null){
            System.out.println("is null");
        }else {
            System.out.println("not null");
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
