import java.util.Queue;
import java.util.ArrayDeque;

class Pair {
    int x;
    int y;
    int value;

    Pair(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
class Solution {
    int n, m;
    int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        answer = bfs(maps);
        return answer;
    }

    public int bfs(int[][] maps) {
        // 초기화
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> q = new ArrayDeque<>();
        // 시작위치 추가
        q.add(new Pair(0,0,1));
        visited[0][0] = true;

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int value = curr.value;
            for(int i=0; i<4; i++) {
                int nx = curr.x + dx[i], ny = curr.y + dy[i];

                if(0 > nx || nx >= n || 0 > ny || ny >= m)
                    continue;

                if(maps[nx][ny] != 0 && !visited[nx][ny]) {
                    if(nx == n-1 && ny == m-1) {
                        return value + 1;
                    }
                    visited[nx][ny] = true;
                    q.add(new Pair(nx,ny,value + 1));
                }
            }
        }
        return -1;
    }
}