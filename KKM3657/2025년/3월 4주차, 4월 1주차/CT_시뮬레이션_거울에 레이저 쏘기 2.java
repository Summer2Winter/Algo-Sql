import java.io.*;

public class Main {
    static int N, start,dir,answer;
    static char[][] grid;
    static int[][] startPos;
    static int[] dx = new int[]{1,0,-1,0}, dy = new int[]{0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        for(int i=0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<N; j++) {
                grid[i][j] = input.charAt(j);
            }
        }
        start = Integer.parseInt(br.readLine());

        // 시작 위치 저장
        startPos = new int[N*4][2];
        init();

        // 시작 지점 찾기
        dir = (start-1) / N;
        int[] curr = startPos[start-1];
        int x = curr[0], y = curr[1];
        while (0 <= x && x < N && 0 <= y && y < N) {
            answer++;
            char mirror = grid[x][y];
            // 현재 위치의 거울의 방향에 따라 변경
            if(mirror == '/') {
                if(dir == 0) dir = 1;
                else if(dir == 1) dir = 0;
                else if(dir == 2) dir = 3;
                else dir = 2;
            }
            else {
                if(dir == 0) dir = 3;
                else if(dir == 1) dir = 2;
                else if(dir == 2) dir = 1;
                else dir = 0;
            }
            x += dx[dir];
            y += dy[dir];
        }

        System.out.println(answer);
    }
    public static void init() {
        int idx = 0;
        // 위
        for(int i=0; i<N; i++) {
            startPos[idx][0] = 0;
            startPos[idx++][1] = i;
        }
        // 오른쪽
        for(int i=0; i<N; i++) {
            startPos[idx][0] = i;
            startPos[idx++][1] = N-1;
        }
        // 아래
        for(int i=0; i<N; i++) {
            startPos[idx][0] = N-1;
            startPos[idx++][1] = N-1-i;
        }
        // 왼
        for(int i=0; i<N; i++) {
            startPos[idx][0] = N-1-i;
            startPos[idx++][1] = 0;
        }
    }
}