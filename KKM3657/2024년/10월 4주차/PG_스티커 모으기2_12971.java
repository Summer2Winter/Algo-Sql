class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int n = sticker.length;
        if (n == 1) return sticker[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        // 0번 스티커 선택
        dp1[0] = sticker[0];
        dp1[1] = Math.max(sticker[0], sticker[1]);

        // 0번 스티커 선택x
        dp2[1] = sticker[1];
        for(int i=2; i<n; i++) {
            // 첫 번째 스티커를 선택한 경우 (마지막 스티커를 선택할 수 없음)
            if (i != n - 1) {
                dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
            }

            // 첫 번째 스티커를 선택하지 않은 경우 (마지막 스티커 선택 가능)
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }
        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}