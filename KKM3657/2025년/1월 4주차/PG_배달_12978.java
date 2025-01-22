import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Distance implements Comparable<Distance> {
    int node;
    int distance;

    Distance(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
    public int compareTo(Distance d) {
        return this.distance - d.distance;
    }
}
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // 다익스트라 - 인접행렬
        int[][] graph = new int[N+1][N+1];

        for(int i=1; i<=N; i++)
            Arrays.fill(graph[i], 1_000_000);

        // 그래프
        for(int[] node : road) {
            int s = node[0], e = node[1], value = node[2];
            graph[s][e] = Math.min(graph[s][e], value);
            graph[e][s] = Math.min(graph[e][s], value);
        }

        PriorityQueue<Distance> pq = new PriorityQueue<>();
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[1] = 0;
        pq.add(new Distance(1, 0));

        while(!pq.isEmpty()) {
            // 다음 노드 뽑기
            Distance curr = pq.poll();

            // 최단거리가 불가능 한 경우 넘어감
            if(distance[curr.node] < curr.distance)
                continue;

            // 다음 노드 탐색, 갱신
            for(int i=1; i<=N; i++) {
                // 연결 상태 확인
                if(graph[curr.node][i] == Integer.MAX_VALUE)
                    continue;
                if(distance[curr.node] + graph[curr.node][i] < distance[i]) {
                    distance[i] = distance[curr.node] + graph[curr.node][i];
                    pq.add(new Distance(i, distance[i]));
                }
            }
        }

        for(int value : distance) {
            if(value <= K)
                answer++;
        }
        return answer;
    }
}