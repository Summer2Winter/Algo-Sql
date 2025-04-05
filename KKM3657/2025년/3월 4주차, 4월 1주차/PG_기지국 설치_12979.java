class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int idx = 1; // 현재 위치
        int stationIdx = 0;

        while(idx <= n) {
            // 기지국 범위안에 들어가는지 확인
            if(stationIdx < stations.length && stations[stationIdx] - w <= idx) {
                idx = stations[stationIdx++] + w + 1;
            }
            else {
                answer++;
                idx += (2 * w) + 1;
            }
        }
        // 기지국
        return answer;
    }
}