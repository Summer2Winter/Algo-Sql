import java.util.Arrays;
import java.util.PriorityQueue;
class Cost {
    int x;
    int y;
    int dir;
    int cost;

    Cost(int x, int y, int dir, int cost) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cost = cost;
    }
}
class Solution {
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int N = board.length;
        int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
        // 방문기록
        int[][][] cost = new int[N][N][4];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++)
                Arrays.fill(cost[i][j], (int)1e9);
        }


        PriorityQueue<Cost> queue = new PriorityQueue<>((x,y) -> x.cost-y.cost);

        for(int i=0; i<4; i++) {
            queue.add(new Cost(0,0,i,0));
            cost[0][0][i] = 0;
        }


        while(!queue.isEmpty()) {
            Cost curr = queue.poll();
            int currDir = curr.dir;

            if (curr.cost > cost[curr.x][curr.y][currDir])
                continue;

            for(int i=0; i<4; i++) {
                int nx = curr.x + dx[i], ny = curr.y + dy[i];
                if(0 > nx || nx >= N || 0 > ny || ny >= N || board[nx][ny] == 1)
                    continue;

                int newCost = currDir == i ? curr.cost + 100 : curr.cost + 600;
                if(newCost < cost[nx][ny][i]) {
                    cost[nx][ny][i] = newCost;
                    queue.add(new Cost(nx,ny,i,newCost));
                }
            }
        }
        for(int i=0; i<4; i++)
            answer = Math.min(answer, cost[N-1][N-1][i]);
        return answer;
    }
}