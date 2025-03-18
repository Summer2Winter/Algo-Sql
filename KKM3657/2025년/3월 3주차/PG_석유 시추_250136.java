import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    int[][] land;
    int N,M;
    ArrayList<Integer> oil = new ArrayList<>();
    int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    public int solution(int[][] land) {
        this.land = land;
        int answer = 0;
        N = land.length;
        M = land[0].length;

        //land 영역 나누기
        makeLand();

        // 송유관 뚫기
        for(int i=0; i<M; i++) {
            boolean[] visited = new boolean[oil.size()];
            int temp = 0;
            for(int j=0; j<N; j++) {
                // 현재 위치
                int idx = land[j][i] - 2;
                if(land[j][i] == 0 || visited[idx])
                    continue;
                visited[idx] = true;
                temp += oil.get(idx);
            }
            answer = Math.max(answer, temp);
        }
        return answer;
    }
    public void makeLand() {
        int number = 2;
        boolean[][] visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                // 방문 했으면 넘어가기
                if(visited[i][j] || land[i][j] == 0)
                    continue;

                ArrayDeque<int[]> area = new ArrayDeque<>();
                area.add(new int[]{i,j});
                visited[i][j] = true;
                int cnt = 0;
                while(!area.isEmpty()) {
                    int[] curr = area.poll();

                    // 영역표시
                    land[curr[0]][curr[1]] = number;
                    cnt++;

                    for(int k=0; k<4; k++) {
                        int nx = curr[0] + dx[k], ny = curr[1] + dy[k];

                        if(0 > nx || nx >= N || 0 > ny || ny >= M)
                            continue;

                        // 다음 영역 추가
                        if(land[nx][ny] != 0 && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            area.add(new int[]{nx,ny});
                        }
                    }
                }
                // 오일 추가
                oil.add(cnt);
                // 다음 번호
                number++;
            }
        }
    }
}

// DFS 버전
import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    int[][] land;
    int N,M,cnt;
    int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    boolean[][] visited;
    ArrayList<Integer> oil = new ArrayList<>();
    public int solution(int[][] land) {
        this.land = land;
        int answer = 0;
        N = land.length;
        M = land[0].length;

        //land 영역 나누기
        makeLand();

        // 송유관 뚫기
        for(int i=0; i<M; i++) {
            boolean[] line = new boolean[oil.size()];
            int temp = 0;
            for(int j=0; j<N; j++) {
                // 현재 위치
                int idx = land[j][i] - 2;
                if(land[j][i] == 0 || line[idx])
                    continue;
                line[idx] = true;
                temp += oil.get(idx);
            }
            answer = Math.max(answer, temp);
        }
        return answer;
    }
    public void makeLand() {
        int number = 2;
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(visited[i][j] || land[i][j] == 0)
                    continue;
                visited[i][j] = true;
                land[i][j] = number;
                cnt=1;
                dfs(i,j,number);

                // 오일 추가
                oil.add(cnt);
                // 다음 번호
                number++;
            }
        }
    }
    public void dfs(int cx, int cy, int number) {
        // 방문
        for(int i=0; i<4; i++) {
            int nx = cx + dx[i], ny = cy + dy[i];

            if(0 > nx || nx >= N || 0 > ny || ny >= M)
                continue;

            // 다음 영역 추가
            if(land[nx][ny] != 0 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                land[nx][ny] = number;
                cnt++;
                dfs(nx, ny, number);
            }
        }
    }
}