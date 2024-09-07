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

        // 하노이 탑 문제 해결
        hanoiTop(N, 0, 2, 1); // from: 0, to: 2, via: 1
        answer = temp.toArray(new int[temp.size()][]);
        return answer;
    }

    // n개의 디스크를 from에서 to로 via를 거쳐 이동
    public void hanoiTop(int n, int from, int to, int via) {
        if (n == 0) return;

        // n-1개의 디스크를 from에서 via로 이동
        hanoiTop(n - 1, from, via, to);

        // 가장 큰 디스크를 from에서 to로 이동
        tower[to].push(tower[from].pop());
        temp.add(new int[]{from + 1, to + 1});

        // n-1개의 디스크를 via에서 to로 이동
        hanoiTop(n - 1, via, to, from);
    }
}

/*
 이 문제는 하노이탑 문제로 1번 타워에 있는 n-1개의 원판을 2번으로 옮기는 과정과 n의 원판을 1번에서 3번으로 옮기는 과정을 나타낸것이다.
 따라서 분할정복 문제이다.
 */