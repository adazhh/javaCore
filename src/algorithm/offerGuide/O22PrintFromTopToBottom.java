package algorithm.offerGuide;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class O22PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        if (root == null) return list;
        nodes.add(root);
        while (nodes.size() != 0){
            TreeNode current = nodes.removeFirst();
            // TreeNode current = nodes.removeFirst();
            if (current.left != null){
                nodes.add(current.left);
            }
            if (current.right != null){
                nodes.add(current.right);
            }
            list.add(current.val);
        }
        return list;


    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
