package algorithmBuck.recursionAndDynamic;

public class R01Fibonacci {
    public static int Fibonacci(int n){
        /**
         *         if (n < 1) return 0;
         *         if (n == 1 || n == 2){
         *             return 1;
         *         }
         *         return Fibonacci(n-1) + Fibonacci(n-2);
         *
         */
        if (n < 1) return 0;
        if (n == 1 || n == 2){
            return 1;
        }
        int res = 1;
        int pre = 1;
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }
}
