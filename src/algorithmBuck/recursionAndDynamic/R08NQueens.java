package algorithmBuck.recursionAndDynamic;

public class R08NQueens {
    public static int num1(int N){
        if (N < 1) return 0;
        int[] record = new int[N];
        return process1(0, record, N);
    }
    public static int process1(int index, int[] record, int N){
        if (index == record.length){
            return 1;
        }
        int res = 0;
        for (int i = 0; i < record.length; i++) {
            if (isValid(index, record, i)){
                record[index] = i;
                res += process1(index+1, record, N);
            }
        }
        return res;
    }
    public static boolean isValid(int index, int[] record, int col){
        for (int i = 0; i < index; i++) {
            if (record[i] == col || Math.abs(record[i]-col) == index-i){
                return false;
            }
        }
        return true;
    }
    // 不要超过32皇后问题
    public static int num2(int n) {
        if (n < 1 || n > 32) return 0;
        int upperLim = (n==32)? -1 : (1 << n) - 1;
        return process2(upperLim, 0, 0, 0);
    }

    // upperLim表示可以使用的位数，也就是右边1的数量（N）
    // colLim表示不能使用的列，leftDiaLim不能使用的左对角线，这三个值的1位置表示不能使用
    public static int process2(int upperLim, int colLim, int leftDiaLim,
                               int rightDiaLim) {
       if (colLim == upperLim){
           return 1;
       }
       int pos = 0; // 表示可以使用的位置
       int mostRightOne = 0;
       // 现在转化成0位置是不能使用的
       pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
       int res = 0;
       while (pos != 0){
           mostRightOne = pos & (~pos + 1); // 求最右边的1
           pos = pos - mostRightOne;
           res += process2(upperLim, colLim | mostRightOne,
                   (leftDiaLim | mostRightOne) << 1,
                   (rightDiaLim | mostRightOne) >>> 1);
       }
        return res;
    }

    public static void main(String[] args) {
        int n = 14;

        long start = System.currentTimeMillis();
        System.out.println(num2(n));
        long end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(num1(n));
        end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");

    }
}
