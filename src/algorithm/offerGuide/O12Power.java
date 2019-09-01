package algorithm.offerGuide;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 *
 * 解题关键：考虑到base和exponent的值 base=0，base
 */
public class O12Power {
    public static void main(String[] args) {
        O12Power test = new O12Power();
        System.out.println(test.power(2, 3));
    }
    public double power(double base, int exponent) {
        int n;
        if (exponent > 0){
            n = exponent;
        }else if (exponent == 0){
            if (base == 0) return 0;
            else return 1;
        }else { // exponent < 0
            n = -exponent;
        }
        double result = powerWithUnsigned2(base, n);
        return exponent > 0? result : 1/result;
    }
    private double powerWithUnsigned(double base, int n){
        if (n == 1){
            return base;
        }
        double result = powerWithUnsigned(base, n / 2);
        result *= result; // n为偶数的时候 a^n = a^(n/2) * a^(n/2)
        if ((n & 1) == 1){ // n为奇数的时候 a^n = a^(n-1/2) * a^(n-1/2) * a
            result *= base;
        }
        return result;
    }
    private double powerWithUnsigned2(double base, int n){
        int result = 1;
        while (n != 0){
            if ((n&1)==1){
                result *= base;
            }
            base *= base;
            n >>= 1;
        }
        return result;
    }
}
