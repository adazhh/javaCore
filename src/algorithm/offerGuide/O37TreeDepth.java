package algorithm.offerGuide;

import java.util.LinkedList;
import java.util.Queue;

public class O37TreeDepth {
    // 递归查找
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left, right) + 1;
    }
    public int treeDepth(TreeNode root){
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        int count = 0, nextCount = 1;
        while (queue.size() != 0){
            TreeNode node = queue.poll();
            count++;
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
            if (count == nextCount){
                depth++;
                count = 0;
                nextCount = queue.size();
            }
        }
        return depth;
    }
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;

        }
    }
}
