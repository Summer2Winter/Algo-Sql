class Solution {
    boolean[] selected; // 열 체크
    boolean[] leftDiagonal; // 왼쪽 대각선 체크
    boolean[] rightDiagonal; // 오른쪽 대각선 체크
    int answer;
    int N;
    public int solution(int n) {
        selected = new boolean[n];
        leftDiagonal = new boolean[2 * n - 1];  // row + col 값 범위: (0 ~ 2N-2)
        rightDiagonal = new boolean[2 * n - 1]; // row - col + (N-1) 값 범위: (0 ~ 2N-2)

        N = n;
        // 윗줄부터 선택
        selectQueen(0); // 첫 번째 행부터 시작
        return answer;
    }

    public void selectQueen(int curr) {
        // 모든 경우 확인
        if(curr == N) {
            answer++;
            return;
        }
        // 현재 줄 선택
        for(int i=0; i<N; i++) {
            // 열 제외 대각선 제외 => 음수를 양수로 변환하기 위해서 (N-1) 더함
            if (selected[i] || leftDiagonal[curr + i] || rightDiagonal[curr - i + (N-1)])
                continue;
            selected[i] = true;
            leftDiagonal[curr + i] = true;
            rightDiagonal[curr - i + (N-1)] = true;
            selectQueen(curr+1);

            selected[i] = false;
            leftDiagonal[curr + i] = false;
            rightDiagonal[curr - i + (N-1)] = false;
        }
    }
}