package algorithm.offerGuide;

public class O23verifySquenceOfBSt {
    public static void main(String[] args) {
        O23verifySquenceOfBSt ofBSt = new O23verifySquenceOfBSt();
        // System.out.println(ofBSt.VerifySquenceOfBST(new int[]{5,4,3,2,1}));
        System.out.println(ofBSt.VerifySquenceOfBST(new int[]{7,4,6,5}));
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        // 没有元素时直接返回false，只有一个返回true
        if (sequence.length == 0) return false;
        if (sequence.length == 1) return true;
        return reVerify(sequence, 0, sequence.length - 1);
    }
    private boolean reVerify(int[] sequence, int start, int root){
        if (start >= root) return true;
        int index = start;
        while (sequence[index] < sequence[root]){
            index++;
        }
        int i = index;
        while (i < root){
            if (sequence[i] < sequence[root]){
                return false;
            }
            i++;
        }
        return reVerify(sequence, start, index-1) && reVerify(sequence, index, root-1);
    }

}
