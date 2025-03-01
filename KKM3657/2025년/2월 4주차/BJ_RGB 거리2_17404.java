import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N+1][3];
        int[][][] dp = new int[N+1][3][3];

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫 번째 집의 색상 정하기
        for (int firstColor = 0; firstColor < 3; firstColor++) {
            for (int j = 0; j < 3; j++) {
                if (j == firstColor) {
                    dp[1][j][firstColor] = grid[1][j]; // 첫 번째 집을 j 색상으로 칠한 경우
                } else {
                    dp[1][j][firstColor] = 1000001; // 불가능한 경우를 위해 큰 값 설정
                }
            }
        }

        // DP 수행
        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < 3; j++) { // 현재 집의 색깔
                for(int k = 0; k < 3; k++) { // 첫 번째 집의 색깔
                    if (j == k && i == N) continue; // 마지막 집이 첫 번째 집과 같으면 안됨
                    dp[i][j][k] = Math.min(dp[i-1][(j+1)%3][k], dp[i-1][(j+2)%3][k]) + grid[i][j];
                }
            }
        }

        // 최소 비용 찾기
        int minCost = Integer.MAX_VALUE;
        for (int lastColor = 0; lastColor < 3; lastColor++) {
            for (int firstColor = 0; firstColor < 3; firstColor++) {
                if (firstColor != lastColor) {
                    minCost = Math.min(minCost, dp[N][lastColor][firstColor]);
                }
            }
        }

        System.out.println(minCost);
    }
}
