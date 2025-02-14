import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);

        long left = 0;
        long right = (long) n * times[times.length - 1]; // 가장 오래 걸리는 시간

        while(left<=right) {
            long mid = (left + right) / 2;
            long temp = 0;
            // 이 시간 안에 몇명까지 가능한지 확인
            for(int time : times) {
                temp += mid / time;
            }
            // 이동
            if(temp >= n) {
                answer = Math.min(answer, mid);
                right = mid-1;
            }
            else
                left = mid+1;
        }
        return answer;
    }
}