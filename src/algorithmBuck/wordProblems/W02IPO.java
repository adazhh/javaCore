package algorithmBuck.wordProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class W02IPO {
    public static class Node {
        public int profits;
        public int costs;

        public Node(int profits, int costs) {
            this.profits = profits;
            this.costs = costs;
        }
    }
    // count表示最多做的项目，begin初始资金，profit纯利润
    public static int findMaxmizedCapital(int count, int funds, int[] profits, int[] capital){
        Node[] nodes = new Node[profits.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(profits[i], capital[i]);
        }
        PriorityQueue<Node> minCostsQue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.costs - o2.costs;
            }
        });
        PriorityQueue<Node> maxProfitsQue = new PriorityQueue<>(new Comparator<Node>() { // 大根堆
            @Override
            public int compare(Node o1, Node o2) {
                return o2.profits - o1.profits;
            }
        });
        for (int i = 0; i < nodes.length; i++) {
            minCostsQue.add(nodes[i]);
        }
        for (int i = 0; i < count; i++) {
            if (!minCostsQue.isEmpty() && minCostsQue.peek().costs <= funds){
                maxProfitsQue.add(minCostsQue.poll());
            }
            if (maxProfitsQue.isEmpty()){
                return funds;
            }
            funds += maxProfitsQue.poll().profits;
        }
        return funds;
    }

}
