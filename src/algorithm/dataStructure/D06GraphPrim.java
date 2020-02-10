package algorithm.dataStructure;

import algorithm.dataStructure.D02GraphStru.Edge;
import algorithm.dataStructure.D02GraphStru.Graph;
import algorithm.dataStructure.D02GraphStru.Node;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class D06GraphPrim {

    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }

    }

    public static Set<Edge> primMST(Graph graph) {
        // 解锁的边进去小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(
                new EdgeComparator());
        HashSet<Node> set = new HashSet<>();
        Set<Edge> result = new HashSet<>(); // 依次挑选的边在resutl里
        for (Node node : graph.nodes.values()) { // 随便挑了一个点
            if (!set.contains(node)) {
                set.add(node);
                for (Edge edge : node.edges) { // 由一个点，解锁所有相连的边
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll(); // 弹出的边中，最小的边
                    Node toNode = edge.to; // 可能的一个点
                    if (!set.contains(toNode)) { // 不含有的时候，就是新的点
                        set.add(toNode);
                        result.add(edge);
                        for (Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return result;
    }
}
