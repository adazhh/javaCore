package algorithm.dataStructure;

import algorithm.dataStructure.D02GraphStru.Node;
import algorithm.dataStructure.D02GraphStru.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class D05GraphTologySort {
    public static List<Node>  tologySort(Graph graph){
        HashMap<Node, Integer> inMap = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        for (Node node : graph.nodes.values()){
            inMap.put(node, node.in);
            if (node.in == 0){
                queue.add(node);
            }
        }
        List<Node> result = new LinkedList<>();
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next)-1);
                if (inMap.get(next) == 0){
                    queue.add(next);
                }
            }
        }
        return result;
    }
}
