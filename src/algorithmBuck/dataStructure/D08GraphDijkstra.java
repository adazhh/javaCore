package algorithmBuck.dataStructure;

import algorithmBuck.dataStructure.D02GraphStru.Edge;
import algorithmBuck.dataStructure.D02GraphStru.Node;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class D08GraphDijkstra {
    public static HashMap<Node, Integer> dijkstra1(Node head) {
        // 此时从from出发到所有点的最小距离
        // key：从from出发到达的key
        // value：从from出发达到key的最小距离
        // 表中没有的记录表示从from出发到该点的距离为正无穷
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        // 已经求过距离的点，以后再也不用理
        HashSet<Node> selectedNodes = new HashSet<>();
        // 在需要解决的点中返回最小的值
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            // 此时的选的最小记录，from --- minNode
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                // 不包含表示正无穷，则必然需要更新
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                }
                // 选择更小的点
                distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap,
                                                       HashSet<Node> touchedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!touchedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}
