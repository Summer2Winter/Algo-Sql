import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T, l, sx, sy, ex, ey;

    static int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1}, dy = {-1, 1, 2, 2, 1, -1, -2, -2};
    static int[][] board;
    static boolean[][] visited;

    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());

            board = new int[l][l];
            visited = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            bfs();

            System.out.println(board[ex][ey]);
        }
    }

    private static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy});
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {

            int[] qPoll = queue.poll();
            int px = qPoll[0];
            int py = qPoll[1];

            if (px == ex && py == ey) break;

            for (int k = 0; k < 8; k++) {

                int mx = px + dx[k];
                int my = py + dy[k];

                if (isRange(mx, my) && !visited[mx][my]) {

                    visited[mx][my] = true;
                    board[mx][my] = board[px][py] + 1;
                    queue.add(new int[]{mx, my});
                }
            }
        }
    }

    private static boolean isRange(int mx, int my) {

        return 0 <= mx && mx < l && 0 <= my && my < l;
    }
}