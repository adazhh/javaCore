package algorithmBuck.offerGuide;

import java.util.Stack;

public class O21isPopOrder {
    public static void main(String[] args) {
        int[] pushA = new int[]{12,23};
        O21isPopOrder order = new O21isPopOrder();
        System.out.println(order.IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        for (int j = 0; j < popA.length; ++j){
            int popNumb = popA[j];
            if (stack.isEmpty() || stack.peek() != popNumb){
                while (pushA[i] != popNumb){
                    stack.push(pushA[i++]);
                    if (i == pushA.length) return false;
                }
                if (i < 4){
                    i++;
                }
            }else {
                stack.pop();
            }
        }
        return true;
    }
}
