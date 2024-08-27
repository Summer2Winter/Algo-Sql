class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = money[0];
        dp1[1] = money[0];
        dp2[1] = money[1];
        for(int i=2; i<n; i++) {
            // 1번을 선택한 경우
            if(i==n-1)
                dp1[i] = Math.max(dp1[i-1], dp1[i-2]);
            else
                dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
            // 1번을 선택하지 않는 경우
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
            answer = Math.max(dp1[i], dp2[i]);
        }
        return answer;
    }
}