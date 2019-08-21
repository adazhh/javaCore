import java.util.HashMap;
import java.util.Iterator;

public class test {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("123", "aaa");
        hashMap.put("111", "bbb");
        hashMap.put("222", "ccc");
        hashMap.put("333", "ddd");

        Iterator iterator = hashMap.keySet().iterator();

        while (iterator.hasNext())
        {
            if (iterator.next()=="222"){
                iterator.remove();
            }
            System.out.println(hashMap.get(iterator.next()));
        }
    }
}
