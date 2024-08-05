import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 0;
        int right = distance;
        Arrays.sort(rocks);

        while(left<=right) {
            int mid = (left + right) / 2;
            int prev = 0;
            int removeCount = 0;

            // 지울 돌 선택
            for(int rock : rocks) {
                if(rock - prev < mid) {
                    removeCount++;
                }
                else {
                    prev = rock;
                }
            }

            // 마지막 돌 확인
            if (distance - prev < mid) {
                removeCount++;
            }

            // 지울 돌이 많은 경우 정답이 안됨
            if (removeCount > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = mid;
            }
        }
        return answer;
    }
}