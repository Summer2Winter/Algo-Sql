import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int value : works) {
            pq.add(value);
        }
        while(n-- != 0) {
            int value = pq.poll();
            if(value == 0)
                break;
            pq.add(value-1);
        }
        while(!pq.isEmpty()) {
            answer += Math.pow(pq.poll(),2);
        }
        return answer;
    }
}