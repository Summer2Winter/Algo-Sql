import java.util.Arrays;

class Solution {
    int N, temp;
    boolean[][] graph;
    boolean[] visited;
    public int solution(int n, int[][] results) {
        int answer = 0;
        N = n;
        // 플로이드 워샬 - 방향 그래프 2개 생성
        int[][] win = new int[n+1][n+1], lose = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            Arrays.fill(win[i], (int)1e9);
            Arrays.fill(lose[i], (int)1e9);
            win[i][i] = 0;
            lose[i][i] = 0;
        }

        // 간선정보
        for(int[] edge : results) {
            win[edge[0]][edge[1]] = 1; // 이긴 방향 그래프
            lose[edge[1]][edge[0]] = 1; // 진 방향 그래프
        }

        // 플로이드 워샬
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(win[i][j] > win[i][k] + win[k][j]) {
                        win[i][j] = win[i][k] + win[k][j];
                    }
                    if(lose[i][j] > lose[i][k] + lose[k][j]) {
                        lose[i][j] = lose[i][k] + lose[k][j];
                    }
                }
            }
        }
        // 합 확인
        for(int t=1; t<=n; t++) {
            int count = 0;
            for(int i=1; i<=n; i++) {
                if(t == i)
                    continue;
                // 승 합
                if(win[t][i] != (int)1e9 || lose[t][i] != (int)1e9)
                    count++;
            }
            if(count == n-1) {
                answer++;
            }
        }
        return answer;
    }
}

// 승 패 확인
//import java.util.*;
//
//class Solution {
//    public int solution(int n, int[][] results) {
//        // 각 선수의 승리, 패배 관계를 저장할 그래프 생성
//        List<Integer>[] winGraph = new ArrayList[n+1];
//        List<Integer>[] loseGraph = new ArrayList[n+1];
//        for (int i = 1; i <= n; i++) {
//            winGraph[i] = new ArrayList<>();
//            loseGraph[i] = new ArrayList<>();
//        }
//
//        // 결과에 따라 그래프 구성
//        // result[0]가 result[1]를 이겼다는 의미
//        for (int[] result : results) {
//            int winner = result[0];
//            int loser = result[1];
//            winGraph[winner].add(loser);
//            loseGraph[loser].add(winner);
//        }
//
//        int answer = 0;
//        // 각 선수별로 DFS를 수행하여 자신보다 높은 선수와 낮은 선수의 수를 구함
//        for (int i = 1; i <= n; i++) {
//            boolean[] visitedWin = new boolean[n+1];
//            int winCount = dfs(winGraph, i, visitedWin);
//
//            boolean[] visitedLose = new boolean[n+1];
//            int loseCount = dfs(loseGraph, i, visitedLose);
//
//            // 자기 자신이 두 번 카운트되므로 -1을 해준다.
//            if (winCount + loseCount - 1 == n) {
//                answer++;
//            }
//        }
//
//        return answer;
//    }
//
//    // DFS를 재귀적으로 수행하여 시작점으로부터 도달 가능한 노드 수를 반환
//    private int dfs(List<Integer>[] graph, int start, boolean[] visited) {
//        visited[start] = true;
//        int count = 1;
//        for (int next : graph[start]) {
//            if (!visited[next]) {
//                count += dfs(graph, next, visited);
//            }
//        }
//        return count;
//    }
//}
