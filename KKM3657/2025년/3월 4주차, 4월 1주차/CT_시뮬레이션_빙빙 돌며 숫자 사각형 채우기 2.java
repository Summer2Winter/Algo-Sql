import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dx = new int[]{1,0,-1,0}, dy = new int[]{0,1,0,-1};
        int[][] grid = new int[N][M];
        int cx = 0, cy = 0;
        grid[0][0] = 1;
        int dir = 0;
        for(int value=2; value<=N*M; value++) {
            // 다음 지점
            int nx = cx + dx[dir], ny = cy + dy[dir];

            // 불가능한 경우 방향 전환
            if(0 > nx || nx >= N || 0 > ny || ny >= M || grid[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                nx = cx + dx[dir];
                ny = cy + dy[dir];
            }
            grid[nx][ny] = value;
            cx = nx;
            cy = ny;
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}