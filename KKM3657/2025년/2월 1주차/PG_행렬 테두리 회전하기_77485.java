class Solution {
    int[][] grid;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        grid = new int[rows+1][columns+1];
        int value = 1;
        // 기본 배열 만들기
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=columns; j++)
                grid[i][j] = value++;
        }

        int idx = 0;
        // 쿼리 시행
        for(int[] query : queries) {
            answer[idx++] = rotateArr(query[0], query[1], query[2], query[3]);
        }
        return answer;
    }

    public int rotateArr(int cx, int cy, int ex, int ey) {
        int min = grid[cx+1][cy];
        // 상단
        int prev = grid[cx+1][cy];
        for(int i=cy; i<ey; i++) {
            min = Math.min(min, grid[cx][i]);
            int temp = grid[cx][i]; // 현재 위치 저장
            grid[cx][i] = prev; // 갱신
            prev = temp;
        }

        // 오른쪽
        for(int i=cx; i<ex; i++) {
            min = Math.min(min, grid[i][ey]);
            int temp = grid[i][ey];
            grid[i][ey] = prev;
            prev = temp;
        }

        // 하단
        for(int i=ey; i>cy; i--) {
            min = Math.min(min, grid[ex][i]);
            int temp = grid[ex][i];
            grid[ex][i] = prev;
            prev = temp;
        }

        // 왼쪽
        for(int i=ex; i>cx; i--) {
            min = Math.min(min, grid[i][cy]);
            int temp = grid[i][cy];
            grid[i][cy] = prev;
            prev = temp;
        }

        return min;
    }
}