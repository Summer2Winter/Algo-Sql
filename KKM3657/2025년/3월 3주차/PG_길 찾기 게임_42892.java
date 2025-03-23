import java.util.Arrays;
import java.util.ArrayList;

class Node {
    int idx;
    int x;
    int y;
    Node left, right;

    Node(int idx, int x, int y) {
        this.idx = idx;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int N;
    int[][] answer;
    ArrayList<Integer> list;
    public int[][] solution(int[][] nodeinfo) {
        N = nodeinfo.length;
        answer = new int[2][N];

        // 노드
        Node[] tree = new Node[N];

        // 노드 번호 저장
        for(int i=0; i<N; i++) {
            tree[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        // 노드 정렬
        Arrays.sort(tree, (a,b) -> a.y == b.y ? a.x-b.x : b.y-a.y);

        Node root = tree[0];

        for(int i=1; i<N; i++) {
            Node curr = tree[i];
            Node temp = root;
            // 자기 위치 찾아가기
            while(temp != null) {
                //왼쪽인 경우
                if(curr.x < temp.x) {
                    // 비어있는 경우
                    if(temp.left == null) {
                        temp.left = curr;
                        temp = null;
                    }
                    // 비어있지 않은 경우 이동
                    else
                        temp = temp.left;
                }
                // 오른쪽인 경우
                else {
                    // 비어있는 경우
                    if(temp.right == null) {
                        temp.right = curr;
                        temp = null;
                    }
                    // 비어있지 않은 경우 이동
                    else
                        temp = temp.right;
                }
            }
        }

        // 전위 순위
        list = new ArrayList<>();
        preOrder(root);
        for(int i=0; i<list.size(); i++) {
            answer[0][i] = list.get(i);
        }

        list = new ArrayList<>();
        postOrder(root);
        for(int i=0; i<list.size(); i++) {
            answer[1][i] = list.get(i);
        }
        return answer;
    }
    public void preOrder(Node curr) {
        // 리프 노드이면 돌아감
        if(curr == null) {
            return;
        }

        // 현재 노드 기록
        list.add(curr.idx);
        preOrder(curr.left);
        preOrder(curr.right);
    }

    public void postOrder(Node curr) {
        // 리프 노드이면 돌아감
        if(curr == null) {
            return;
        }

        // 현재 노드 기록
        postOrder(curr.left);
        postOrder(curr.right);
        list.add(curr.idx);
    }
}