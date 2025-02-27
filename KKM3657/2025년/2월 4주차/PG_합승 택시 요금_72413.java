import java.util.Arrays;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dp = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            Arrays.fill(dp[i], (int)1e9);
            dp[i][i] = 0;
        }

        for(int[] fare : fares) {
            dp[fare[0]][fare[1]] = fare[2];
            dp[fare[1]][fare[0]] = fare[2];
        }

        // 플로이드 워샬
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }

        // 시작 지점에서 해당 각 정점까지의 거리 + A, B까지의 합이 최소인 지점 찾기
        int answer = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++) {
            // 시작지점에서 i까지의 거리
            if(dp[i][a] != (1e9) && dp[i][b] != (int)1e9)
                answer = Math.min(answer, dp[s][i] + dp[i][a] + dp[i][b]);
        }

        return answer;
    }
}