package algorithmBuck.dataStructure;

import algorithmBuck.dataStructure.D02GraphStru.Node;

import java.util.HashSet;
import java.util.LinkedList;

public class D03GraphBFS {
    public static void bfs(Node node){
        if (node == null){
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.print(cur.value + " ");
            for (Node next : cur.nexts){
                if (!set.contains(next)){
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }
}
