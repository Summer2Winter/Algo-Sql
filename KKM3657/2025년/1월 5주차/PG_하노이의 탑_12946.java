import java.util.ArrayDeque;

class Solution {
    ArrayDeque<Integer>[] tower = new ArrayDeque[3];
    ArrayDeque<int[]> temp = new ArrayDeque<>();
    int cnt = Integer.MAX_VALUE;
    int N;
    int[][] answer;

    public int[][] solution(int n) {
        N = n;
        // 타워 생성
        for (int i = 0; i < 3; i++) {
            tower[i] = new ArrayDeque<>();
        }

        // 고리 넣기
        for (int i = n; i > 0; i--) {
            tower[0].push(i);
        }
        // 옮기기
        moveHanoiTop(n, 0, 2, 1);
        int[][] answer = temp.toArray(new int[temp.size()][]);
        return answer;
    }

    public void moveHanoiTop(int n, int from, int to, int via) {
        if(n==0)
            return;

        // n-1개의 디스크를 from에서 via로 이동
        moveHanoiTop(n-1, from, via, to);

        // 가장 큰 디스크를 from에서 to로 이동
        tower[to].push(tower[from].pop());
        temp.add(new int[]{from+1, to+1});

        // n-1개의 디스크를 via에서 to로 이동
        moveHanoiTop(n-1, via, to, from);
    }
}