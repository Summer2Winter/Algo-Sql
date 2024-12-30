import java.util.ArrayDeque;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];
        //너비우선 탐색
        for(int i=0; i<n; i++) {
            if(visited[i])
                continue;
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            visited[i] = true;
            answer++;
            while(!queue.isEmpty()) {
                int curr = queue.poll();

                for(int j=0; j<n; j++) {
                    if(visited[j] || computers[curr][j] != 1)
                        continue;
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }

        return answer;
    }
}