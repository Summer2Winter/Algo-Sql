import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][2];
        int[][] dp = new int[N+1][K+1];
        // 입력
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        // 배낭에 1개씩 넣을지 말지 선택
        for(int i=1; i<=N; i++) {
            // 무게에 따라 물건을 빼고 넣을지 그냥 넣을지
            for(int j=1; j<=K; j++) {
                dp[i][j] = dp[i-1][j];  // 이전 물건의 최대 가치
                // 현재 물건을 넣을 수 있는 경우만 확인
                if(j - arr[i][0] >= 0) {
                    // 현재 물건을 넣지 않은 경우, 이전 물건을 빼고 현재 물건을 넣는 경우 비교
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-arr[i][0]] + arr[i][1]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}

// 문제 해설
/*
NS("ABCD", 7) 이라고 할때 이 문제는 배낭에 물건을 넣을지 말지를 선택하는 것이다.
NS("ABCD", 7) 이 문제를 동적계획법으로 푼다면 두가지로 봅 수 있다.
TOP DOWN으로 본다면 NS("ABC", 7-12) + 12(여기서 음수니까 제외), NS("ABC", 7) (D를 안 넣는 경우)
이렇게 쪼갤수 있다.
즉 가방에 넣은 결과에서 1개씩 넣으면서 결과를 보는데 해당 무게에서 물건을 안 넣는 경우(이전 결과가 큰 경우),
이전 물건을 빼고 현재 물건을 넣는 경우 (이전 결과 보다 현재 무게를 뺀 나머지의 합이 큰 경우)
두 가지를 확인하면 된다.