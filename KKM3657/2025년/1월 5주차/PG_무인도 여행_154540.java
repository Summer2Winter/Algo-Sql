import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    int N, M, temp;
    char[][] map;
    boolean[][] visited;
    ArrayList<Integer> answerList = new ArrayList<>();
    int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    public int[] solution(String[] maps) {
        // 지도
        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String str = maps[i];
            for(int j=0; j<M; j++)
                map[i][j] = str.charAt(j);
        }

        // dfs
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                // 이미 방문했거나 X면 넘어감
                if(visited[i][j] || map[i][j] == 'X')
                    continue;
                // 방문
                visited[i][j] = true;
                temp = map[i][j] - '0';
                calculateDay(i, j);
                answerList.add(temp);
            }
        }
        if(answerList.isEmpty())
            return new int[]{-1};

        int[] answer = new int[answerList.size()];
        int idx = 0;
        for(Integer value : answerList)
            answer[idx++] = value;
        Arrays.sort(answer);
        return answer;
    }
    public void calculateDay(int cx, int cy) {
        for(int i=0; i<4; i++) {
            int nx = cx + dx[i], ny = cy + dy[i];

            if(0 > nx || nx >= N || 0 > ny || ny >= M)
                continue;

            if(map[nx][ny] != 'X' && !visited[nx][ny]) {
                visited[nx][ny] = true;
                temp += (map[nx][ny] - '0');
                calculateDay(nx, ny);
            }
        }
    }
}