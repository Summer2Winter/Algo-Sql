import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] grid = new int[N+1][N+1];
        long[][][] dp = new long[N+1][N+1][3];

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=2; i<=N; i++) {
            if(grid[1][i] == 1)
                break;
            dp[1][i][0] = 1;
        }

        for(int i=2; i<=N; i++) {
            for(int j=3; j<=N; j++) {
                if(grid[i][j] != 1) {
                    dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
                }
                if(grid[i][j] != 1) {
                    dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
                }
                if(grid[i][j] != 1 && grid[i-1][j] != 1 && grid[i][j-1] != 1) {
                    dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                }
            }
        }

        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    }
}