// DFS / BFS 재활 치료
// https://school.programmers.co.kr/learn/courses/30/lessons/1844?language=javascript
// 간단한 BFS 최단 경로 문제
// 이차원 배열에서 시작점 과 끝점 까지 이동하는 문제
// 경로는 1개가 아니라 여러개 일 수 도 있고, 경로도 없을 수도 있다.
// 경로가 여러개라면 그 중 최단 거리를 반환해야 하고, 경로가 없다면 -1을 반환해야 한다.
// 큐를 이용해 상하좌우로 이동하는 모든 경로를 체크하고 거리배열을 설정하여 끝 점에 도달 한 경우 배열에 이동거리를 배열에 추가, 큐가 완전히 비는 경우까지 진행
// 최종적으로 이동거리 배열이 비어 있으면 -1을 반환하고
// 길이가 2 이상 이면 오름차순 정렬 후
// 배열의 0번 인덱스를 반환
// 그냥 큐를 사용하면 효율성에서 터져서 우선순위 큐를 사용해서 해결

import java.util.*;

public class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // 동, 남, 서, 북
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        // 시작점 초기화
        queue.add(new int[]{0, 0, 1});  // {x, y, distance}
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            // 목표 지점에 도달하면 거리 반환
            if (x == n - 1 && y == m - 1) {
                return distance;
            }
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                // 유효한 좌표인지, 방문한 적이 없는지, 벽이 아닌지 확인
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, distance + 1});
                }
            }
        }
        // 목표 지점에 도달할 수 없는 경우
        return -1;
    }
}