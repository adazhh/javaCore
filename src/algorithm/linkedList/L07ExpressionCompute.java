package algorithm.linkedList;

import java.util.LinkedList;

public class L07ExpressionCompute {

    public static int getValue(String str) {
        return value(str.toCharArray(), 0)[0];
    }

    // 返回值为数组，0代表计算结果，1表示计算到的位置
    public static int[] value(char[] str, int i) {
        LinkedList<String> que = new LinkedList<String>();
        int pre = 0;
        int[] bra = null;
        while (i < str.length && str[i] != ')') { // 没遇到括号且没遇到终止条件
            if (str[i] >= '0' && str[i] <= '9') { // 收集数字，多位数
                pre = pre * 10 + str[i++] - '0';
            } else if (str[i] != '(') { // 遇到了+ - * /
                addNum(que, pre);
                que.addLast(String.valueOf(str[i++]));
                pre = 0;
            } else { //遇到了左括号
                bra = value(str, i + 1);
                pre = bra[0]; // 值
                i = bra[1] + 1; // 返回右括号的数字
            }
        }
        addNum(que, pre);
        return new int[] { getNum(que), i };
    }

    public static void addNum(LinkedList<String> que, int num) {
        if (!que.isEmpty()) {
            int cur = 0;
            String top = que.pollLast();
            if (top.equals("+") || top.equals("-")) {
                que.addLast(top);
            } else {
                cur = Integer.valueOf(que.pollLast());
                num = top.equals("*") ? (cur * num) : (cur / num);
            }
        }
        que.addLast(String.valueOf(num));
    }

    public static int getNum(LinkedList<String> que) {
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!que.isEmpty()) {
            cur = que.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }
}
