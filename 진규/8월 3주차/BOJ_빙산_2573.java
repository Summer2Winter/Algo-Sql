import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static int time;

    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = false; // 빙산이 분리되었는지 여부
        for (int l = 0; l < 1000; l++) {
            
            visited = new boolean[N][M]; // 녹일때 마다 방문배열 초기화
            int icebergCnt = 0; // 빙산의 개수

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    if (!visited[i][j] && board[i][j] > 0) { // 빙산을 녹이는 과정이 실행되는 횟수가 곧 빙산의 개수를 의미
                        bfs(i, j);
                        icebergCnt += 1;
                    }
                }
            }

            if (icebergCnt >= 2) { // 빙산의 개수가 2개 이상이면 녹이는 과정 멈춤
                flag = true;
                break;
            }
            time += 1;
        }

        System.out.println(flag ? time : 0);
    }

    private static int melting(int x, int y) {

        int seaCnt = 0; // 바다 개수
        for (int k = 0; k < 4; k++) {
            int mx = x + dx[k];
            int my = y + dy[k];

            if (board[mx][my] == 0) {
                seaCnt += 1;
            }
        }

        return seaCnt;
    }

    private static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        List<int[]> meltingCntList = new ArrayList<>();
        meltingCntList.add(new int[]{x, y, melting(x, y)});

        while (!queue.isEmpty()) {

            int[] qPoll = queue.poll();
            int px = qPoll[0];
            int py = qPoll[1];

            for (int k = 0; k < 4; k++) {
                int mx = px + dx[k];
                int my = py + dy[k];

                if (!isRange(mx, my)) continue;
                if (visited[mx][my]) continue;

                if (board[mx][my] > 0) {
                    visited[mx][my] = true;
                    meltingCntList.add(new int[]{mx, my, melting(mx, my)});
                    queue.add(new int[]{mx, my});
                }
            }
        }

        // 동시에 빙산을 녹이기 위해 다음과 같이 미리 녹일 높이를 계산한 후 마지막에 녹임
        for (int[] meltingCnt : meltingCntList) {

            int px = meltingCnt[0];
            int py = meltingCnt[1];
            int cnt = meltingCnt[2];

            board[px][py] = Math.max(board[px][py] - cnt, 0);
        }
    }

    private static boolean isRange(int mx, int my) {

        return 0 <= mx && mx < N && 0 <= my && my < M;
    }
}