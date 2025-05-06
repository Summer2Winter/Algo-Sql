class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length, m = board[0].length;
        int[][] dp = new int[n+1][m+1];

        for(int[] arr : skill) {
            int r0 = arr[1], r1 = arr[3];
            int c0 = arr[2], c1 = arr[4];
            int degree = arr[5];

            // 파괴
            if(arr[0] == 1) degree = -degree;

            // 구간
            dp[r0][c0] += degree;
            dp[r0][c1+1] += -degree;
            dp[r1+1][c0] += -degree;
            dp[r1+1][c1+1] += degree;
        }

        // 누적합
        for(int i=0; i<n; i++) {
            for(int j=1; j<m; j++) {
                dp[i][j] += dp[i][j-1];
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=1; j<m; j++) {
                dp[j][i] += dp[j-1][i];
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                board[i][j] += dp[i][j];
                if(board[i][j] > 0)
                    answer++;
            }
        }
        return answer;
    }
}