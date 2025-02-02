import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Node {
    int node;
    ArrayList<Integer> child = new ArrayList<>();

    Node(int node) {
        this.node = node;
    }
}
public class Main {
    static int N, deleteNode, answer;
    static Node[] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 트리 생성
        tree = new Node[N];
        for(int i=0; i<N; i++)
            tree[i] = new Node(i);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        // 자식 추가
        for(int i=0; i<N; i++) {
            // 부모 노드
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1)
                root = i;
            else
                tree[parent].child.add(i);
        }

        // 노드 지우기
        deleteNode = Integer.parseInt(br.readLine());
        tree[deleteNode] = new Node(-1);

        // 루트 노드가 지워지면 0
        if(deleteNode == root)
            System.out.println(0);
        else {
            // 리프노드 갯수 구하기
            dfs(root);
            System.out.println(answer);
        }
    }

    public static void dfs(int curr) {
        Node currNode = tree[curr];
        // 리프노드
        if(currNode.child.size() == 0) {
            answer++;
            return;
        }

        // 다음 노드로 이동(사이클 없음)
        for(int i=0; i<currNode.child.size(); i++) {
            // 자른 노드이면 넘어가기
            if(currNode.child.get(i) == deleteNode) {
                if(currNode.child.size() == 1) {
                    answer++;
                }
                continue;
            }
            dfs(currNode.child.get(i));
        }
    }
}