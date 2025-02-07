import java.util.ArrayDeque;

class Pair {
    int x;
    int y;
    int cnt;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Pair(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        int N = board.length, M = board[0].length();
        char[][] grid = new char[N][M];
        int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
        Pair start = new Pair(0,0,0), end = new Pair(0,0,0);
        // 시작 위치, 끝 위치 찾기
        for(int i=0; i<N; i++) {
            String input = board[i];
            for(int j=0; j<M; j++) {
                grid[i][j] = input.charAt(j);
                if(grid[i][j] == 'G')
                    end = new Pair(i,j);
                else if(grid[i][j] == 'R')
                    start = new Pair(i,j);
            }
        }

        // BFS
        boolean[][] visited = new boolean[N][M];
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(start.x, start.y, 0));
        visited[start.x][start.y] = true;

        while(!queue.isEmpty()) {
            Pair curr = queue.poll();
            // 종료
            if(curr.x == end.x && curr.y == end.y) {
                answer = curr.cnt;
                break;
            }
            // 4방향 탐색
            for(int i=0; i<4; i++) {
                int cx = curr.x, cy = curr.y;
                // 현재위치에서 끝점, D가 나올때까지 이동
                while(true) {
                    int nx = cx + dx[i], ny = cy + dy[i];

                    if(0 > nx || nx >= N || 0 > ny || ny >= M || grid[nx][ny] == 'D')
                        break;

                    cx = nx;
                    cy = ny;
                }
                if(!visited[cx][cy]) {
                    visited[cx][cy] = true;
                    queue.add(new Pair(cx,cy,curr.cnt+1));
                }
            }
        }
        return answer;
    }
}