import java.util.Arrays;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        // 정렬
        Arrays.sort(data, (int[] x, int[] y) -> x[col-1] == y[col-1] ? y[0] - x[0] : x[col-1] - y[col-1]);

        // 튜플에 대한 계산 및 xor 하기
        for(int i=row_begin; i<=row_end; i++) {
            int temp = 0;
            for(int j=0; j<data[0].length; j++)
                temp += (data[i-1][j] % i);
            answer ^= temp;
        }
        return answer;
    }
}