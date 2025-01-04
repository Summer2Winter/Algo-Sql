import java.util.PriorityQueue;
import java.util.Arrays;

class Pair {
    int x;
    int y;
    int dir;
    int value;

    Pair(int x, int y, int dir, int value) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.value = value;
    }
}
class Solution {
    public int solution(int[][] board) {
        int answer = 0, N = board.length;
        int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.value - y.value);
        int[][][] visited = new int[N][N][4];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++)
                Arrays.fill(visited[i][j], (int)1e9);
        }

        // 초기화
        for(int i=0; i<4; i++) {
            pq.add(new Pair(0,0,i,0));
            visited[0][0][i] = 0;
        }

        // bfs
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();

            if(curr.x == N-1 && curr.y == N-1) {
                answer = curr.value;
                break;
            }

            for(int i=0; i<4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if(0 > nx || nx >= N || 0 > ny || ny >= N)
                    continue;

                if(board[nx][ny] == 0) {
                    int newCost = curr.dir==i ? curr.value + 100 : curr.value + 600;
                    if(newCost < visited[nx][ny][i]) {
                        pq.add(new Pair(nx,ny,i,newCost));
                        visited[nx][ny][i] = newCost;
                    }
                }
            }
        }
        return answer;
    }
}