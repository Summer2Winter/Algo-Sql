import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] grid, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];
        int[][] temp = new int[2][M+2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1열 누적합
        dp[1][1] = grid[1][1];
        for(int i=2; i<=M; i++) {
            dp[1][i] = dp[1][i-1] + grid[1][i];
        }

        // 2열부터는 위에서 내려온 숫자 합이 큰지, 왼쪽-오른쪽으로 이동한게 큰지 계산
        for (int i=2; i<=N; i++) {
            // 왼쪽 -> 오른쪽
            temp[0][0] = dp[i-1][1];
            for(int j=1; j<=M; j++) {
                temp[0][j] = Math.max(temp[0][j-1], dp[i-1][j]) + grid[i][j]; // 왼쪽에서 오는게 큰지, 위에서 내려온게 큰지
            }

            // 오른쪽 -> 왼쪽
            temp[1][M+1] = dp[i-1][M];
            for(int j=M; j>=1; j--) {
                temp[1][j] = Math.max(temp[1][j+1], dp[i-1][j]) + grid[i][j]; // 오른쪽에서 오는게 큰지, 위에서 내려온게 큰지
            }

            // 해당 행 DP 값 갱신 (왼, 오, 아래 중 고르기)
            for(int j=1; j<=M; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }

        System.out.println(dp[N][M]);
    }
}
