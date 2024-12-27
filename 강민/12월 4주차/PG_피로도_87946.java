
class Solution {
    int answer;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {

        // 방문 기록
        visited = new boolean[dungeons.length];
        selectDungeons(dungeons, k, 0);

        return answer;
    }
    public void selectDungeons(int[][] dungeons, int value, int cnt) {
        // 선택
        answer = Math.max(answer, cnt);

        for(int i=0; i<dungeons.length; i++) {
            if(visited[i] || dungeons[i][0] > value)
                continue;
            // 던전 가기
            visited[i] = true;
            selectDungeons(dungeons, value - dungeons[i][1], cnt+1);

            // 다음 던전 가기
            visited[i] = false;
        }
    }
}