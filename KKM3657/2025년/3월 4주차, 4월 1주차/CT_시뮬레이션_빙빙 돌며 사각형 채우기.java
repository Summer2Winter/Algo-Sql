import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};

        char[][] grid = new char[N][M];
        int cx = 0, cy = 0;
        int dir = 0;
        char alpha = 'A';
        for(int i=0; i<N*M; i++) {
            // 현재 위치 기록
            grid[cx][cy] = alpha;


            // 다음 위치
            int nx = cx + dx[dir], ny = cy + dy[dir];

            if(0 > nx || nx >= N || 0 > ny || ny >= M || grid[nx][ny] != '\0') {
                dir = (dir+1) % 4;
                nx = cx + dx[dir];
                ny = cy + dy[dir];
            }
            alpha = (char)(((alpha - 'A' + 1) % 26) + 'A');
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