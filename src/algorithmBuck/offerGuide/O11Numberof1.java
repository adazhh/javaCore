package algorithmBuck.offerGuide;

// 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
public class O11Numberof1 {
    public static void main(String[] args) {
        O11Numberof1 numb = new O11Numberof1();
        System.out.println(numb.solution1(-10));
        System.out.println(numb.solution2(-10));
    }
    // 最优解
    public int solution1(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }
    // 解2
    public int solution2(int n){
        int count = 0;
        int flag = 1;
        while (flag != 0){
            if ((n&flag) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
