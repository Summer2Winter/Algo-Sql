import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        // 정렬
        Arrays.sort(data, (x,y) -> x[col-1]==y[col-1] ? y[0]-x[0] : x[col-1]-y[col-1]);

        // 해시
        for(int i=row_begin-1; i<=row_end-1; i++) {
            int S_i = 0;
            for(int j=0; j<data[0].length; j++) {
                S_i += data[i][j] % (i+1);
            }
            answer ^= S_i;
        }
        return answer;
    }
}