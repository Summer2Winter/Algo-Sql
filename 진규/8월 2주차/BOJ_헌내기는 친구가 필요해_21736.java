import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static StringTokenizer st;
    static int answer;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {

            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (board[i][j] == 'I') {
                    bfs(i, j);
                }
            }
        }


        System.out.println(answer != 0 ? answer : "TT");
    }

    private static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {

            int[] qPoll = queue.poll();
            int px = qPoll[0];
            int py = qPoll[1];

            for (int k = 0; k < 4; k++) {
                int mx = px + dx[k];
                int my = py + dy[k];

                if (!isRange(mx, my)) continue;
                if (visited[mx][my]) continue;

                if (board[mx][my] == 'O') {
                    visited[mx][my] = true;
                    queue.add(new int[]{mx, my});
                }
                else if (board[mx][my] == 'P') {
                    answer += 1;
                    visited[mx][my] = true;
                    queue.add(new int[]{mx, my});
                }
            }
        }
    }

    private static boolean isRange(int mx, int my) {

        return 0 <= mx && mx < N && 0 <= my && my < M;
    }
}