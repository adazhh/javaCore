package algorithmBuck.offerGuide;

import java.util.ArrayList;
import java.util.Collections;

public class O28Permutation {
    public static void main(String[] args) {
        O28Permutation per = new O28Permutation();
        ArrayList<String> list = per.Permutation("a");
        System.out.println(list.toString());
    }
    private ArrayList<String> list = new ArrayList<String>();
    public ArrayList<String> Permutation(String str) {
        if (str != null && str.length() > 0) {
            curPermutation(str.toCharArray(), 0);
            Collections.sort(list);
        }
        return list;
    }
    private void curPermutation(char[] chars, int i){
        // 当i为最后一个元素的时候跳出来
        if ( i == chars.length-1) {
            String val = String.valueOf(chars);
            if (!list.contains(val)){
                list.add(val);
            }
            return;
        } else {
            for (int j=i; j<chars.length; ++j){
                swap(chars, i, j);
                curPermutation(chars, i+1);
                swap(chars, i, j);
            }
        }
    }
    private void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
