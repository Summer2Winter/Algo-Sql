class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];
        int[] dx = {-1, 1, 0, 0};  // 상, 하, 우, 좌
        int[] dy = {0, 0, 1, -1};
        int dirX = 5, dirY = 5;

        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            int nx = dirX, ny = dirY;
            int temp = -1;
            // 방향에 따른 다음 좌표 계산
            if (dir == 'U') {
                nx += dx[0];
                ny += dy[0];
                temp = 0;
            } else if (dir == 'D') {
                nx += dx[1];
                ny += dy[1];
                temp = 3;
            } else if (dir == 'R') {
                nx += dx[2];
                ny += dy[2];
                temp = 1;
            } else if (dir == 'L') {
                nx += dx[3];
                ny += dy[3];
                temp = 2;
            }

            // 범위를 벗어나는 경우 무시
            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;

            // 새로운 경로인 경우, 방문 기록 넣기 (-> 이면 <-도 포함)
            if (!visited[dirX][dirY][temp]&& !visited[nx][ny][3-temp]) {
                visited[dirX][dirY][temp] = true;
                visited[nx][ny][3-temp] = true;
                answer++;
            }

            // 다음 위치로 이동
            dirX = nx;
            dirY = ny;
        }

        return answer;
    }
}

// 기존에 방문했던 곳이 있는지 확인하기 위해 3차원 배열을 사용했으며, 기존에서 -> 가는 것과 다음 지점에서 <- 가는 방법은
// 똑같은 경로이기 때문에 방향성을 설정한 뒤 반영하도록 했다.