class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for(int i=1; i<triangle.length; i++) {
            for(int j=0; j<=i; j++) {
                // 맨처음
                if(j == 0)
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                else if(j == i)
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
                }
            }
        }
        for(int value : dp[triangle.length-1])
            answer = Math.max(answer, value);
        return answer;
    }
}