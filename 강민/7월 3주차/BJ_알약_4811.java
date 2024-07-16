import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[31];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=30; i++) {
            for(int j=0; j<i; j++)
                dp[i] += dp[j] * dp[i-j-1];
        }
        // 방법2.
//        long[][] dp = new long[31][31];
//        for(int i=1; i<=30; i++) {
//            dp[i][0] = 1;
//            for(int j=1; j<=i; j++) {
//                dp[i][j] = dp[i-1][j] + dp[i][j-1];
//            }
//        }
        while(true) {
            int t = Integer.parseInt(br.readLine());
            if(t == 0)
                break;
            System.out.println(dp[t]);
        }
    }
}

/*
    이 문제는 카탈란 수를 나타내는 문제로 전형적인 dp문제이다.
    점화식을 도출하는 과정은 다음과 같다.
    (방법1.)
    문제에서 반드시 W부터 시작을 하므로 W개수는 1개가 제외된 상태로 간다.
    또한 W가 왔을때 그 뒤에 올 수 있는것은 H가 오거나 아니면 또 다른 W가 와야한다.
    즉 N = 3 일때를 보면 W뒤에 바로 H가 오는 경우, W가 0개가 오는경우(DP[0]) * 나머지 W가 오는 DP[2]가 되고
    W뒤에 1개의 W가 오는 경우(DP[1]) * 나머지 W가 오는 DP[1] 이런 방식이 된다.
 */