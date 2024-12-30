import java.util.ArrayDeque;
class Pair {
    int x;
    int y;
    int cnt;

    Pair(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
class Solution {
    int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    public int solution(int[][] maps) {
        int answer = -1, N = maps.length, M = maps[0].length;
        boolean[][] visited = new boolean[N][M];

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        //시작점 추가
        queue.add(new Pair(0,0,1));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Pair curr = queue.poll();

            // 도달 하는지 확인
            if(curr.x == N-1 && curr.y == M-1) {
                answer = curr.cnt;
                break;
            }

            for(int i=0; i<4; i++) {
                int nx = curr.x + dx[i], ny = curr.y + dy[i];

                if(0 > nx || nx >= N || 0 > ny || ny >= M)
                    continue;

                // 벽 없는 곳
                if(maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Pair(nx,ny,curr.cnt+1));
                }
            }
        }
        return answer;
    }
}