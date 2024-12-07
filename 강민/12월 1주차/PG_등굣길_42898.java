class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        // DP
        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 1;
        // 물 웅덩이
        for(int[] arr : puddles)
            dp[arr[1]][arr[0]] = -1;

        // 학교까지 길 연결
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(dp[i][j] == -1)
                    continue;
                // 물 웅덩이 경우
                if(dp[i-1][j] != -1)
                    dp[i][j] = (dp[i][j] + dp[i-1][j]) % 1000000007;
                if(dp[i][j-1] != -1)
                    dp[i][j] = (dp[i][j] + dp[i][j-1]) % 1000000007;
            }
        }
        answer = dp[n][m];
        return answer;
    }
}