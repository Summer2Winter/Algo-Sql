import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Queue;
import java.util.PriorityQueue;

class Node {
    int x, y, dir, corners;

    public Node(int x, int y, int dir, int corners) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.corners = corners;
    }
}

public class Main {
    static int N, M, answer = Integer.MAX_VALUE;
    static char[][] grid;
    static int[][][] dp; // 각 좌표에서 4방향에 대해 저장되는 코너 개수
    static int[] cx, cy;
    static int[] dx = new int[]{0, 1, 0, -1}, dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행

        grid = new char[N][M];
        cx = new int[2];
        cy = new int[2];
        dp = new int[N][M][4]; // 각 좌표에서 방향별 코너 개수를 저장

        int idx = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = input.charAt(j);
                if (grid[i][j] == 'C') {
                    cx[idx] = i;
                    cy[idx] = j;
                    idx++;
                }
                for (int d = 0; d < 4; d++) {
                    dp[i][j][d] = Integer.MAX_VALUE; // 큰 값으로 초기화
                }
            }
        }

        // BFS 시작
        bfs();

        // 결과 출력: 도착점에서 최소 코너 개수를 구한다.
        System.out.println(answer);
    }

    public static void bfs() {
        Queue<Node> queue = new PriorityQueue<>((x,y) -> {
            return x.corners - y.corners;
        });

        // 첫 번째 C의 좌표에서 4방향 모두를 초기화
        for (int i = 0; i < 4; i++) {
            dp[cx[0]][cy[0]][i] = 0;
            queue.add(new Node(cx[0], cy[0], i, 0));
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            // 도착점에 도달했을 경우 최소 코너 개수를 갱신
            if (cur.x == cx[1] && cur.y == cy[1]) {
                answer = Math.min(answer, cur.corners);
                return;
            }

            // 4방향으로 이동
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || grid[nx][ny] == '*')
                    continue;

                // 코너가 생기는 경우와 그렇지 않은 경우 구분
                int newCorners = cur.corners + (cur.dir == i ? 0 : 1);

                // 새로운 경로가 더 적은 코너로 도달할 수 있는 경우만 갱신
                if (newCorners < dp[nx][ny][i]) {
                    dp[nx][ny][i] = newCorners;
                    queue.offer(new Node(nx, ny, i, newCorners));
                }
            }
        }
    }
}