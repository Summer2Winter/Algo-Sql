import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Dice {
    int top;
    int now;
    int left;
    int right;
    int bottom;
    int nowtop;

    Dice(int top, int now, int left, int right, int bottom, int nowtop) {
        this.top = top;
        this.now = now;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.nowtop = nowtop;
    }
}
public class Main {
    // dx,dy
    static Dice dice;
    static int[] dx = new int[] {0,0,0,-1,1}, dy = new int[] {0,1,-1,0,0};
    static int[] command;
    static int N, M, floor, commandNum;
    static int[][] grid;
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 격자점
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 시작점
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());

        // 명령어
        commandNum = Integer.parseInt(st.nextToken());
        command = new int[commandNum];

        // 지도
        grid = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 명령어
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<commandNum; i++) {
            command[i] = Integer.parseInt(st.nextToken());
        }

        dice = new Dice(0,0,0,0,0,0);
        moveDice(0, sx, sy);
    }

    public static void moveDice(int curr, int kx, int ky) {
        // 모든 명령 완료
        if(curr == commandNum) {
            System.exit(0);
        }

        //이동 방향
        int dir = command[curr];
        int nx = kx + dx[dir], ny = ky + dy[dir];

        if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
            // 다음으로 이동
            moveDice(curr+1, kx, ky);
        }

        if(dir == 1) {
            // 동쪽으로 굴리기
            int tmp = dice.left;
            dice.left = dice.now;
            dice.now = dice.right;
            dice.right = dice.nowtop;
            dice.nowtop = tmp;
        }else if(dir == 2) {
            // 서쪽으로 굴리기
            int tmp = dice.left;
            dice.left = dice.nowtop;
            dice.nowtop = dice.right;
            dice.right = dice.now;
            dice.now = tmp;
        }else if(dir == 3) {
            // 북쪽으로 굴리기
            int tmp = dice.now;
            dice.now = dice.top;
            dice.top = dice.nowtop;
            dice.nowtop = dice.bottom;
            dice.bottom = tmp;
        }else if(dir == 4) {
            // 남쪽으로 굴리기
            int tmp = dice.now;
            dice.now = dice.bottom;
            dice.bottom = dice.nowtop;
            dice.nowtop = dice.top;
            dice.top = tmp;
        }

        //숫자 확인
        int next = grid[nx][ny];
        // 바닥 복사
        if(next == 0) {
            grid[nx][ny] = dice.now;
        }
        // 칸 지우기
        else {
            dice.now = grid[nx][ny];
            grid[nx][ny] = 0;
        }
        // 위쪽 출력
        System.out.println(dice.nowtop);

        // 다음으로 이동
        moveDice(curr+1, nx, ny);
    }
}