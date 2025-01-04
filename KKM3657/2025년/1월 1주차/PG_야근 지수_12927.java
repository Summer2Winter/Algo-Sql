import java.util.PriorityQueue;
import java.util.Collections;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 값 넣기
        for(int work : works)
            pq.add(work);
        while(n > 0) {
            int work = pq.poll();
            if(work == 0) {
                answer = 0;
                break;
            }
            pq.add(work-1);
            n--;
        }
        while(!pq.isEmpty()) {
            answer += Math.pow(pq.poll(),2);
        }
        return answer;
    }
}