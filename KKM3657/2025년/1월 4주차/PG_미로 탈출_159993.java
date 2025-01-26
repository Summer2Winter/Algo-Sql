import java.util.ArrayDeque;

class Pair {
    int x;
    int y;
    int time;

    Pair(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        int N = maps.length, M = maps[0].length();
        boolean[][] visited = new boolean[N][M];
        int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};

        int sx=0, sy=0, ex=0, ey=0, lx=0, ly=0;
        // map 변환
        char[][] map = new char[N][M];
        for(int i=0; i<N; i++) {
            String temp = maps[i];
            for(int j=0; j<M; j++)
                map[i][j] = temp.charAt(j);
        }
        // 입구, 출구, 레버 찾기
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
                else if(map[i][j] == 'E') {
                    ex = i;
                    ey = j;
                }
                else if(map[i][j] == 'L') {
                    lx = i;
                    ly = j;
                }
            }
        }
        // 레버까지 가능 최단 거리
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(sx,sy,0));

        visited[sx][sy] = true;
        boolean isPossible = false;
        while(!queue.isEmpty()) {
            Pair curr = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = curr.x + dx[i], ny = curr.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                // 벽만 아닌 경우
                if(!visited[nx][ny] && map[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    // 레버인 경우
                    if(nx == lx && ny == ly) {
                        isPossible = true;
                        answer = curr.time+1;
                        break;
                    }
                    queue.add(new Pair(nx, ny, curr.time+1));
                }
            }
        }
        if(!isPossible)
            return -1;

        // 레버에서 출구까지의 최단 거리
        queue = new ArrayDeque<>();
        queue.add(new Pair(lx,ly,answer));
        visited = new boolean[N][M];
        visited[lx][ly] = true;
        isPossible = false;
        while(!queue.isEmpty()) {
            Pair curr = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = curr.x + dx[i], ny = curr.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                // 벽만 아닌 경우
                if(!visited[nx][ny] && map[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    // 출구인 경우
                    if(nx == ex && ny == ey) {
                        isPossible = true;
                        answer = curr.time+1;
                        break;
                    }
                    queue.add(new Pair(nx, ny, curr.time+1));
                }
            }
        }
        if(!isPossible)
            return -1;
        return answer;
    }
}