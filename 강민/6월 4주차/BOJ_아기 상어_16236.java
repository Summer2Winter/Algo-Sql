import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Queue;
import java.util.LinkedList;

class Pair {
    int x;
    int y;
    int distance;

    Pair(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
public class Main {
    static int N, answer = 0, sharkSize = 2, cnt = 0;
    static int[][] grid;
    static Pair shark;
    static int[] dx = new int[]{-1,0,0,1}, dy = new int[]{0,-1,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grid = new int[N][N];

        // 지도 그리기 및 물고기 개수 확인
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 9)
                    shark = new Pair(i,j,0);
            }
        }

        // 상어 움직이기
        while(true) {
            moveShark();
        }
    }

    // 상어 움직이기
    public static void moveShark() {
        // 거리, 위쪽, 왼쪽에 따른 최소 지점을 나타낼 우선순위 큐 선언
        PriorityQueue<Pair> pq = new PriorityQueue(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                // 거리가 같은 경우
                if(p1.distance == p2.distance) {
                    // 위쪽, 왼쪽
                    return p1.x == p2.x ? p1.y - p2.y : p1.x - p2.x;
                }
                else {
                    return p1.distance - p2.distance;
                }
            }
        });

        // 이동할 수 있는 장소 탐색(BFS)
        Queue<Pair> q = new LinkedList<>();
        q.add(shark);
        boolean[][] visited = new boolean[N][N];
        visited[shark.x][shark.y] = true;
        int distance = 0;

        // 탐색
        while(!q.isEmpty()) {
            Pair curr = q.poll();

            for(int i=0; i<4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                // 다음으로 이동할 지점이 빈칸인 경우
                if((grid[nx][ny] == 0 || grid[nx][ny] == sharkSize) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny, curr.distance + 1));
                }

                // 먹을 수 있는 경우, 최소 거리인 경우
                else if(grid[nx][ny] < sharkSize && distance <= curr.distance && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    pq.add(new Pair(nx, ny, curr.distance + 1));
                }
            }
        }

        // 엄마 상어 호출
        if(pq.isEmpty()) {
            System.out.println(answer);
            System.exit(0);
        }

        // 해당하는 물고기 섭취
        grid[shark.x][shark.y] = 0;

        Pair eat = pq.poll();
        grid[eat.x][eat.y] = 9;

        answer += eat.distance;
        cnt++;
        // 상어 위치 이동
        shark = eat;
        shark.distance = 0;

        // 크기 조정
        if(cnt == sharkSize) {
            cnt = 0;
            sharkSize++;
        }
    }
}