import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static Set<Integer> friends = new HashSet<>();

    static StringTokenizer st;
    static int answer;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        graph = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(0, 1);

        System.out.println(friends.size() == 0 ? 0 : friends.size()-1);
    }

    private static void dfs(int depth, int now) {

        if (depth == 2) {
            return;
        }

        for(int next : graph[now]) {
            friends.add(next);
            dfs(depth+1, next);
        }
    }
}