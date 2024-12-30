class Solution {
    public int solution(String dirs) {
        int answer = 0;
        // 격자점의 방문을 위해 점 직선으로 배열을 만듬
        boolean[][] visited = new boolean[22][22];
        int[] dx = new int[]{-1,1,0,0}, dy = new int[]{0,0,1,-1};

        int dirX = 6, dirY = 6;

        for(int i=0; i<dirs.length(); i++) {
            char dir = dirs.charAt(i);
            int nx = 0, ny = 0;
            if(dir == 'U') {
                nx = dirX + dx[0];
                ny = dirY + dy[0];
            }
            else if(dir == 'D') {
                nx = dirX + dx[1];
                ny = dirY + dy[1];
            }
            else if(dir == 'R') {
                nx = dirX + dx[2];
                ny = dirY + dy[2];
            }
            else {
                nx = dirX + dx[3];
                ny = dirY + dy[3];
            }
            if(nx < 1 || nx > 11 || ny < 1 || ny > 11)
                continue;

            if(!visited[dirX+nx-1][dirY+ny-1]){
                visited[dirX+nx-1][dirY+ny-1] = true;
                answer++;
            }
            dirX = nx;
            dirY = ny;
        }
        return answer;
    }
}