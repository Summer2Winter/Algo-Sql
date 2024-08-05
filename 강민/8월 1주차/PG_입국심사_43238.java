import java.util.Arrays;
class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long left = 0;
        long right = (long) n * times[times.length - 1]; //가장 최악의 경우의(오래걸리는) 시간
        while(left<=right) {
            long mid = (left + right) / 2;
            long temp = 0;
            for(int i=0; i<times.length; i++) {
                temp += (mid / times[i]);
            }
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