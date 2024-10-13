class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[60001];
        dp[1] = 1;
        dp[2] = 2;
        if(n >= 3) {
            for(int i=3; i<=n; i++) {
                dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
            }
        }
        answer = dp[n];
        return answer;
    }
}

// 끝점을 기준으로 세로 기둥 1개를 세울지 아니면 가로 기둥 2개를 놓을지에 따라 달라진다. 즉 피보나치 수열을 따라가게 된다.
// dp[i-1]ㅣ 세우는 방법과 dp[i-2]= 방식이 있다고 생각하면 된다.