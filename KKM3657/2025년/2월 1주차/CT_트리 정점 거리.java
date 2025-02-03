import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Node {
    int node;
    int distance;

    Node(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
public class Main {
    static int N, end, answer;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++)
            graph[i] = new ArrayList<>();

        for(int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e,v));
            graph[e].add(new Node(s,v));
        }

        // 구간
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            answer = 0;
            visited = new boolean[N+1];
            visited[s] = true;
            dfs(s, 0);
            System.out.println(answer);
        }
    }
    public static void dfs(int curr, int distance) {
        // 현재 노드
        if(curr == end) {
            answer = distance;
            return;
        }
        for(Node next : graph[curr]) {
            if(visited[next.node])
                continue;
            visited[next.node] = true;
            dfs(next.node, distance + next.distance);
        }
    }
}