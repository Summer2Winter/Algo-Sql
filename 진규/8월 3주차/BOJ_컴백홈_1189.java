import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int R, C, K;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static StringTokenizer st;
    static int answer;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {

            board[i] = br.readLine().toCharArray();
        }

        visited[R-1][0] = true;
        backtracking(0, R-1, 0);

        System.out.println(answer);
    }

    private static void backtracking(int depth, int x, int y) {

        if (depth == K-1) {
            if (x == 0 && y == C-1) // 도착지에 도착하는 경우
                answer += 1;
            return;
        }

        for (int k = 0; k < 4; k++) {
            int mx = x + dx[k];
            int my = y + dy[k];

            if (!isRange(mx, my)) continue;

            if (board[mx][my] == '.' && !visited[mx][my]) {
                visited[mx][my] = true;
                backtracking(depth+1, mx, my);
                visited[mx][my] = false;
            }
        }
    }

    private static boolean isRange(int mx, int my) {

        return 0 <= mx && mx < R && 0 <= my && my < C;
    }
}