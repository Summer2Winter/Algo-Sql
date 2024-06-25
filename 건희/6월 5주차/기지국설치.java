class Solution {
    public int solution(int n, int[] stations, int w) {
        int currentPosition = 1; // 현재 위치
        int stationIndex = 0; // 기지국 인덱스
        int additionalStations = 0; // 설치해야 하는 추가 기지국 개수

        while (currentPosition <= n) {
            // 현재 위치가 모든 기지국 범위를 벗어난 경우 또는 현재 위치가 기지국 범위에 포함되지 않는 경우
            if (stationIndex >= stations.length || currentPosition < stations[stationIndex] - w) {
                additionalStations++; // 기지국 설치
                currentPosition += 2 * w + 1; // 새 기지국 범위로 이동
            } else {
                // 현재 위치가 기지국 범위에 포함되는 경우
                currentPosition = stations[stationIndex] + w + 1; // 기지국 범위 밖으로 이동
                stationIndex++; // 다음 기지국으로 이동
            }
        }
        return additionalStations;
    }
}