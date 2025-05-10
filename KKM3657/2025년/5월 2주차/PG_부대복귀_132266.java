import java.util.Arrays;
import java.util.ArrayList;
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
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 그래프
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++)
            graph[i] = new ArrayList<>();

        for(int[] road : roads) {
            int s = road[0], e = road[1];
            graph[s].add(e);
            graph[e].add(s);
        }

        int[] distance = new int[n+1];
        Arrays.fill(distance, (int)1e9);

        // 목적지에서 최단거리
        int start = destination;
        distance[start] = 0;
        PriorityQueue<Distance> pq = new PriorityQueue<>();
        pq.add(new Distance(start, 0));

        while(!pq.isEmpty()) {
            Distance curr = pq.poll();
            int currNode = curr.node;
            // 최단거리가 아닌경우 넘어감
            if(curr.distance > distance[currNode])
                continue;
            for(Integer node : graph[currNode]) {
                // 최단경로 갱신
                if(distance[node] > distance[currNode] + 1) {
                    distance[node] = distance[currNode] + 1;
                    pq.add(new Distance(node, distance[node]));
                }
            }
        }

        // 각 좌표마다의 거리
        int[] answer = new int[sources.length];
        int idx = 0;
        for(int source : sources) {
            if(distance[source] == (int)1e9)
                answer[idx++] = -1;
            else
                answer[idx++] = distance[source];
        }
        return answer;
    }
}