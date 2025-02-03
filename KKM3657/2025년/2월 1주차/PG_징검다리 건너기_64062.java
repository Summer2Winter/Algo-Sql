class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int max = 0;
        // 최대값
        for(int value : stones)
            max = Math.max(max, value);

        // 이분탐색
        int left = 0, right = max;
        while(left <= right) {
            int mid = (left + right) / 2;

            // 해당 인원들이 지나갈 수 있는지
            if(isPossible(stones, k, mid)) {
                answer = mid;
                // 가능하면 left = mid + 1;
                left = mid + 1;
            }
            // 불가능 하면 right = mid - 1;
            else {
                right = mid -1;
            }
        }
        return answer;
    }
    public boolean isPossible(int[] stones, int k, int mid) {
        int zeroCount = 0;

        for(int stone : stones) {
            // mid명이 건너면 돌이 0이 되는 경우 - K개가 연속으로 0이면 불가능
            if(stone < mid) {
                zeroCount++;
                if(zeroCount >= k)
                    return false;
            }
            else {
                zeroCount = 0;
            }
        }
        return true;
    }
}