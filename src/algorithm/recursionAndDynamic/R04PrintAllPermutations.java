package algorithm.recursionAndDynamic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class R04PrintAllPermutations {
    public static void printAllP(String str){
        if (str == null) return;
        if (str.length() == 1){
            System.out.println("");
            return;
        }
        ArrayList<Character> chars = new ArrayList<>();
        List<String> list = new LinkedList<>();
        for (char c : str.toCharArray()) {
            chars.add(c);
        }
        process(chars, "", list);
        for (String s : list) {
            System.out.println(s);
        }
    }
    public static void process(ArrayList<Character> chars, String path, List<String> list){
        if (chars.isEmpty()){
            list.add(path);
            return;
        }
        HashSet<Character> picks = new HashSet<>();
        for (int i = 0; i < chars.size(); i++) {
            if (!picks.contains(chars.get(i))){
                picks.add(chars.get(i));
                String pick = path + chars.get(i);
                ArrayList<Character> next = new ArrayList<>(chars);
                next.remove(i);
                process(next, pick, list);
            }
        }
    }

    public static void main(String[] args) {
        printAllP("aba");
    }
}
