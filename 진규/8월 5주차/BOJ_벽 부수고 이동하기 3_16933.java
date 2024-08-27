import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] board;
    static int[][][][] dis;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};

    static StringTokenizer st;
    static String str;
    static int answer;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {

            str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        dis = new int[K+1][N][M][2];
        for (int k = 0; k < K+1; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    dis[k][i][j][0] = -1;
                    dis[k][i][j][1] = -1;
                }
            }
        }
        bfs();

        System.out.println(answer != 0 ? answer : -1);
    }

    private static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, K, 0});
        dis[K][0][0][0] = 1;
//        visited[0][0] = true;

        while(!queue.isEmpty()) {

            int[] qPoll = queue.poll();
            int px = qPoll[0];
            int py = qPoll[1];
            int wall = qPoll[2];
            int time = qPoll[3];  // 낮=0, 밤=1

            if (px == N-1 && py == M-1) {
                answer = dis[wall][px][py][time];
                return;
            }

            for (int k = 0; k < 4; k++) {
                int mx = px + dx[k];
                int my = py + dy[k];

                if (!isRange(mx, my)) continue;

                if (board[mx][my] == 0 && dis[wall][mx][my][1-time] == -1) {
                    dis[wall][mx][my][1-time] = dis[wall][px][py][time] + 1;
                    queue.add(new int[]{mx, my, wall, 1-time});
                }
                else if (board[mx][my] == 1 && time == 0 && wall > 0 && dis[wall-1][mx][my][1-time] == -1) {
                    dis[wall-1][mx][my][1-time] = dis[wall][px][py][time] + 1;
                    queue.add(new int[]{mx, my, wall-1, 1-time});
                }
            }

            if (dis[wall][px][py][1-time] == -1) {
                dis[wall][px][py][1-time] = dis[wall][px][py][time] + 1;
                queue.add(new int[]{px, py, wall, 1-time});
            }
        }
    }

    private static boolean isRange(int mx, int my) {

        return 0 <= mx && mx < N && 0 <= my && my < M;
    }
}