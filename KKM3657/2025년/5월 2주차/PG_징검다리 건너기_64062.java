class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;

        // 전체 가능수 => 파라미터 서치
        int min = 0, max = 200_000_000;
        while(min <= max) {
            // 중앙값
            int mid = (min + max) / 2;

            // 건널수 있는지 확인
            if(isPossible(stones, k, mid)) {
                answer = mid;
                min = mid + 1;
            }
            else {
                max = mid - 1;
            }
        }
        return answer;
    }
    public boolean isPossible(int[] stones, int k, int mid) {
        int zeroCount = 0;

        for(int stone : stones) {
            // mid명이 건널수 있는지 확인
            if(stone < mid) {
                zeroCount++;
                // mid명이 연속으로 k이상 못 건너면 불가능한 경우
                if(zeroCount >= k)
                    return false;
            }
            else
                zeroCount = 0;
        }
        return true;
    }
}