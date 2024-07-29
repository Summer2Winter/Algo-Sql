import java.util.ArrayDeque;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1, value = 0;
        long sumQ1 = 0, sumQ2 = 0;
        // 큐 생성
        ArrayDeque<Integer> deque1 = new ArrayDeque<>();
        ArrayDeque<Integer> deque2 = new ArrayDeque<>();
        // 큐에 넣기 및 합 찾기 (원형 형태로 생각)
        for(int i=0; i<queue1.length; i++) {
            deque1.add(queue1[i]);
            sumQ1 += queue1[i];
        }
        for(int i=0; i<queue2.length; i++) {
            deque2.add(queue2[i]);
            sumQ2 += queue2[i];
        }
        // 총 시행 횟수 -> 자기 자리로 돌아올때까지
        int num = queue1.length*3;

        // 목표 값, 홀수이면 정답 불가
        long target = sumQ1 + sumQ2;
        if(target % 2 != 0)
            return -1;

        for(int i=0; i<num; i++) {
            // 큰 쪽에서 작은 쪽으로 옮기기
            if(sumQ1 > sumQ2) {
                int temp = deque1.poll();
                deque2.add(temp);
                sumQ1 -= temp;
                sumQ2 += temp;
                value++;
            }
            else if(sumQ1 < sumQ2) {
                int temp = deque2.poll();
                deque1.add(temp);
                sumQ2 -= temp;
                sumQ1 += temp;
                value++;
            }
            else {
                return value;
            }
        }
        return answer;
    }
}