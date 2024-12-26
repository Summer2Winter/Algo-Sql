import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<int[]> date = new ArrayDeque<>();

        for(int i=0; i<progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = (int) Math.ceil(remain / (speeds[i] * 1.0));

            if(date.isEmpty())
                date.push(new int[]{day, 1});
            else {
                // 이전 값이 큰 경우 횟수+1
                if(date.peek()[0] >= day)
                    date.peek()[1]++;
                else {
                    date.push(new int[]{day, 1});
                }
            }
        }

        // 데이터 저장
        int cnt = date.size();
        int[] answer = new int[cnt];

        while(!date.isEmpty()) {
            cnt--;
            answer[cnt] = date.pop()[1];
        }
        return answer;
    }
}