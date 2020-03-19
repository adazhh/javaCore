package algorithm.tree;

public class T10MaxDistance {
    private static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    private static class returnType{
        public int height;
        public int size;

        public returnType(int height, int size) {
            this.height = height;
            this.size = size;
        }
    }
    public static int getMaxDistance(Node head){
        return process(head).size;
    }
    private static returnType process(Node head){
        if (head == null){
            return new returnType(0, 0);
        }
        returnType leftInfo = process(head.left);
        returnType rightInfo = process(head.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int maxSize = Math.max(leftInfo.size, rightInfo.size);
        maxSize = Math.max(maxSize,
                leftInfo.height + 1 + rightInfo.height);
        return new returnType(height, maxSize);
    }
}
