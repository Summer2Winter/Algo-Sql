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

// 처음에 이 문제를 봤을때 이분탐색을 이용한 파라미터 서치로 생각하였다. 이유는 N: 200,000,000 이하의 자연수라고 조건이 나와있었고
// 최소의 기지국 설치를 나타내라고 했기 때문에 기지국 설치 갯수로 접근하는 줄 알았다.
// 하지만 이 문제는 그리디 문제로 현재 위치가 기지국 범위에 있는 경우에 포함 여부에 따라 이동하는 문제이다.
// 시작지점이 1로 시작하며, 현재 위치가 기존 기지국에 포함되는 경우 기존 기지국에 포함되지 않는 곳으로 idx를 이동시킨다.
// 또한 기존 기지국의 인덱스로 증가시키는데 이는 다음 기존 기지국의 영향 지점을 찾기 위함이다.
// 만약 기존 기지국의 영향점이 아닌 경우 현재 지점을 기지국으로 설정하고 2 * w + 1 지점으로 이동한다.