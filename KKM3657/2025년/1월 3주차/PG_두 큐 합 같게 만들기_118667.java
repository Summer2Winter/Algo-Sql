import java.util.ArrayDeque;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        int cnt = 0, end = queue1.length * 3;
        long sum1 = 0, sum2 = 0;
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        // 큐에 넣기
        for(int i=0; i<queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        // 합이 홀수라면 불가능
        if ((sum1+sum2) % 2 != 0) {
            return -1;
        }
        while(cnt != end) {
            // 합이 같으면 최소
            if(sum1 == sum2) {
                answer = cnt;
                break;
            }
            // 큰 수에서 작은수로 넘김
            else if(sum1 > sum2) {
                int temp = q1.poll();
                sum1 -= temp;
                q2.add(temp);
                sum2 += temp;
            }
            else {
                int temp = q2.poll();
                sum2 -= temp;
                q1.add(temp);
                sum1 += temp;
            }
            cnt++;
        }
        return answer;
    }
}