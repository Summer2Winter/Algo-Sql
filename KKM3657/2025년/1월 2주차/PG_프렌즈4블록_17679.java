class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        // 단어 배열 변환
        char[][] charArr = new char[m][n];
        for(int i=0; i<m; i++)
            charArr[i] = board[i].toCharArray();

        // 반복문
        while(true) {
            char[][] tempArr = new char[m][n];

            // 블록 복사
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    tempArr[i][j] = charArr[i][j];
                }
            }
            // 사라질 블록 탐색
            boolean[][] disappear = new boolean[m][n];
            for(int i=0; i<m-1; i++) {
                for(int j=0; j<n-1; j++) {
                    //4방향 탐색
                    char temp = charArr[i][j];
                    if(temp == '\u0000')
                        continue;
                    if(temp == charArr[i][j+1] && temp == charArr[i+1][j] && temp == charArr[i+1][j+1]) {
                        disappear[i][j] = true;
                        disappear[i][j+1] = true;
                        disappear[i+1][j] = true;
                        disappear[i+1][j+1] = true;
                    }
                }
            }
            int cnt = 0;
            // 블록 지우기
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(disappear[i][j]) {
                        tempArr[i][j] = '1';
                        cnt++;
                    }
                }
            }
            if(cnt == 0)
                break;
            else
                answer += cnt;
            // 블록 옮기기
            char[][] resultArr = new char[m][n];
            for(int j=0; j<n; j++) {
                int idx = m-1;
                for(int i=m-1; i>=0; i--){
                    // 터진 부분이면
                    if (tempArr[i][j] != '1') {
                        resultArr[idx][j] = tempArr[i][j];
                        idx--;
                    }
                }
            }
            charArr = resultArr;
        }
        return answer;
    }
}