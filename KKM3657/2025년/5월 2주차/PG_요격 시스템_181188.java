import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        // 끝점 기준 정렬
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                return x[1]==y[1] ? x[0]-y[0] : x[1]-y[1];
            }
        });
        // 람다
        Arrays.sort(targets, (x,y) -> {
            return x[1] == y[1] ? x[0]-y[0] : x[1]-y[1];
        });
        int end = targets[0][1];
        answer++;
        for(int i=1; i<targets.length; i++) {
            // 시작점이 끝점보다 뒤에 있는 경우 갱신, 겹치는 구간 포함 x
            if(end <= targets[i][0]) {
                answer++;
                end = targets[i][1];
            }
        }
        return answer;
    }
}