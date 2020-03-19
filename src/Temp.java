import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public class Temp {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int res = 0;
        String[] strings = new String[input.length()];
        char[] chars = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            strings[i] = String.valueOf(chars[i]);
        }
        res = process1(strings);
        System.out.println(res);

    }
    private static int process1(String[] chars){
        int res = 0;

        res += process2(chars, 1);
        res += process2(chars, 2);
        int temp = Integer.valueOf(chars[0]+chars[1]+chars[2]);
        if (temp <= 180){
            res += process2(chars, 3);
        }
        return res;
    }
    private static int process2(String[] chars, int index){
        int res = 0;
        res += process3(chars, index+1);
        int temp = Integer.valueOf(chars[index] + chars[index+1]);
        if (temp <= 90){
            res += process3(chars, index+2);
        }
        return res;
    }
    private static int process3(String[] chars, int index){
        StringBuilder builder = new StringBuilder();
        for (int i = index; i < chars.length; i++) {
            builder.append(chars[index]);
        }
        int temp = Integer.valueOf(builder.toString());
        if (temp < 3000){
            return 1;
        }else {
            return 0;
        }
    }
    private static int process(char[] chs, int i){
        if (i == chs.length){
            return 1;
        }
        if (chs[i] == '0'){
            return 0;
        }
        if (chs[i] == '1'){
            int res = process(chs, i+1);
            if (i + 1 < chs.length){
                res += process(chs, i+2);
            }
            return res;
        }
        if (chs[i] == '2'){
            int res = process(chs, i+1);
            if (i+1<chs.length && chs[i] <= 6){
                res += process(chs, i+2);
            }
            return res;
        }
        return process(chs, i+1);
    }
   public void ss(){
       System.out.println("hhh");
   }
}
