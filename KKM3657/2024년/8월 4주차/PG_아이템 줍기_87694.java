import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    int[][] grid = new int[105][105];
    int[][] step = new int[105][105];
    boolean[][] visited = new boolean[105][105];
    int[] dx = new int[]{1,0,-1,0}, dy = new int[]{0,-1,0,1};
    public int solution(int[][] rectangles, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        // 격자점 채우기
        for(int[] rectangle : rectangles) {
            int x1 = rectangle[0]*2, y1 = rectangle[1]*2;
            int x2 = rectangle[2]*2, y2 = rectangle[3]*2;
            for(int i=x1; i<=x2; i++) {
                for(int j=y1; j<=y2; j++) {
                    if(i == x1 || i == x2 || j == y1 || j == y2) {
                        if(grid[i][j] == 2)
                            continue;
                        grid[i][j] = 1;
                    }
                    else {
                        grid[i][j] = 2;
                    }
                }
            }
        }
        answer = bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        return answer;
    }
    public int bfs(int cx, int cy, int itemX, int itemY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{cx,cy,0});
        visited = new boolean[105][105];
        visited[cx][cy] = true;
        int answer = 1;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            if(curr[0] == itemX && curr[1] == itemY) {
                answer = curr[2] / 2;
                break;
            }
            for(int i=0; i<4; i++) {
                int nx = curr[0] + dx[i], ny = curr[1] + dy[i];
                if(0 > nx || nx > 101 || 0 > ny || ny > 101)
                    continue;
                if(!visited[nx][ny] && grid[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny,curr[2] + 1});
                }
            }
        }

        return answer;
    }
}