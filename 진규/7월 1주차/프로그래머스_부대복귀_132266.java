import java.util.*;

/*
    1. 2차원 인접 리스트 생성
    2. soureces를 기준으로 목적지까지 BFS -> 도착 하면 거리 출력, 도착 못하면 -1 출력
*/

class Solution {
    
    static List<Integer>[] graph;
    
    static int[] answer;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        answer = new int[sources.length];
        
        graph = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) graph[i] = new ArrayList<>();
        
        for (int i = 0; i < roads.length; i++) {
            
            int a = roads[i][0];
            int b = roads[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for (int i = 0; i < sources.length; i++) {
            
            int roadLen = bfs(sources[i], destination, new boolean[n+1]);
            answer[i] = roadLen;
        }
        
        return answer;
    }
    
    private static int bfs(int start, int end, boolean[] visited) { // q에 (현재위치, 거리) 담기
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        visited[start] = true;
        
        while (!q.isEmpty()) {
            
            int[] qPoll = q.poll();
            int now = qPoll[0];
            int roadLen = qPoll[1];
            
            if (now == end)
                return roadLen;
            
            for (int next : graph[now]) {
                
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, roadLen+1});
                }
            }
        }
        
        return -1;
    }
}