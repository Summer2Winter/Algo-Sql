import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
        빈 방('0')인거 부터 우선적으로 큐에 넣어서(-> deque) 완전 탐색 하기
     */

    static int N, M;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};

    static StringTokenizer st;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            board[i] = st.nextToken().toCharArray();
        }

        bfs();

        System.out.println(answer);
    }

    private static void bfs() {

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!deque.isEmpty()) {

            int[] dPoll = deque.poll();
            int px = dPoll[0];
            int py = dPoll[1];
            int cnt = dPoll[2];

            if (px == N-1 && py == M-1)
                answer = Math.min(answer, cnt);

            for (int k = 0; k < 4; k++) {

                int mx = px + dx[k];
                int my = py + dy[k];

                if (!isRange(mx, my)) continue;
                if (visited[mx][my]) continue;

                if (board[mx][my] == '0') {

                    visited[mx][my] = true;
                    deque.addFirst(new int[]{mx, my, cnt});
                }
                else if (board[mx][my] == '1') {

                    visited[mx][my] = true;
                    deque.addLast(new int[]{mx, my, cnt+1});
                }
            }
        }
    }

    private static boolean isRange(int mx, int my) {

        return 0 <= mx && mx < N && 0 <= my && my < M;
    }
}