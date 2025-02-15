import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 거리
        int[] answer = new int[sources.length];

        // 길 만들기
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++)
            graph[i] = new ArrayList<>();

        for(int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }

        int[] distance = new int[n+1];
        Arrays.fill(distance, (int)1e9);
        distance[destination] = 0;

        // 목적지에서 BFS
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        visited[destination] = true;
        queue.add(new int[]{destination,0});

        // BFS
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();

            for(int next : graph[curr[0]]) {
                if(visited[next])
                    continue;
                visited[next] = true;
                distance[next] = curr[1]+1;
                queue.add(new int[]{next, curr[1]+1});
            }
        }
        int idx = 0;
        // sources 만큼 저장
        for(int source : sources) {
            if(distance[source] == (int)1e9)
                answer[idx++] = -1;
            else
                answer[idx++] = distance[source];
        }
        return answer;
    }
}