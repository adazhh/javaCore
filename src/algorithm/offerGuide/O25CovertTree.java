package algorithm.offerGuide;

public class O25CovertTree {
    public TreeNode listHead;
    public TreeNode node;
    public TreeNode Convert(TreeNode pRootOfTree) {
        covertSub(pRootOfTree);
        return listHead;
    }
    private void covertSub(TreeNode treeNode){
        if (treeNode == null) return;
        covertSub(treeNode.left);
        if (node == null){
            node = treeNode;
            listHead = treeNode;
        } else {
            node.right = treeNode;
            treeNode.left = node;
            node = treeNode;
        }
        covertSub(treeNode.right);
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
