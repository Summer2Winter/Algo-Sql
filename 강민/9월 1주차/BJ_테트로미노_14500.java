import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] grid;
    static int[][] dx = new int[][] {
            {0,0,0,0},{0,1,2,3},
            {0,0,1,1},
            {0,1,2,2},{0,0,0,1},{0,-1,-2,-2},{0,0,0,-1},
            {0,0,-1,-2},{0,-1,-1,-1},{0,0,1,2},{0,1,1,1},
            {0,1,1,2},{0,0,-1,-1},{0,1,1,2},{0,0,1,1},
            {0,0,1,0},{0,1,0,-1},{0,0,-1,0},{0,-1,0,1}
    };
    static int[][] dy = new int[][] {
            {0,1,2,3},{0,0,0,0},
            {0,1,0,1},
            {0,0,0,1},{0,-1,-2,-2},{0,0,0,-1},{0,1,2,2},
            {0,1,1,1},{0,0,-1,-2},{0,-1,-1,-1},{0,0,1,2},
            {0,0,1,1},{0,1,1,2},{0,0,-1,-1},{0,1,1,2},
            {0,-1,0,1},{0,0,1,0},{0,1,0,-1},{0,0,-1,0}
    };
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        // 그래프 그리기
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                answer = Math.max(answer, findAnswer(i,j));
            }
        }
        System.out.println(answer);
    }

    public static int findAnswer(int x, int y) {
        int value = 0;

        // 모형
        for(int s=0; s<19; s++) {
            int temp = 0;
            for(int i=0; i<4; i++) {
                int nx = x + dx[s][i], ny = y + dy[s][i];
                // 만들수 없음
                if(0 > nx || nx >= N || 0 > ny || ny >= M) {
                    temp = 0;
                    break;
                }
                // 다 더하기
                temp += grid[nx][ny];
            }

            value = Math.max(value, temp);
        }
        return value;
    }
}