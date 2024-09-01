class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int totalAlp = 0, totalCop = 0;

        // 목표치
        for(int i=0; i<problems.length; i++) {
            totalAlp = Math.max(totalAlp, problems[i][0]);
            totalCop = Math.max(totalCop, problems[i][1]);
        }

        if (alp >= totalAlp && cop >= totalCop) {
            return 0;
        }

        // 처음 설정된 알고력이 최종 목표값보다 높을 경우
        if (alp >= totalAlp) {
            alp = totalAlp;
        }

        // 처음 설정된 코딩력이 최종 목표값보다 높을 경우
        if (cop >= totalCop) {
            cop = totalCop;
        }
        // 초기화
        int[][] dp = new int[totalAlp+2][totalCop+2];
        for(int i=alp; i<=totalAlp; i++){
            for(int j=cop; j<=totalCop; j++)
                dp[i][j] = 1000000000;
        }
        dp[alp][cop] = 0;

        // 정답 구하기
        for(int i=alp; i<=totalAlp; i++) {
            for(int j=cop; j<=totalCop; j++) {
                // 알고력 +1
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
                // 코딩력 +1
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1);

                for(int k=0; k<problems.length; k++) {
                    int alp_req = problems[k][0], cop_req = problems[k][1];
                    int alp_rwd = problems[k][2], cop_rwd = problems[k][3];
                    int cost = problems[k][4];

                    // 현재 알고력과 코딩력이 문제를 해결할 수 있는 조건을 넘었을 경우
                    if (i >= alp_req && j >= cop_req) {
                        // 알고력과 코딩력이 목표치를 넘겼을 경우
                        if (i+alp_rwd > totalAlp && j+cop_rwd > totalCop)
                            dp[totalAlp][totalCop] = Math.min(dp[totalAlp][totalCop], dp[i][j] + cost);
                            // 알고력이 목표치를 넘겼을 경우
                        else if (i+alp_rwd > totalAlp)
                            dp[totalAlp][j+cop_rwd] = Math.min(dp[totalAlp][j+cop_rwd], dp[i][j] + cost);
                            // 코딩력이 목표치를 넘겼을 경우
                        else if (j+cop_rwd > totalCop)
                            dp[i+alp_rwd][totalCop] = Math.min(dp[i+alp_rwd][totalCop],dp[i][j] + cost);
                            // 목표치에 도달하지 못 한 경우
                        else if (i+alp_rwd <= totalAlp && j+cop_rwd <= totalCop)
                            dp[i+alp_rwd][j+cop_rwd] = Math.min(dp[i+alp_rwd][j+cop_rwd],dp[i][j] + cost);
                    }
                }
            }
        }
        answer = dp[totalAlp][totalCop];
        return answer;
    }
}