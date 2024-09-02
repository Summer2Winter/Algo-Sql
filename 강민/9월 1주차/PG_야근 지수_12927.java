import java.util.PriorityQueue;
import java.util.Comparator;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int size = works.length;
        PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer x, Integer y) {
                return y - x;
            }
        });
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 값 넣기
        for(int i=0; i<size; i++)
            pq.add(works[i]);

        // 차이가 최소값이 작도록
        while(n != 0 && pq.peek() > 0) {
            int value = pq.poll() - 1;
            n -= 1;
            pq.add(value);
        }
        // 전부 0인 경우
        if(pq.peek() == 0)
            return 0;
        while(!pq.isEmpty()){
            if(pq.peek() == 0)
                break;
            int value = pq.poll();
            answer += (value * value);
        }
        return answer;
    }
}