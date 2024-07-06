class Solution {
    int answer = -1, n, cnt;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;

        for(int i=0; i<n; i++) {
            int temp = k;
            visited = new boolean[n];
            // 시작점 설정
            find_dungeons(k, 0, dungeons);
        }
        return answer;
    }

    public void find_dungeons(int k, int cnt, int[][] dungeons) {
        answer = Math.max(answer, cnt);
        // 전체 탐색
        for(int i=0; i<n; i++) {
            if(visited[i])
                continue;
            if(k >= dungeons[i][0] && k - dungeons[i][1] >= 0) {
                visited[i] = true;
                find_dungeons(k-dungeons[i][1], cnt+1, dungeons);
                visited[i] = false;
            }
        }
    }
}