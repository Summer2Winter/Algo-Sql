import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        
        int v;
        int cost;
        
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        
        public int compareTo(Node o) {
             return this.cost - o.cost;
        }
    }
    
    static int N, M, S, T;

    static List<Node>[] graph;
    static StringTokenizer st;
    static boolean[] visited;
    static int[] dist;
    static final int INF = 100000000;

    public static void main(String[] args) throws Exception {

        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        dist = new int[N+1];
        dijkstra();

        System.out.println(dist[T]);
    }

    private static void dijkstra() {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(S, 0));
        Arrays.fill(dist, INF);
        dist[S] = 0;

        while (!pq.isEmpty()) {

            Node now = pq.poll();
            int v = now.v;

            if (visited[v]) continue;
            visited[v] = true;

            for (Node next : graph[v]) {

                if (dist[next.v] > dist[now.v] + next.cost) {

                    dist[next.v] = dist[now.v] + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}