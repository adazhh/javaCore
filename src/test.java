import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(100);
        System.out.println(list.size());
        list.add(2, "hello");
    }
}
