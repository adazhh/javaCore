package algorithm.tree;

public class T05isBalanceTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static class returnData{
        public int high;
        public boolean isB;
        public returnData(boolean isB, int high){
            this.isB = isB;
            this.high = high;
        }
    }

    public static boolean isBalance(Node head){
        return process(head).isB;
    }

    public static returnData process(Node head){
        if (head == null){
            return new returnData(true, 0);
        }
        returnData leftData = process(head.left);
        if (leftData.isB == false){
            return new returnData(false, 0);
        }
        returnData rightData = process(head.left);
        if (rightData.isB == false){
            return new returnData(false, 0);
        }
        if (Math.abs(leftData.high - rightData.high) > 1){
            return new returnData(false, 0);
        }
        return new returnData(true, Math.max(leftData.high, rightData.high) + 1);
    }
}
