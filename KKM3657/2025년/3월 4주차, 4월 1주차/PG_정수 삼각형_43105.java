class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int N = triangle.length;
        // 계단 모양 만들기
        int[][] dp = new int[N][N];
        dp[0][0] = triangle[0][0];
        // 2층
        for(int i=1; i<N; i++) {
            for(int j=0; j<=i; j++) {
                // 왼쪽
                if(j == 0)
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                else if(j == i) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
                }
            }
        }
        for(int i=0; i<N; i++)
            answer = Math.max(answer, dp[N-1][i]);
        return answer;
    }
}