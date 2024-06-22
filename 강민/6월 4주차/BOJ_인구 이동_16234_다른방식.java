import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static int N,L,R,union;
    static int[][] grid, temp, map;
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    static ArrayList<int[]> unionInfo;
    static boolean[][] visited;
    static boolean move = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        grid = new int[N][N];

        // 지도
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 국경이동
        int time = 0;
        while(true) {
            // 초기 설정
            init();
            // 국경 이동 탐색
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j]) {
                        visited[i][j] = true;
                        temp[i][j] = union;
                        unionInfo.add(new int[]{grid[i][j],1});
                        findUnion(i,j);
                        union++;
                    }
                }
            }

            // 국경 이동
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    int[] curr = unionInfo.get(temp[i][j]);
                    grid[i][j] = curr[0] / curr[1];
                }
            }
            if(!move)
                break;
            time++;
        }
        System.out.println(time);
    }

    public static void init() {
        // 임시 지도
        union = 0; // 연합
        temp = new int[N][N];   // 연합을 나타낼 배열
        move = false;
        unionInfo = new ArrayList<>();
        visited = new boolean[N][N];
        map = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++){
                map[i][j] = grid[i][j];
            }
        }
    }

    public static void findUnion(int cx, int cy) {
        for(int i=0; i<4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;

            int value = (int) Math.abs(grid[cx][cy] - grid[nx][ny]);
            // 연합인지 판별
            if(value >= L && value <= R && !visited[nx][ny]) {
                move = true;
                visited[nx][ny] = true;
                temp[nx][ny] = union;
                int[] curr = unionInfo.get(union);
                curr[0] += grid[nx][ny];
                curr[1] += 1;
                findUnion(nx,ny);
            }
        }
    }
}