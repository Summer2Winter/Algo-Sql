import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        // 초기화
        for(int value : scoville)
            pq.offer((long)value);

        // 합치기
        while(pq.size() >= 2 && pq.peek() < K) {
            long first = pq.poll();
            long second = pq.poll();

            pq.offer(first + (second * 2));
            answer++;
        }
        if(pq.peek() < K)
            answer = -1;
        return answer;
    }
}