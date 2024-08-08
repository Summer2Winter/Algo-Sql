import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] grid;
    static boolean[][] visited;
    static int[] odx = new int[]{0,1,1,0,-1,-1}, ody = new int[]{1,0,-1,-1,-1,0};
    static int[] edx = new int[]{0,1,1,0,-1,-1}, edy = new int[]{1,1,0,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        grid = new int[N+2][M+2];
        int[][] step = new int[N+2][M+2];
        visited = new boolean[N+2][M+2];

        // 그래프 그리기
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 외각 칠하기
        visited[0][0] = true;
        grid[0][0] = 2;
        dfs(0,0);

        // for(int i=0; i<N+2; i++) {
        //     for(int j=0; j<M+2; j++) {
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        // 구간 칠하기
        int answer = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(grid[i][j] == 1) {
                    int cnt = 0;
                    // 6방향 탐색
                    if(i % 2 == 0) {
                        for(int k=0; k<6; k++) {
                            int nx = i + odx[k];
                            int ny = j + ody[k];

                            if(grid[nx][ny] == 2)
                                cnt++;
                        }
                    }
                    else {
                        for(int k=0; k<6; k++) {
                            int nx = i + edx[k];
                            int ny = j + edy[k];

                            if(grid[nx][ny] == 2)
                                cnt++;
                        }
                    }
                    step[i][j] = cnt;
                    answer += cnt;
                }
            }
        }
        // for(int i=1; i<N+1; i++) {
        //     for(int j=1; j<M+1; j++) {
        //         System.out.print(step[i][j]);
        //     }
        //     System.out.println();
        // }
        System.out.println(answer);
    }
    public static void dfs(int cx, int cy) {
        for(int i=0; i<6; i++) {
            int nx, ny;
            if(cx % 2 == 0) {
                nx = cx + odx[i];
                ny = cy + ody[i];
            }
            else {
                nx = cx + edx[i];
                ny = cy + edy[i];
            }

            if(0 > nx || nx > N+1 || 0 > ny || ny > M+1)
                continue;

            if(!visited[nx][ny] && grid[nx][ny] != 1) {
                visited[nx][ny] = true;
                grid[nx][ny] = 2;
                dfs(nx,ny);
            }
        }
    }
}