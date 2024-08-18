import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;
    static int[][] zeroGroup;
    static int zeroKey = 1;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static Map<Integer, Integer> zeroMap = new HashMap<>();

    static StringTokenizer st;
    static String str;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            
            str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        
        // 이동할 수 있는 곳(0)을 그룹화 해서 구별
        zeroGroup = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && board[i][j] == 0) {
                    bfs(i, j);
                    zeroKey += 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (board[i][j] == 0) {
                    sb.append(0);
                }
                else if (board[i][j] == 1) {

                    // 같은 그룹인 경우 중복 방지를 위해 Set 사용
                    Set<Integer> zeroSet = new HashSet<>();

                    for (int k = 0; k < 4; k++) {

                        int mi = i + dx[k];
                        int mj = j + dy[k];

                        if (!isRange(mi, mj)) continue;

                        if (board[mi][mj] == 0) {
                            zeroSet.add(zeroGroup[mi][mj]);
                        }
                    }

                    int moveCnt = 1;
                    for (int key : zeroSet) {
                        moveCnt += zeroMap.get(key);
                    }
                    sb.append(moveCnt % 10);
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        zeroGroup[x][y] = zeroKey;
        int zeroCnt = 1;

        while (!queue.isEmpty()) {
            int[] qPoll = queue.poll();
            int px = qPoll[0];
            int py = qPoll[1];

            for (int k = 0; k < 4; k++) {
                int mx = px + dx[k];
                int my = py + dy[k];

                if (!isRange(mx, my)) continue;
                if (visited[mx][my]) continue;

                if (board[mx][my] == 0) {
                    visited[mx][my] = true;
                    zeroGroup[mx][my] = zeroKey;
                    queue.add(new int[]{mx, my});
                    zeroCnt += 1;
                }
            }
        }

        zeroMap.put(zeroKey, zeroCnt);
    }

    private static boolean isRange(int mx, int my) {
        return 0 <= mx && mx < N && 0 <= my && my < M;
    }
}