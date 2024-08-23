import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T;
    static int N;
    static int teamCnt;
    static int[] choose;
    static boolean[] visited;

    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            choose = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                choose[j] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[N+1];
            teamCnt = 0;
            for (int j = 1; j < N+1; j++) {

                if (!visited[j]) {
                    dfs(j, new ArrayList<>());
                }
            }

            System.out.println(N - teamCnt);
        }
    }

    private static void dfs(int now, List<Integer> list) {

        visited[now] = true;
        list.add(now);
        int next = choose[now];

        if (visited[next]) {
            if (list.contains(next)) {
                teamCnt += list.size() - list.indexOf(next);
            }
            return;
        }

        dfs(next, list);
    }
}