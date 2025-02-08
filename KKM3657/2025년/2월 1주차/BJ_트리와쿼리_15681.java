import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static int N,Q;
    static ArrayList<Integer>[] tree;
    static int[] answerArr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        answerArr = new int[N+1];
        visited = new boolean[N+1];
        tree = new ArrayList[N+1];

        for(int i=1; i<=N; i++)
            tree[i] = new ArrayList<>();

        for(int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            tree[s].add(e);
            tree[e].add(s);
        }

        // root 부터 후위 순위로 전체 개수 탐색
        postOrder(root);

        // 쿼리 처리
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            sb.append(answerArr[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.print(sb);
    }

    public static int postOrder(int curr) {

        visited[curr] = true;
        // 현재 위치
        int result = 1;

        // 자식 이동
        for(int next : tree[curr]) {
            // 이미 방문했으면 넘어감
            if(!visited[next])
                result += postOrder(next);
        }
        answerArr[curr] = result;
        return result;
    }
}