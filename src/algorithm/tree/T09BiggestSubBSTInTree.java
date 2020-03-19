package algorithm.tree;

public class T09BiggestSubBSTInTree {
    private static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    private static class returnType{
        public int size;
        public Node head;
        public int max;
        public int min;

        public returnType(int size, Node head, int max, int min) {
            this.size = size;
            this.head = head;
            this.max = max;
            this.min = min;
        }
    }
    private static returnType process(Node head){
        if (head == null){
            return new returnType(0, null, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        returnType leftInfo = process(head.left);
        returnType rightInfo = process(head.right);

        int include = 0;
        if (leftInfo.head == head.left && rightInfo.head == head.right
                && leftInfo.max < head.value && rightInfo.min > head.value){
            include = leftInfo.size + rightInfo.size + 1;
        }
        int s1 = leftInfo.size;
        int s2 = rightInfo.size;
        int maxSize = Math.max(include, Math.max(s1, s2));
        Node headNode = (s1 > s2) ? leftInfo.head : rightInfo.head;
        if (maxSize == include){
            headNode = head;
        }
        return new returnType(maxSize, headNode,
                Math.max(leftInfo.max, rightInfo.max),
                Math.min(leftInfo.min, rightInfo.min));
    }
}
