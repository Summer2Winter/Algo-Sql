import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;
class Node {
    int end;
    int w;

    Node(int end, int w) {
        this.end = end;
        this.w = w;
    }
}
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
    ArrayList<Node>[] graph;
    int[] distance;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        // 그래프 그리기
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] road : roads) {
            graph[road[0]].add(new Node(road[1],1));
            graph[road[1]].add(new Node(road[0],1));
        }

        distance = new int[n+1];
        Arrays.fill(distance, (int)1e9);

        // 다익스트라
        PriorityQueue<Distance> pq = new PriorityQueue<>();
        // 시작점
        distance[destination] = 0;
        pq.add(new Distance(destination, 0));

        while(!pq.isEmpty()) {
            Distance d = pq.poll();
            int node = d.node;

            // 최단 거리가 불가능한 경우
            if(distance[node] < d.distance)
                continue;

            for(int i=0; i<graph[node].size(); i++) {
                Node next = graph[node].get(i);
                int temp = distance[node] + next.w;

                if(distance[next.end] > temp) {
                    distance[next.end] = temp;
                    pq.add(new Distance(next.end, temp));
                }
            }
        }
        // 부대복귀 최단거리
        for(int i=0; i<sources.length; i++) {
            int value = distance[sources[i]];
            answer[i] = (value == (int)1e9) ? -1 : value;
        }
        return answer;
    }
}