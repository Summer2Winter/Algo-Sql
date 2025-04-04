class Solution {
    char[][] map, temp;
    int M,N;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        M = m;
        N = n;
        map = new char[m][n];
        // 지도
        for(int i=0; i<m; i++) {
            String input = board[i];
            for(int j=0; j<n; j++)
                map[i][j] = input.charAt(j);
        }
        //반복
        while(true) {
            // 지울 내용 체크
            temp = checkMap();
            // 지우기
            int result = deleteMap();
            if(result == 0)
                break;
            answer += result;
            // 내리기
            moveMap();
            map = temp;
        }
        return answer;
    }
    public void moveMap() {
        for(int j=0; j<N; j++) {
            int idx = M-1;
            for(int i=M-1; i>=0; i--) {
                // 빈칸이 아닌 경우
                if(temp[i][j] != '\0') {
                    temp[idx][j] = temp[i][j];
                    if(idx != i)
                        temp[i][j] = '\0';
                    idx--;
                }
            }
        }
    }
    public int deleteMap() {
        int result = 0;
        // -1인 부분 지우기
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(temp[i][j] == '*') {
                    temp[i][j] = '\0';
                    result++;
                }
            }
        }
        return result;
    }
    public char[][] checkMap() {
        // 임시 배열
        char[][] tempArr = new char[M][N];
        for(int i=0; i<M-1; i++) {
            for(int j=0; j<N-1; j++) {
                if(map[i][j] == '\0')
                    continue;
                // 4개 같은지 체크
                boolean flag = true;
                for(int l=0; l<2; l++) {
                    for(int k=0; k<2; k++) {
                        if(map[i][j] != map[i+l][j+k])
                            flag = false;
                    }
                }
                // 같은 경우 지울 내용으로 저장
                if(flag) {
                    for(int l=0; l<2; l++) {
                        for(int k=0; k<2; k++) {
                            tempArr[i+l][j+k] = '*';
                        }
                    }
                }
            }
        }
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(tempArr[i][j] != '*')
                    tempArr[i][j] = map[i][j];
            }
        }
        return tempArr;
    }
    public void printMap(char[][] arr) {
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] == '\0')
                    System.out.print(" ");
                else
                    System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}