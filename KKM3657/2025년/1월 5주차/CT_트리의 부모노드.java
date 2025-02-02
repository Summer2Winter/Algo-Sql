import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree.get(s).add(e);
            tree.get(e).add(s);
        }

        int[] answer = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        // 루트 노드 1
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : tree.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    answer[next] = curr;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.print(sb);
    }
}
