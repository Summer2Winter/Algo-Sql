import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
        인덱스를 고객의 수, 값을 고객을 홍보할 때 드는 비용으로 DP배열을 세우면 풀 수 있는 문제.
        처음에 DP배열을 Integer.MAXVALUE로 초기화를 하는 방법에서 실수 해서 틀림. - 최솟값을 구하는 문제이기 때문에 처음에 최댓값으로 초기화 후 갱신시키기
     */

    static int C, N;
    static int[] dp, customer, cost;

    static StringTokenizer st;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        dp = new int[C+101]; // 입력받는 비용 + 고객의 수 ( 1 <= N <= 100)
        Arrays.fill(dp, Integer.MAX_VALUE); // dp 배열을 무한대로 초기화
        customer = new int[N+1];
        cost = new int[N+1];

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            customer[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0; // 고객을 유치하는 데 드는 비용
        for (int i = 0; i < N; i++) {

            int cos = cost[i]; // cus 만큼의 고객을 홍보하는데 드는 비용
            int cus = customer[i]; // 고객 홍보 수

            for (int j = cus; j < C + 101; j++) {

                if (dp[j - cus] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - cus] + cos);
                }
            }
        }

        for (int i = C; i < C + 101; i++) {

            answer = Math.min(answer, dp[i]);
        }

        System.out.println(answer);
    }
}