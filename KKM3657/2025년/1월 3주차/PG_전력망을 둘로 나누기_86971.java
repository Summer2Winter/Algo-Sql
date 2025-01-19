class Solution {
    boolean[][] graph;
    boolean[] visited;
    int N, temp;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        graph = new boolean[n+1][n+1];
        N = n;
        // 간선 - 양방향
        for(int[] wire : wires) {
            graph[wire[0]][wire[1]] = true;
            graph[wire[1]][wire[0]] = true;
        }

        // 끊기
        for(int[] wire : wires) {
            // 초기화
            visited = new boolean[n+1];
            temp = 0;
            // 간선 끊기
            graph[wire[0]][wire[1]] = false;
            graph[wire[1]][wire[0]] = false;

            // 나누기
            countWires(1);
            int value = Math.abs(temp - n + temp);
            answer = Math.min(answer, value);

            // 간선 복구
            graph[wire[0]][wire[1]] = true;
            graph[wire[1]][wire[0]] = true;
        }
        return answer;
    }

    public void countWires(int curr) {
        for(int i=1; i<=N; i++) {
            if(visited[i] || (!graph[curr][i] && !graph[i][curr]))
                continue;
            visited[i] = true;
            temp++;
            countWires(i);
        }
    }
}