import java.util.LinkedList;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    LinkedList<Pair> pList;
    char[][] grid;
    boolean[][] visited;
    int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for(int t=0; t<5; t++) {
            pList = new LinkedList<>();
            // 맵 생성
            grid = new char[5][5];
            for(int i=0; i<5; i++) {
                String input = places[t][i];
                for(int j=0; j<5; j++) {
                    grid[i][j] = input.charAt(j);
                    if(grid[i][j] == 'P')
                        pList.add(new Pair(i,j));
                }
            }

            boolean flag = false;

            // pList에 해당하는 부분에서 DFS
            while(!pList.isEmpty()) {
                Pair curr = pList.poll();
                visited = new boolean[5][5];
                visited[curr.x][curr.y] = true;

                // 맨허튼 거리가 2이내에 P가 있으면 불가능
                if(!isPossible(curr.x, curr.y, 0)) {
                    flag = true;
                    break;
                }
            }
            if(!flag)
                answer[t] = 1;
        }
        return answer;
    }
    public boolean isPossible(int x, int y, int cnt) {
        // 거리가 2이하에 P가 있으면 불가능
        if(cnt == 2) {
            if(grid[x][y] == 'P')
                return false;
            else
                return true;
        }

        boolean flag = true;

        // 4방향 탐색
        for(int i=0; i<4; i++) {
            int nx = x + dx[i], ny = y + dy[i];

            if(0 > nx || nx >= 5 || 0 > ny || ny >= 5)
                continue;

            // 확인해야 될 부분
            if(!visited[nx][ny] && grid[nx][ny] != 'X') {
                visited[nx][ny] = true;
                if(grid[nx][ny] == 'P') {
                    return false;
                }
                // 다음 확인
                else {
                    if(!isPossible(nx, ny, cnt+1))
                        return false;
                }
            }
        }
        return flag;
    }
}