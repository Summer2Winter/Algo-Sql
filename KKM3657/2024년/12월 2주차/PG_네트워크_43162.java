class Solution {
    boolean[] visited;
    int N;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // 방문기록
        N = n;
        visited = new boolean[n];

        //DFS
        for(int i=0; i<n; i++) {
            if(visited[i])
                continue;
            visited[i] = true;
            answer++;
            dfs(i, computers);
        }
        return answer;
    }

    public void dfs(int curr, int[][] computers) {
        // 다음지점 이동
        for(int i=0; i<N; i++) {
            // 방문하지 않고 연결되어있으면 이동
            if(computers[curr][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, computers);
            }
        }
    }
}