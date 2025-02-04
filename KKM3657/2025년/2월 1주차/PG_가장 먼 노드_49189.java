import java.util.ArrayList;
import java.util.ArrayDeque;

class Solution {
    ArrayList<Integer>[] graph;
    boolean[] visited;
    int result;
    public int solution(int n, int[][] edge) {
        // 그래프
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++)
            graph[i] = new ArrayList<>();

        for(int[] vertex : edge) {
            graph[vertex[0]].add(vertex[1]);
            graph[vertex[1]].add(vertex[0]);
        }
        // bfs
        int answer = 0, distance = 0;
        visited = new boolean[n+1];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1,distance});
        visited[1] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();

            // 길이가 최대일때 개수+1
            if(curr[1] > distance) {
                answer = 1;
                distance = curr[1];
            }
            else if(curr[1] == distance)
                answer++;

            // 다음 노드로 이동
            for(int next : graph[curr[0]]) {
                if(visited[next])
                    continue;
                visited[next] = true;
                queue.add(new int[]{next, curr[1]+1});
            }
        }
        return answer;
    }
}