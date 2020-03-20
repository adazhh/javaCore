package algorithmBuck.otherContinued;

import java.util.*;

public class O01BuildingOutline {
    public static class Node{
        public int huo;
        public List<Node> nexts;
        public Node(int huo){
            huo = huo;
        }
    }
    public static class returnType{
        public int lai_huo;
        public int bu_lai_huo;
        public returnType(int lai_huo, int bu_lai_huo) {
            this.lai_huo = lai_huo;
            this.bu_lai_huo = bu_lai_huo;
        }
    }
    public static returnType process(Node head){
        int lai = head.huo;
        int bu = 0;
        for (int i = 0; i < head.nexts.size(); i++) {
            Node next = head.nexts.get(i);
            returnType nextInfo = process(next);
            lai += nextInfo.bu_lai_huo;
            bu += Math.max(nextInfo.lai_huo, nextInfo.bu_lai_huo);
        }
        return new returnType(lai, bu);
    }
}
