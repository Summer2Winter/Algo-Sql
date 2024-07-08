import java.util.Queue;
import java.util.ArrayDeque;

class Node {
    int idx;
    int priority;

    Node(int idx, int priority) {
        this.idx = idx;
        this.priority = priority;
    }
}
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] cnt = new int[10];
        Queue<Node> q = new ArrayDeque<>();
        // queue에 삽입
        for(int i=0; i<priorities.length; i++) {
            int value = priorities[i];
            cnt[value]++;
            q.add(new Node(i, value));
        }
        while(!q.isEmpty()) {
            Node curr = q.poll();
            boolean flag = false;
            // 우선순위가 있는 내역 확인
            for(int i=curr.priority+1; i<10; i++) {
                if(cnt[i] > 0)
                    flag = true;
            }
            // 있는 경우 큐에 저장
            if(flag) {
                q.add(curr);
                continue;
            }
            // 실행 되는 경우
            answer++;
            cnt[curr.priority]--;

            // 해당 위치가 실행된 경우
            if(curr.idx == location) {
                break;
            }
        }
        return answer;
    }
}