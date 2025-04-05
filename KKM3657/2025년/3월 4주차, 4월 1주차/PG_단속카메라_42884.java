import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        // 정렬
        Arrays.sort(routes, (x,y) -> x[1] == y[1] ? x[0]-y[0] : x[1]-y[1]);

        int last = routes[0][1];
        // 1개씩 탐색
        for(int i=1; i<routes.length; i++) {
            // 시작점이 전에 있는 끝점 보다 앞에 있는 경우 끝점 갱신
            if(routes[i][0] > last) {
                answer++;
                last = routes[i][1];
            }
        }
        return answer;
    }
}