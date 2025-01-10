import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (x,y) -> {
            return x[1] == y[1] ? x[0] - y[0] : x[1] - y[1];
        });
        int idx = 1;
        int end = routes[0][1];
        while(idx < routes.length) {
            // 앞부분이 더 뒤에 있는 경우
            if(end < routes[idx][0]) {
                end = routes[idx][1];
                answer++;
            }
            idx++;
        }
        return answer;
    }
}