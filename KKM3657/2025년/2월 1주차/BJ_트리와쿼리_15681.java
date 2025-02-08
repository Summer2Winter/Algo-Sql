import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Node {
    int node;
    ArrayList<Integer> list = new ArrayList<>();

    Node(int node) {
        this.node = node;
    }
}
public class Main {
    static int N,Q;
    static Node[] tree;
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

        tree = new Node[N+1];
        for(int i=1; i<=N; i++)
            tree[i] = new Node(i);

        for(int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            tree[s].list.add(e);
            tree[e].list.add(s);
        }

        // root 부터 후위 순위로 전체 개수 탐색
        visited[root] = true;
        postOrder(root);

        // 쿼리
        for(int i=0; i<Q; i++){
            System.out.println(answerArr[Integer.parseInt(br.readLine())]);
        }
    }

    public static int postOrder(int curr) {
        ArrayList<Integer> child = tree[curr].list;
        // 리프노드이면 돌아감
        if(child.size() == 1) {
            answerArr[curr] = 1;
            return 1;
        }
        // 현재 위치
        int result = 1;
        // 자식 이동
        for(int next : child) {
            // 이미 방문했으면 넘어감
            if(visited[next])
                continue;
            visited[next] = true;
            result += postOrder(next);
        }
        answerArr[curr] = result;
        return result;
    }
}