package WriteTest;

import java.util.Collections;

public class Test01 {
    public static void main(String[] args) {
        String  line = "RLLR";
        int left, right;
        for (left = 0; left < line.length(); left++){
            if (line.charAt(left) == 'R')
                break;
        }
        for (right = line.length()-1; right >=0 ; right--){
            if (line.charAt(right) == 'L')
                break;
        }
        if (left < right){
            System.out.println("最少剩下：" + (line.length() - right + left));
        }else {
            System.out.println("最少剩下：" + line.length());
        }
    }
}
