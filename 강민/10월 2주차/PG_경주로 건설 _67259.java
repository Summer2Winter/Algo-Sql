import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {
    int x;
    int y;
    int dir;
    int cost;

    Pair(int x, int y, int dir, int cost) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cost = cost;
    }
}
class Solution {
    int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    public int solution(int[][] board) {
        int answer = 0;
        int N = board.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> {
            return x.cost - y.cost;
        });

        int[][][] dp = new int[N][N][4];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++)
                Arrays.fill(dp[i][j], (int)1e9);
        }

        for(int i=0; i<4; i++) {
            int nx = dx[i], ny = dy[i];
            if(0 > nx || nx >= N || 0 > ny || ny >= N)
                continue;
            if(board[nx][ny] == 0) {
                pq.add(new Pair(nx,ny,i,100));
                dp[nx][ny][i] = 100;
            }
        }
        // BFS
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();

            int cx = curr.x, cy = curr.y, dir = curr.dir, cost = curr.cost;

            if(cx == N-1 && cy == N-1) {
                return cost;
            }

            // 4방향 이동
            for(int i=0; i<4; i++) {
                int nx = cx + dx[i], ny = cy + dy[i];
                if(0 > nx || nx >= N || 0 > ny || ny >= N)
                    continue;
                if(board[nx][ny] == 0) {
                    int newCost = dir==i ? cost + 100 : cost + 600;
                    if(newCost < dp[nx][ny][i]) {
                        pq.add(new Pair(nx,ny,i,newCost));
                        dp[nx][ny][i] = newCost;
                    }
                }
            }
        }
        return answer;
    }
}

// 1차 시도에서는 DFS에 백 트래킹의 방식으로 풀었었다. 하지만 시간 초과가 나왔고 다른 방법을 고민하게 되었다.
// 2차 시도에서는 BFS에 우선순위 큐를 사용하는 방식을 고민하였다. 하지만 이 부분에서도 시간 초과 + 메모리 초과가 발생하였다.
// 3차 시도에서는 DP + DFS로 문제를 해결하려고 하였다. 하지만 이 방법에서는 문제를 해결하지 못하였다.
// 결국 답지를 보게 되었고 2차 시도에서 dp즉 방향성에 대한 내용에서 최소가 되는 조건을 넣어야 되는 것이였다...
/*
class Solution {
    int[][] grid;
    int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    int N, answer = Integer.MAX_VALUE;
    boolean[][] visited;
    public int solution(int[][] board) {
        grid = board;
        N = board.length;
        visited = new boolean[N][N];
        // 4방향 시작 - 시작점
        for(int i=0; i<4; i++) {
            int nx = 0 + dx[i], ny = 0 + dy[i];

            if(0 > nx || nx >= N || 0 > ny || ny >= N)
                continue;
            // 다음 지점 방문
            if(grid[nx][ny] == 0 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx,ny,i,100);
                visited[nx][ny] = false;
            }

        }
        if(answer == Integer.MAX_VALUE)
            return 0;
        return answer;
    }

    public void dfs(int cx, int cy, int dir, int value) {
        // 도착
        if(cx == N-1 && cy == N-1) {
            answer = Math.min(answer, value);
            return;
        }
        // 최소가 될 수 없는 경우
        if(answer < value)
            return;

        // 다음지점 이동
        for(int i=0; i<4; i++) {
            int nx = cx + dx[i], ny = cy + dy[i];

            if(0 > nx || nx >= N || 0 > ny || ny >= N)
                continue;
            // 방문했던 곳이면 넘어감
            if(grid[nx][ny] == 0 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                // 직선 코스
                if(dir == i) {
                    dfs(nx,ny,i,value + 100);
                }
                // 코너 코스
                else {
                    dfs(nx,ny,i,value + 600);
                }
                visited[nx][ny] = false;
            }
        }
    }
}
 */