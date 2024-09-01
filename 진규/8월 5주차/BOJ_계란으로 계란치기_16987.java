import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] egg;

    static StringTokenizer st;
    static int answer;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        egg = new int[N][2];
        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            egg[i][0] = Integer.parseInt(st.nextToken());
            egg[i][1] = Integer.parseInt(st.nextToken());
        }

        backtrack(0);

        System.out.println(answer);
    }

    private static void backtrack(int depth) {

        // 현재 깊이가 N이면, 모든 계란을 다 처리한 것이므로 종료
        if (depth == N) {
            answer = Math.max(answer, checkBroken());
            return;
        }

        // 현재 손에 든 계란이 이미 깨졌다면 다음으로 넘어감
        if (egg[depth][0] <= 0) {
            backtrack(depth + 1);
            return;
        }

        boolean allBroken = true;

        for (int i = 0; i < N; i++) {
            // 같은 계란은 칠 수 없으므로 건너뜀
            if (depth == i) continue;
            // 치려는 계란이 이미 깨졌다면 건너뜀
            if (egg[i][0] <= 0) continue;

            // 계란을 칠 수 있다면, 해당 계란들을 치고 백트래킹 진행
            egg[depth][0] -= egg[i][1];
            egg[i][0] -= egg[depth][1];

            allBroken = false;
            backtrack(depth + 1);

            // 백트래킹을 위해 계란 상태 복구
            egg[depth][0] += egg[i][1];
            egg[i][0] += egg[depth][1];
        }

        // 만약 칠 수 있는 계란이 없었다면, 그대로 넘어감
        if (allBroken) {
            backtrack(depth + 1);
        }
    }

    private static int checkBroken() {

        int brokenCnt = 0;
        for (int i = 0; i < N; i++) {
            if (egg[i][0] <= 0)
                brokenCnt += 1;
        }
        return brokenCnt;
    }
}