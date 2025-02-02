import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;

class Node {
    int node;
    int parent;
    ArrayList<Integer> child = new ArrayList<>();

    Node(int node) {
        this.node = node;
    }
}
public class Main {
    static int E;
    static Node[] tree = new Node[10001];
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        E = Integer.parseInt(br.readLine());
        int size = 0;

        for(int i=0; i<E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parentNode = Integer.parseInt(st.nextToken());
            int childNode = Integer.parseInt(st.nextToken());

            // 노드 생성
            if(tree[parentNode] == null) {
                tree[parentNode] = new Node(parentNode);
                size++;
            }

            tree[parentNode].child.add(childNode);

            if(tree[childNode] == null) {
                tree[childNode] = new Node(childNode);
                size++;
            }
            // 양방향이 되면 트리 조건 불만족(조건 1)
            if (tree[childNode].parent != 0) {
                System.out.println(0);
                return;
            }
            tree[childNode].parent = parentNode;
        }

        int root = -1, cnt = 0;
        // 조건1, 조건 2(루트 노드 제외 모든 노드 반드시 간선 한개 존재 => 부모가 있음)
        for(int i=1; i<10001; i++) {
            if(tree[i] == null)
                continue;
            if(tree[i].parent == 0) {
                root = i;
                cnt++;
            }
        }
        if(cnt != 1) {
            System.out.println(0);
            System.exit(0);
        }

        // 조건 3. 모든 노드가 연결되어 있는가?
        set.add(root);
        if(!isPossible(root)) {
            System.out.println(0);
        }

        // 조건 3. 모든 노드 방문?
        if(size != set.size())
            System.out.println(0);
        else
            System.out.println(1);
    }
    public static boolean isPossible(int curr) {
        Node currNode = tree[curr];

        // 자식 노드
        for(int next : currNode.child) {
            // 이미 방문했다면 불가능
            if(set.contains(next))
                return false;

            set.add(next);

            if(!isPossible(next))
                return false;
        }
        return true;
    }
}