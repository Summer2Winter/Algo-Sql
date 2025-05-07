class Solution {
    int n, m;
    int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    char[][] map, temp;
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        int answer = n * m;

        //char 배열로 변환
        map = new char[n+2][m+2];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                map[i][j] = storage[i-1].charAt(j-1);
            }
        }

        // 명령 수행
        for(String request : requests) {
            // 명령어 길이 확인
            int len = request.length();
            char c = request.charAt(0);
            // 배열 복사
            temp = new char[n+2][m+2];
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=m; j++) {
                    temp[i][j] = map[i][j];
                }
            }
            boolean[][] deleteMap = new boolean[n+2][m+2];
            // 지게차
            if(len == 1) {
                temp[0][0] = '*';
                // 외각 체크
                dfs(0,0);
                // 반복문을 활용하여 4방 탐색
                for(int i=1; i<=n; i++) {
                    for(int j=1; j<=m; j++) {
                        // 빈칸 넘어가기, 해당하는 숫자 아니면 넘어가기
                        if(temp[i][j] == '\0' || temp[i][j] == '*' || temp[i][j] != c)
                            continue;
                        // 4방향 탐색
                        for(int k=0; k<4; k++) {
                            int nx = i + dx[k], ny = j + dy[k];
                            // 1개라도 뚫려 있으면 삭제
                            if(temp[nx][ny] == '*') {
                                deleteMap[i][j] = true;
                                break;
                            }
                        }
                    }
                }
                // 삭제
                for(int i=1; i<=n; i++) {
                    for(int j=1; j<=m; j++) {
                        if(deleteMap[i][j]) {
                            map[i][j] = '\0';
                            answer--;
                        }
                    }
                }
            }
            // 크레인
            else {
                // 해당하는 알파벳 삭제
                for(int i=1; i<=n; i++) {
                    for(int j=1; j<=m; j++) {
                        if(map[i][j] == c) {
                            map[i][j] = '\0';
                            answer--;
                        }
                    }
                }
            }
        }
        // 남는 화물 갯수
        return answer;
    }
    public void dfs(int cx, int cy) {
        for(int i=0; i<4; i++) {
            int nx = cx + dx[i], ny = cy + dy[i];
            if(0 > nx || nx > n+1 || 0 > ny || ny > m+1)
                continue;
            if(temp[nx][ny] == '\0') {
                temp[nx][ny] = '*';
                dfs(nx,ny);
            }
        }
    }
}