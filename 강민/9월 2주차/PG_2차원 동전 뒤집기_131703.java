class Solution {
    int N, M, answer = Integer.MAX_VALUE;
    int[][] diff, end;
    public int solution(int[][] beginning, int[][] target) {

        N = beginning.length;
        M = beginning[0].length;
        diff = new int[N][M];
        end = target;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++)
                diff[i][j] = beginning[i][j];
        }

        dfs(0, 0);

        if(answer == Integer.MAX_VALUE){
            answer = -1;
        };

        return answer;
    }

    public void dfs(int r, int cnt) {
        // 행을 다 뒤집은 경우
        if(r == N) {
            boolean flag = true;
            // 열 뒤집기
            for(int i=0; i<M; i++){
                int result = compare_col(i);
                if(result == -1) {
                    flag = false;
                    break;
                }
                cnt += result; //전부 반대일 경우 +1
            }

            if(flag){
                answer = Math.min(answer, cnt);
            }
            return;

        }
        flip_row(r); //행 뒤집기
        dfs(r+1, cnt+1); //행을 뒤집는 경우
        flip_row(r); //다시 원상태로

        dfs(r+1, cnt); //행을 뒤집지 않는 경우
    }

    public void flip_row(int r){
        for(int i=0; i<M; i++){
            diff[r][i] = 1 - diff[r][i];
        }
    }

    public int compare_col(int c){
        int check = 0;
        for(int i=0; i<N; i++){
            if(diff[i][c] == end[i][c]){
                check++;
            }
        }

        if(check==N) return 0; //전부 일치
        else if(check==0) return 1; //전부 불일치
        else return -1;
    }
}