/*
    트리 : https://school.programmers.co.kr/questions/50862
    DP : https://karla.tistory.com/434
    0. 문제 유형 : 트리 or DP
    1. 자기 자신의 child노드들 중 하나라도 불빛이 꺼져있는 등대가 있다면 자기 자신은 불빛을 켜야 함.
    2. 가장 아래, 리프노드는 불빛이 무조건 꺼져있어야 함.
*/

import java.util.*;

class Solution {
    
    static List<Integer>[] graph;
    static boolean[] visited;
    
    static int answer;
    
    public int solution(int n, int[][] lighthouse) {
        
        graph = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) graph[i] = new ArrayList<>();
        
        for (int[] light : lighthouse) {
            int a = light[0];
            int b = light[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        visited = new boolean[n+1];
        dfs(1, 1);
        
        return answer;
    }
    
    private void dfs(int node, int parent) {

        for (int child : graph[node]) {
        
            if (child == parent)
                continue;
            
            dfs(child, node);
            
            if (!visited[child] && !visited[node]) {
                visited[node] = true;
                answer += 1;
            }
        }
    }
}