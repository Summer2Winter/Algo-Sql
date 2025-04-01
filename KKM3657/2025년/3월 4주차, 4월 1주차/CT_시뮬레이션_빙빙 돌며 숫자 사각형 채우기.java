import java.io.*;
import java.util.*;
public class Main {
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    static int[][] grid;
    static int N, M, dir, value;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        dir = 0;
        value = 1;
        makeGrid(0,0);
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void makeGrid(int cx, int cy) {
        // 기록
        grid[cx][cy] = value++;
        // 기저 조건
        if(value == N * M + 1)
            return;
        // 다음 지점
        int nx = cx + dx[dir], ny = cy + dy[dir];

        // 다음 이동할 곳이 없음
        if(0 > nx || nx >= N || 0 > ny || ny >= M || grid[nx][ny] != 0) {
            dir = (dir + 1) % 4;
            nx = cx + dx[dir];
            ny = cy + dy[dir];
        }
        makeGrid(nx, ny);
    }
}