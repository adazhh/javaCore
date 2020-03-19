import java.awt.geom.Ellipse2D;
import java.util.*;

public class test {
    public static void main(String[] args) {
        String str = "London bridge is falling down";
        char[] chars = str.toCharArray();
        int first = 0;
        int last = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' '){
                last = i - 1;
                reverse(chars, first, last);
                first = i+1;
            }
        }
        reverse(chars, first, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        System.out.println(Arrays.toString(chars));
    }
    private static void reverse(char[] s, int first, int last){
        if (first >= last) return;
        while (first < last){
            swap(s, first++, last--);
        }
    }
    private static void allSort(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        char[] s = str.toCharArray();

        permutation(s, 0, s.length - 1);
    }
    public static void permutation(char[] s,int from,int to) {
        if(to <= 1)
            return;
        if(from == to) {
            System.out.println(s);
        } else {
            for(int i=from; i<=to; i++) {
                swap(s,i,from); //交换前缀，使其产生下一个前缀
                permutation(s, from+1, to);
                swap(s,from,i); //将前缀换回，继续做上一个前缀的排列
            }
        }
    }
    public static void swap(char[] s,int i,int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
    private class ConstruTest{
    }
}
