import java.util.ArrayDeque;

class Solution {
    ArrayDeque<Integer>[] tower = new ArrayDeque[4];
    ArrayDeque<int[]> answerList = new ArrayDeque<>();
    public int[][] solution(int n) {
        // 타워 초기화
        for(int i=1; i<=3; i++)
            tower[i] = new ArrayDeque<>();

        // 고리 넣기
        for(int i=n; i>=1; i--)
            tower[1].push(i);

        // 옮기기
        moveTower(n, 1, 3, 2); //n개를 1에서 3으로 옮김, 2를 활용해서
        int[][] answer = new int[answerList.size()][];
        int idx = 0;
        for(int[] arr : answerList)
            answer[idx++] = arr;

        return answer;
    }
    public void moveTower(int n, int from, int to, int via) {
        if(n==0)
            return;

        // n-1개의 디스크를 from에서 via로 이동
        moveTower(n-1, from, via, to);

        // 가장 큰 디스크를 from에서 to로 이동
        tower[to].push(tower[from].pop());
        answerList.add(new int[]{from, to});

        // n-1개의 디스크를 via에서 to로 이동
        moveTower(n-1, via, to, from);
    }
}