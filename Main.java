import java.util.PriorityQueue;
import java.util.LinkedList;

public class Main {

    static int[] dijkstra(LinkedList<Edge>[] g, int n, int s){
        boolean[] vis = new boolean[n];
        int[] dist = new int[n];

        for (int i = 0; i < n; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> (a.value - b.value));
        pq.add(new Node(s, 0));

        while (pq.size() != 0){
            int index = pq.poll().index;
            vis[index] = true;
            for (Edge edge: g[index]){
                if (vis[edge.to]){
                    continue;
                }

                int newDist = dist[index] + edge.cost;

                if (newDist < dist[edge.to]){
                    dist[edge.to] = newDist;
                    pq.add(new Node(edge.to, newDist));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
	// write your code here
        LinkedList<Edge>[] graph = new LinkedList[5];
        graph[0] = new LinkedList<Edge>();
        graph[0].add(new Edge(1, 4));
        graph[0].add(new Edge(2, 1));

        graph[1] = new LinkedList<Edge>();
        graph[1].add(new Edge(3, 1));
        graph[1].add(new Edge(0, 4));
        graph[1].add(new Edge(2, 2));

        graph[2] = new LinkedList<Edge>();
        graph[2].add(new Edge(0, 1));
        graph[2].add(new Edge(1, 2));
        graph[2].add(new Edge(3, 5));

        graph[3] = new LinkedList<Edge>();
        graph[3].add(new Edge(1, 1));
        graph[3].add(new Edge(2, 5));
        graph[3].add(new Edge(4, 3));

        graph[4] = new LinkedList<Edge>();
        graph[4].add(new Edge(3, 3));

        int[] result = dijkstra(graph, 5, 0);

        for (int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }
}
