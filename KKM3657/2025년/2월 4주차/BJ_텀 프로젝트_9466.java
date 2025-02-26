import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static int[] arr;
    static boolean[] visited, finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int task = Integer.parseInt(br.readLine());

        for (int t = 0; t < task; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[N + 1];  // 방문 여부 체크
            finished = new boolean[N + 1]; // 사이클 탐색 종료 여부 체크
            answer = 0;

            // 모든 노드에 대해 DFS 실행
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) { // 방문하지 않은 노드만 탐색
                    dfs(i);
                }
            }
            System.out.println(N - answer); // 팀을 이루지 못한 학생 수 출력
        }
    }

    public static void dfs(int curr) {
        visited[curr] = true; // 현재 노드 방문 체크
        int next = arr[curr]; // 다음 이동할 노드

        if (!visited[next]) { // 다음 노드를 방문한 적이 없다면 DFS 수행
            dfs(next);
        } else if (!finished[next]) { // 다음 노드가 팀을 만들지 않은 경우 사이클을 만날때 까지 시행
            int node = next;
            while (node != curr) { // 사이클을 만날때까지 과정 count;
                answer++;
                node = arr[node];
            }
            answer++; // 마지막 노드도 포함
        }

        finished[curr] = true; // 탐색 종료
    }
}
