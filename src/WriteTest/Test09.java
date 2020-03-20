package WriteTest;

import java.util.*;

public class Test09 {
    public static class Node{
        public int value;
        public int in;  // 入度
        public int out; // 出度
        public ArrayList<Node> nexts; // 出节点
        public ArrayList<Edge> edges; // 出的边集合
        public Node(int value){
            this.value = value;
            in = 0;
            out = 0;
            edges = new ArrayList<>();
            nexts = new ArrayList<>();
        }
    }
    public static class Node1{
        public int value;

    }
    public static class Edge{
        public int weight;
        public Node from;
        public Node to;
        public Edge(int weight, Node from, Node to){
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }
    public static class Graph{
        public HashMap<Integer, Node> nodes;
        public HashSet<Edge> edges;
        public Graph(){
            nodes = new HashMap<>();
            edges = new HashSet<>();
        }
    }
    public static Graph createGraph(Integer[][] matrix){
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            int weight = matrix[i][0];
            int from = matrix[i][1];
            int to = matrix[i][2];
            if (!graph.nodes.containsKey(from)){
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)){
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.edges.add(newEdge);
            fromNode.out++;
            toNode.in++;
            graph.edges.add(newEdge);
        }
        return graph;
    }

    /**
     * 5
     * 1,4,5,4
     * 5,1,2,3
     * 9,25,30,8
     * @param args
     */
    public static void main(String[] args) {
        solve();
    }
    private static void solve(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        int[][] arr = new int[n + 1][n + 1];
        int[][] help = new int[3][n-1];
        for (int i = 0; i < 3; i++) {
            String[] str = scanner.nextLine().split(",");
            for (int j = 0; j < str.length; j++) {
                help[i][j] = Integer.valueOf(str[j]);
            }
        }
        create(help, arr);
        printDouArr(help);
        printDouArr(arr);

    }
    private static void create(int[][] help, int[][] arr){
        for (int i = 0; i < help[0].length; i++) {
            int a = help[0][i];
            int b = help[1][i];
            arr[a][b] = help[2][i];
            arr[b][a] = help[2][i];
        }
    }
    private static void printDouArr(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
