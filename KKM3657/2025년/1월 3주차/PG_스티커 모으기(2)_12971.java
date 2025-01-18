class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int n = sticker.length;
        int[][] dp = new int[n][2];

        if(n == 1) {
            return sticker[0];
        }

        dp[0][0] = sticker[0];
        dp[1][0] = Math.max(sticker[0], sticker[1]);
        dp[1][1] = sticker[1];

        for(int i=2; i<n; i++) {
            // 마지막 경우
            if(i == n-1) {
                // 0번을 포함하는 경우는 제외
                dp[i][1] = Math.max(dp[i-2][1] + sticker[i], dp[i-1][1]);
            }
            else {
                dp[i][0] = Math.max(dp[i-2][0] + sticker[i], dp[i-1][0]);
                dp[i][1] = Math.max(dp[i-2][1] + sticker[i], dp[i-1][1]);
            }
        }
        answer = Math.max(dp[n-2][0], dp[n-1][1]);
        return answer;
    }
}