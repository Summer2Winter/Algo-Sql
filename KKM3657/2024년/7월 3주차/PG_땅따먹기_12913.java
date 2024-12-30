class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length+1][5];

        for(int i=1; i<=land.length; i++) {
            for(int j=1; j<5; j++) {
                for(int k=1; k<5; k++) {
                    if(j==k)
                        continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k]);
                }
                dp[i][j] += land[i-1][j-1];
            }
        }
        for(int i=1; i<5; i++)
            answer = Math.max(answer, dp[land.length][i]);
        return answer;
    }
}