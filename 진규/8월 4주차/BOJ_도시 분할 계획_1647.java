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

    static int N, M;
    static List<Node>[] graph;
    static boolean[] visited;

    static StringTokenizer st;
    static List<Integer> costList = new ArrayList<>();
    static int answer;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        visited = new boolean[N+1];
        bfs(1);

        Collections.sort(costList);
        answer -= costList.get(costList.size() - 1);
        System.out.println(answer);
    }


    private static void bfs(int v) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(v, 0));

        while (!pq.isEmpty()) {

            Node node = pq.poll();
            int now = node.v;
            int cost = node.cost;

            if (visited[now]) continue;
            visited[now] = true;
            answer += cost;
            costList.add(cost);

            for (Node next : graph[now]) {

                if (!visited[next.v]) {
                    pq.add(next);
                }
            }
        }
    }
}