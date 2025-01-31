import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // 그래프(인접 리스트) 생성
        for (int[] cost : costs) {
            int u = cost[0], v = cost[1], w = cost[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        // 최소 힙(우선순위 큐) 사용 -> 비용 기준으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        boolean[] visited = new boolean[n];  // 정점 방문 여부
        pq.offer(new int[]{0, 0});  // 임의의 정점(0번)에서 시작

        int answer = 0, count = 0;
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int u = edge[0], weight = edge[1];

            if (visited[u]) continue;  // 이미 방문한 정점이면 스킵
            visited[u] = true;  // 방문 처리
            answer += weight;  // 비용 추가
            count++;  // MST 간선 개수 증가

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0], w = neighbor[1];
                if (!visited[v]) pq.offer(new int[]{v, w});  // 방문하지 않은 정점만 추가
            }

            if (count == n) break;  // MST 완성
        }
        return answer;
    }
}
