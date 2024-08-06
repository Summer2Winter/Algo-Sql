class Solution {
    int[][] grid;
    int[] cols;
    int answer = 0;
    public int solution(int n) {
        cols = new int[n];
        grid = new int[n][n];
        placeQueen(0,n);
        return answer;
    }
    public void placeQueen(int curr, int n) {
        // 마지막 퀸까지 놓는경우
        if(curr == n) {
            answer++;
            // for(int i=0; i<n; i++) {
            //     for(int j=0; j<n; j++) {
            //         System.out.print(grid[i][j]);
            //     }
            //     System.out.println();
            // }
            // System.out.println();
            return;
        }
        // 현재 행에서 놓을수 있는 열 선택하기
        for(int col=0; col<n; col++) {
            if(isPossible(curr, col, n)) {
                // 열에 따른 어떤 행에 queen을 놨는지 기록
                cols[curr] = col;
                grid[curr][col] = 1;
                placeQueen(curr+1, n);

                cols[curr] = 0;
                grid[curr][col] = 0;
            }
        }
    }

    public boolean isPossible(int row, int col, int n) {
        for(int i=0; i<row; i++) {
            if(cols[i] == col || Math.abs(row - i) == Math.abs(col - cols[i]))
                return false;
        }
        return true;
    }
}