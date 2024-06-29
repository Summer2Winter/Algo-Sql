import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, Q;
    static long[] num;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int start, end;
    static StringTokenizer st;
    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {

        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) graph[i] = new ArrayList<>();

        num = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) num[i] = Integer.parseInt(st.nextToken());

        for (int j = 0; j < N-1; j++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < Q; i++) {

            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            bfs(start, end);
        }
    }

    private static void bfs(int start, int end) {
        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{start, num[start]});
        visited = new boolean[N + 1];
        visited[start] = true;

        while (!queue.isEmpty()) {
            long[] qPoll = queue.poll();
            int now = (int) qPoll[0];
            long joinNum = qPoll[1];

            if (now == end) {
                System.out.println(joinNum % MOD);
                return;
            }

            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    int nextDigits = (int) (Math.log10(num[next]) + 1); // 자릿수
                    long nextJoinNum = (joinNum * pow10(nextDigits) % MOD + num[next]) % MOD; // 큰 수 관리가 힘드니깐 계속 % MOD
                    queue.add(new long[]{next, nextJoinNum});
                }
            }
        }
    }

    private static long pow10(int exp) { // 이어 붙이기 위해 자릿수 만큼 10 제곱하는 함수.
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result = (result * 10) % MOD;
        }
        return result;
    }
}