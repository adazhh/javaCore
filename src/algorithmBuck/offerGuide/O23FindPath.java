package algorithmBuck.offerGuide;

import java.util.ArrayList;

public class O23FindPath {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {

        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> cur=new ArrayList<>();
        if (root == null) return listAll;
        recFind(root, target);
        return listAll;
    }
    private void recFind(TreeNode root, int target){
        if (root == null) return;
        target -= root.val;
        list.add(root.val);
        if ((target == 0) && (root.left == null) && (root.right == null)){
            listAll.add(new ArrayList<>(list));
        }
        recFind(root.left, target);
        recFind(root.right, target);
        list.remove(list.size()-1);
    }
    // public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    //
    //     if (root == null) return listAll;
    //     list.add(root.val);
    //     target -= root.val;
    //     if ((target == 0) && (root.left == null) && (root.right == null)){
    //         listAll.add(list);
    //     }
    //     FindPath(root.left, target);
    //     FindPath(root.right, target);
    //     list.remove(list.size()-1);
    //     return listAll;
    // }
    private class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
