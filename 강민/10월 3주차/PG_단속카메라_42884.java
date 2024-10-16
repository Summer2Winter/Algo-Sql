import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        // 끝점 기준 정렬
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                return x[1] == y[1] ? x[0]-y[0] : x[1]-y[1];
            }
        });
        // Arrays.sort(routes, (x,y) -> {
        //     return x[1] == y[1] ? x[0]-y[0] : x[1]-y[1];
        // });
        int end = routes[0][1];
        for(int i=1; i<routes.length; i++) {
            // 겹치는 구간 없음
            if(end < routes[i][0]) {
                answer++;
                end = routes[i][1];
            }
        }
        return answer;
    }
}

// 끝점을 기준으로 정렬한 뒤 시작점 및 끝점이 포함 여부를 확인하면서 찾으면 된다. (시작점 기준으로 정렬하면 안된다.)