class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        // 배열 만들기
        int[][] grid = new int[rows][columns];
        int value = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++)
                grid[i][j] = value++;
        }

        // 배열 회전하기
        for(int k=0; k<queries.length; k++) {
            // 회전시키기
            int[] query = queries[k];
            int sx = query[0]-1, sy = query[1]-1;
            int ex = query[2]-1, ey = query[3]-1;
            int min = Integer.MAX_VALUE;

            // 첫줄
            int temp1 = grid[sx][ey];
            min = Math.min(min, temp1);
            for(int c=ey; c>sy; c--) {
                grid[sx][c] = grid[sx][c-1];
                min = Math.min(min, grid[sx][c]);
            }

            // 오른쪽
            int temp2 = grid[ex][ey];
            min = Math.min(min, temp2);
            for(int r=ex; r>sx+1; r--){
                grid[r][ey] = grid[r-1][ey];
                min = Math.min(min, grid[r-1][ey]);
            }
            grid[sx+1][ey] = temp1;

            // 아래
            int temp3 = grid[ex][sy];
            min = Math.min(min, temp3);
            for(int c=sy; c<ey-1; c++) {
                grid[ex][c] = grid[ex][c+1];
                min = Math.min(min, grid[ex][c]);
            }
            grid[ex][ey-1] = temp2;

            // 오른쪽
            for(int r=sx; r<ex-1; r++){
                grid[r][sy] = grid[r+1][sy];
                min = Math.min(min, grid[r+1][sy]);
            }
            grid[ex-1][sy] = temp3;
            answer[k]=min;
        }
        return answer;
    }
}