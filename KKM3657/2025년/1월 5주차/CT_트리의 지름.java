import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int node;
    int distance;

    Node(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
public class Main {
    static int N, curr;
    static int distance;
    static boolean[] visited;
    static ArrayList<Node>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];

        // 트리 초기화
        for(int i=0; i<=N; i++)
            tree[i] = new ArrayList<>();

        for(int i=1; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 정점
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[s].add(new Node(e,v));
            tree[e].add(new Node(s,v));
        }

        // 현재 정점에서 최대 길이 구하기
        visited = new boolean[N+1];
        findAnswer(1, 0);

        // 다음 최대 길이 구하기
        visited = new boolean[N+1];
        findAnswer(curr, 0);

        int answer = distance;
        System.out.println(answer);
    }

    public static void findAnswer(int currN, int temp) {
        // 길이가 더 긴 경우
        if(distance < temp) {
            distance = temp;
            curr = currN;
        }

        visited[currN] = true;

        // 현재 위치에서 연결된 다른 노드로 이동
        for(Node next : tree[currN]) {
            if(!visited[next.node])
                // 저장
                findAnswer(next.node, temp + next.distance);
        }
    }
}
