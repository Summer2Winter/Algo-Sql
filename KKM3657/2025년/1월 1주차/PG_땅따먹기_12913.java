class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int N = land.length, M = land[0].length;
        // 초기화
        int[][] dp = new int[N][M];
        for(int i=0; i<M; i++)
            dp[0][i] = land[0][i];

        for(int i=1; i<N; i++) {
            for(int j=0; j<M; j++) {
                for(int k=0; k<M; k++) {
                    if(j==k)
                        continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k]);
                }
                dp[i][j] += land[i][j];
            }
        }
        for(int value : dp[N-1]) {
            answer = Math.max(answer, value);
        }
        return answer;
    }
}