import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        // 끝점 기준 정렬
        Arrays.sort(targets, (x,y) -> {
            return x[1] == y[1] ? x[0]-y[0]:x[1]-y[1];
        });
        int end = targets[0][1];
        for(int i=1; i<targets.length; i++) {
            if(end <= targets[i][0]) {
                answer++;
                end = targets[i][1];
            }
        }
        return answer;
    }
}