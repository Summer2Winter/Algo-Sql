class Solution {
    //좌표평면
    char[] command;
    int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    boolean[][][] visited = new boolean[11][11][4];
    int answer;
    public int solution(String dirs) {
        command = dirs.toCharArray();
        int cx = 5, cy = 5, dir = -1;
        for(int i=0; i<command.length; i++) {
            // 이동
            int nx, ny;
            if(command[i] == 'R') {
                nx = cx + dx[0];
                ny = cy + dy[0];
                dir = 0;
            }
            else if(command[i] == 'D') {
                nx = cx + dx[1];
                ny = cy + dy[1];
                dir = 1;
            }
            else if(command[i] == 'L') {
                nx = cx + dx[2];
                ny = cy + dy[2];
                dir = 2;
            }
            else {
                nx = cx + dx[3];
                ny = cy + dy[3];
                dir = 3;
            }
            if(0 > nx || nx > 10 || 0 > ny || ny > 10)
                continue;
            // 이미 방문
            if(!visited[cx][cy][dir]) {
                visited[nx][ny][(dir+2)%4] = true;
                visited[cx][cy][dir] = true;
                answer++;
            }
            cx = nx;
            cy = ny;
        }
        return answer;
    }
}