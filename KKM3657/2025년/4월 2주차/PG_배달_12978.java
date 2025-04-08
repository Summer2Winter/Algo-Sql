import java.util.*;
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
    int[][] graph;
    int[] distance;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        graph = new int[N+1][N+1];

        // 초기화
        for(int[] temp : graph) {
            Arrays.fill(temp, (int)1e9);
        }
        // 도로 정보
        for(int[] temp : road) {
            graph[temp[0]][temp[1]] = Math.min(graph[temp[0]][temp[1]], temp[2]);
            graph[temp[1]][temp[0]] = Math.min(graph[temp[1]][temp[0]], temp[2]);
        }

        PriorityQueue<Distance> pq = new PriorityQueue<>();
        distance = new int[N+1];

        // 최단거리 배열
        Arrays.fill(distance, (int)1e9);
        distance[1] = 0;
        pq.add(new Distance(1, 0));

        // 최단거리 구하기
        while(!pq.isEmpty()) {
            // 다음 이동할 노드
            Distance curr = pq.poll();
            // 다음 이동할 노드가 더 크면 이동X
            if(curr.distance > K) {
                break;
            }

            // 최단 거리 갱신
            for(int next=1; next<=N; next++) {
                // 연결 여부 확인
                if(graph[curr.node][next] == 0)
                    continue;
                // 연결되어 있으면 최단거리 갱신
                if(distance[next] > distance[curr.node] + graph[curr.node][next]) {
                    distance[next] = distance[curr.node] + graph[curr.node][next];
                    pq.add(new Distance(next, distance[next]));
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