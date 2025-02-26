class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] diff = new int[n+1][m+1];
        // 파싱
        for(int[] effect : skill) {
            int type = effect[0];
            int sx = effect[1], sy = effect[2];
            int ex = effect[3], ey = effect[4];
            int degree = (type == 1 ? -effect[5] : effect[5]);

            // 누적합을 이용해서 나타내는 방법
            diff[sx][sy] += degree;
            diff[sx][ey+1] -= degree;
            diff[ex+1][sy] -= degree;
            diff[ex+1][ey+1] += degree;
        }

        // 누적합 적용 - 가로
        for(int i=0; i<n; i++){
            for(int j=1; j<m; j++)
                diff[i][j] += diff[i][j-1];
        }

        // 누적합 적용 - 세로
        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++)
                diff[i][j] += diff[i-1][j];
        }

        // diff 적용
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] + diff[i][j] > 0)
                    answer++;
            }
        }
        return answer;
    }
}