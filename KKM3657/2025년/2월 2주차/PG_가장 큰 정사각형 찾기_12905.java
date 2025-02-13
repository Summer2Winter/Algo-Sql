class Solution {
    public int solution(int [][]board) {
        int answer = 0;
        int n = board.length, m = board[0].length;
        // dp
        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 0)
                    continue;
                int temp = dp[i][j]; // i-1,j-1 부분
                temp = Math.min(temp, dp[i+1][j]);
                temp = Math.min(temp, dp[i][j+1]);
                dp[i+1][j+1] = temp+1;
                answer = Math.max(answer, dp[i+1][j+1]);
            }
        }
        return answer * answer;
    }
}