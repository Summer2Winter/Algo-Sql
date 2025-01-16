class Solution {
    public int[] solution(int n) {
        int total = n * (n+1) / 2;
        int[] answer = new int[total];
        int[][] dp = new int[n][n];
        int number = 1;
        int cx = -1, cy = 0;
        dp[0][0] = 1;
        while(n > 0) {
            // 밑으로
            for(int i=1; i<=n; i++) {
                cx += 1;
                dp[cx][cy] = number++;
            }
            n--;
            // 오른쪽
            for(int j=1; j<=n; j++) {
                cy += 1;
                dp[cx][cy] = number++;
            }
            n--;
            // 위쪽
            for(int k=1; k<=n; k++) {
                cx -= 1;
                cy -= 1;
                dp[cx][cy] = number++;
            }
            n--;
        }
        int idx = 0;
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                if(dp[i][j] == 0)
                    break;
                else
                    answer[idx++] = dp[i][j];
            }
        }
        return answer;
    }
}

// dx dy
//class Solution {
//    public int[] solution(int n) {
//        int total = n * (n+1) / 2;
//        int[] answer = new int[total];
//        int[][] dp = new int[n][n];
//        int number = 1, cx = -1, cy = 0;
//        int[] dx = new int[]{1,0,-1}, dy = new int[]{0,1,-1};
//        int idx = -1;
//        while(n > 0) {
//            idx = (idx + 1) % 3;
//            // 밑으로
//            for(int i=1; i<=n; i++) {
//                cx = cx + dx[idx];
//                cy = cy + dy[idx];
//                dp[cx][cy] = number++;
//            }
//            n--;
//        }
//        idx = 0;
//        for(int i=0; i<dp.length; i++) {
//            for(int j=0; j<dp[0].length; j++) {
//                if(dp[i][j] == 0)
//                    break;
//                else
//                    answer[idx++] = dp[i][j];
//            }
//        }
//        return answer;
//    }
//}