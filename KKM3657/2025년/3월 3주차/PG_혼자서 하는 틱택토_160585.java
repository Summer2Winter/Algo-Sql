class Solution {
    public int solution(String[] board) {
        // grid 생성
        char[][] grid = new char[3][3];
        for(int i=0; i<3; i++) {
            String input = board[i];
            for(int j=0; j<3; j++) {
                grid[i][j] = input.charAt(j);
            }
        }
        int o = 0, x = 0;
        // O,X 개수 차이가 1이하로 차이가 나야됨
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(grid[i][j] == 'O')
                    o++;
                else if(grid[i][j] == 'X')
                    x++;
            }
        }

        // 개수 차이가 2이상이면 불가능, x가 더 많으면 불가능
        if (x > o || o - x > 1)
            return 0;

        // 승리 여부 체크
        boolean oWin = checkWin(grid, 'O');
        boolean xWin = checkWin(grid, 'X');

        // 둘 다 승리하는 경우는 불가능
        if (oWin && xWin) return 0;
        // O가 승리한 경우, O의 개수가 X보다 정확히 1개 더 많아야 함
        if (oWin && o != x + 1) return 0;
        // X가 승리한 경우, O와 X 개수가 같아야 함
        if (xWin && o != x) return 0;

        return 1;
    }
    public boolean checkWin(char[][] grid, char player) {
        // 가로, 세로, 대각선 검사
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == player && grid[i][1] == player && grid[i][2] == player)
                return true; // 가로
            if (grid[0][i] == player && grid[1][i] == player && grid[2][i] == player)
                return true; // 세로
        }
        // 대각선 검사
        if (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player)
            return true;
        if (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player)
            return true;
        return false;
    }
}