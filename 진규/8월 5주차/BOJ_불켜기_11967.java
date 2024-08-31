import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Swtich {

        int fx, fy;
        int tx, ty;

        Swtich(int fx, int fy, int tx, int ty) {
            this.fx = fx;
            this.fy = fy;
            this.tx = tx;
            this.ty = ty;
        }
    }

    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static List<Swtich> swtichList = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};

    static StringTokenizer st;
    static int answer = 1;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            swtichList.add(new Swtich(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1
                    , Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1));
        }

        bfs();

        System.out.println(answer);
    }

    private static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        board[0][0] = 1;
        visited[0][0] = true;

        while(!queue.isEmpty()) {

            int[] qPoll = queue.poll();
            int px = qPoll[0];
            int py = qPoll[1];

            switchOn(px, py, queue);

            for (int k = 0; k < 4; k++) {
                int mx = px + dx[k];
                int my = py + dy[k];

                if (!isRange(mx, my)) continue;
                if (visited[mx][my]) continue;

                if (board[mx][my] == 1) {
                    visited[mx][my] = true;
                    queue.add(new int[]{mx, my});
                }
            }
        }
    }

    private static void switchOn(int px, int py, Queue<int[]> queue) {

        for (Swtich s : swtichList) { // 스위치를 ON 할 수 있는 좌표를 돌면서

            // 스위치를 ON할 수 있으면 ON
            if (px == s.fx && py == s.fy) {
                if (board[s.tx][s.ty] == 0) {
                    board[s.tx][s.ty] = 1;
                    answer += 1;

                    for (int k = 0; k < 4; k++) { // 스위치를 ON했을 때 스위치 좌표에 인접한 부분이 지나온 길인지 확인
                        int mx = s.tx + dx[k];
                        int my = s.ty + dy[k];

                        if (isRange(mx, my) && visited[mx][my]) {
                            visited[s.tx][s.ty] = true; // 스위치 좌표 방문체크
                            queue.add(new int[]{s.tx, s.ty});
                            break;
                        }
                    }
                }
            }
        }
    }

    private static boolean isRange(int mx, int my) {

        return 0 <= mx && mx < N && 0 <= my && my < N;
    }
}