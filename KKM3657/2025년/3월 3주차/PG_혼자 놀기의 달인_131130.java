import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        boolean[] visited = new boolean[cards.length];
        // 사이클 구하기
        for(int i=0; i<cards.length; i++) {
            if(visited[i])
                continue;
            int curr = i, cnt = 0;
            while(!visited[curr]) {
                // 그룹
                visited[curr] = true;
                cnt++;
                int next = cards[curr]-1;
                curr = next;
            }
            pq.add(cnt);
        }
        if(pq.size() >= 2)
            answer = pq.poll() * pq.poll();
        return answer;
    }
}