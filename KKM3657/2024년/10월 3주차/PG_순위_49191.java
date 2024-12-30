class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] win = new boolean[n+1][n+1];
        boolean[][] lose = new boolean[n+1][n+1];

        for(int i=0; i<results.length; i++) {
            int w = results[i][0];
            int l = results[i][1];

            win[w][l] = true;
            lose[l][w] = true;
        }

        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(win[i][k] && win[k][j])
                        win[i][j] = true;
                    if(lose[i][k] && lose[k][j])
                        lose[i][j] = true;
                }
            }
        }
        int answer = 0;

        for(int i=1; i<=n; i++) {
            int cnt = 0;
            for(int j=1; j<=n; j++) {
                if(win[i][j] || lose[i][j]) {
                    cnt++;
                }
            }
            if(cnt == n-1)
                answer++;
        }
        return answer;
    }
}

// 이 문제는 플로이드 워샬을 활용한 문제로 해당 노드의 등수를 알기 위해서는 이긴 것과 진 것이 명확한 노드를 확인해야 한다는 점이다.
// 이긴 경우 win 배열에 저장하고, 진 경우 lose 배열에 저장하는데 플로이드 워샬 개념을 이용하면 중간 지점이 명확한 친구들이 나온다.
// 1번이 3번을 이기고 3번이 4번을 이긴다면 1번이 4번을 이긴다는 것과 같다.
// 이렇게 모든 정점에서의 이김과 짐을 판별하게 됐을때 둘중 하나라도 알 수 있는것이 n-1(자기 자신 제외)이라면 등수 예측이 가능하다.