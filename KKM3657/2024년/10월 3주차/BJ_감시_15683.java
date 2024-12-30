import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Pair {
    int x;
    int y;
    int dir;
    // 방향이 없는 경우
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 방향이 저장된 경우
    Pair(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}

public class Main {
    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] grid, temp;
    static ArrayList<Pair> cctv = new ArrayList<>();
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        // 격자점
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] > 0 && grid[i][j] < 6)
                    cctv.add(new Pair(i,j));
            }
        }

        // CCTV 방향 설정하기
        selectCctvDirection(0);
        System.out.println(answer);
    }

    public static void selectCctvDirection(int curr) {
        // cctv 방향 설정 완료
        if(curr == cctv.size()) {
            // 광선 쏘기
            temp = new int[N][M];
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    temp[i][j] = grid[i][j];
                }
            }
            makeLazer();

            int cnt = 0;
            // 사각지대 계산
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(temp[i][j]== 0)
                        cnt++;
                }
            }

            answer = Math.min(answer, cnt);
            return;
        }

        // 방향 저장
        for(int i=0; i<4; i++) {
            // 방향 선택
            cctv.get(curr).dir = i;
            selectCctvDirection(curr+1);
        }
    }

    public static void makeLazer() {
        int k = cctv.size();
        for(int i=0; i<k; i++) {
            // 현재 cctv
            Pair curr = cctv.get(i);
            int cctvNum = temp[curr.x][curr.y];
            int dir = curr.dir;
            // 1번
            if(cctvNum == 1)
                // 단방향
                fillLazer(curr.x, curr.y, dir);
                // 2번
            else if(cctvNum == 2) {
                // 단뱡향
                fillLazer(curr.x, curr.y, dir);
                fillLazer(curr.x, curr.y, (dir+2) % 4);
            }
            // 3번
            else if(cctvNum == 3) {
                // 단뱡향
                fillLazer(curr.x, curr.y, dir);
                fillLazer(curr.x, curr.y, (dir+1) % 4);
            }
            // 4번
            else if(cctvNum == 4) {
                // 단뱡향
                fillLazer(curr.x, curr.y, dir);
                fillLazer(curr.x, curr.y, (dir+3) % 4);
                fillLazer(curr.x, curr.y, (dir+1) % 4);
            }
            // 5번
            else if(cctvNum == 5) {
                // 단뱡향
                for(int j=0; j<4; j++) {
                    fillLazer(curr.x, curr.y, (dir+j) % 4);
                }
            }
        }
    }
    public static void fillLazer(int nx, int ny, int dir) {
        while(temp[nx][ny] != 6) {
            nx = nx + dx[dir];
            ny = ny + dy[dir];

            if(0 > nx || nx >= N || 0 > ny || ny >= M || temp[nx][ny] == 6)
                break;

            // 기록
            if(temp[nx][ny] == 0)
                temp[nx][ny] = 8;
        }
    }
}