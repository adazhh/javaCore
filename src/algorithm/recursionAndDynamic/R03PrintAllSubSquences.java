package algorithm.recursionAndDynamic;

import java.util.LinkedList;
import java.util.List;

public class R03PrintAllSubSquences {
    public static void printAllSubSquences(String str){
        if (str == null) return;
        if (str.length() == 1){
            System.out.println("");
            return;
        }
        List<String> list = new LinkedList<>();
        char[] chars = str.toCharArray();
        process(chars, "", 0, list);
        for (String s : list) {
            System.out.println(s);
        }
    }
    public static void process(char[] chars, String path, int index, List<String> list){
        if (index == chars.length){
            list.add(path);
            return;
        }
        process(chars, path, index+1, list);
        path += chars[index];
        process(chars, path, index+1, list);
    }

    public static void main(String[] args) {
        System.out.println("所有字符串如下： ");
        printAllSubSquences("abc");
    }
}
