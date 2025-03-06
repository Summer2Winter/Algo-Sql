class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int left = 1;
        int right = 100_000; //최고 레벨

        // 파라미터 서치
        while(left <= right) {
            int mid = (left + right) / 2;

            // 해당 레벨로 limit 시간 안에 풀 수 있는지 확인
            long time = 0;
            for(int i=0; i<diffs.length; i++) {
                // 틀리지 않고 풀기
                if(diffs[i] - mid <= 0) {
                    time += times[i];
                }
                else {
                    time += ((diffs[i] - mid) * (times[i] + times[i-1]) + times[i]);
                }
                // 불가능한 경우 넘어감
                if(time > limit)
                    break;
            }
            // limit안에 들어오는 경우
            if(time <= limit) {
                answer = mid;
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return answer;
    }
}