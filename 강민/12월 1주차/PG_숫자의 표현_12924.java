class Solution {
    public int solution(int n) {
        int answer = 0;
        // 투포인터
        int left = 1, right = 1;
        int sum = 0;
        // 종료 조건
        while(left<=right && left <= n) {
            // 오른쪽 확장
            if(sum < n)
                sum += right++;
                // 왼쪽 축소
            else if(sum > n)
                sum -= left++;
                // 정답인 경우 오른쪽으로 확장을 안하고 왼쪽으로 축소
            else {
                sum -= left++;
                answer++;
            }
        }
        return answer;
    }
}