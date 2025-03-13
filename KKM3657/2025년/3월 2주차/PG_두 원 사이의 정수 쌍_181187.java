class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int x = 1; x <= r2; x++) {
            long y2 = (long) Math.floor(Math.sqrt((long) r2 * r2 - (long) x * x)); // r2는 안쪽을 포함해야 한다.
            long y1 = (long) Math.ceil(Math.sqrt((long) r1 * r1 - (long) x * x)); // r1은 바깥을 포함해야 한다.
            answer += (y2 - y1 + 1); // 해당 x에서 가능한 y 좌표 개수 추가
        }

        answer *= 4; // 대칭 적용

        return answer;
    }
}
