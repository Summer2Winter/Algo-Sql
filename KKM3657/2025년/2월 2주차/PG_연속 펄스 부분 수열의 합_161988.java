class Solution {
    public long solution(int[] sequence) {
        long answer = 0;

        // 1,-1로 값을 만든경우
        int[] plus = new int[sequence.length], minus = new int[sequence.length];
        long[] dp1 = new long[sequence.length], dp2 = new long[sequence.length];

        // 전체 값 만들기
        for(int i=0; i<sequence.length; i++) {
            if(i%2 == 0) {
                plus[i] = sequence[i] * 1;
                minus[i] = sequence[i] * -1;
            }
            else {
                plus[i] = sequence[i] * -1;
                minus[i] = sequence[i] * 1;
            }
        }
        dp1[0] = plus[0];
        dp2[0] = minus[0];

        answer = Math.max(dp1[0],dp2[0]);

        // 구간의 최대 합 구하기
        for(int i=1; i<sequence.length; i++) {
            dp1[i] = Math.max(0, dp1[i-1]) + plus[i];
            dp2[i] = Math.max(0, dp2[i-1]) + minus[i];

            answer = Math.max(answer, dp1[i]);
            answer = Math.max(answer, dp2[i]);
        }

        return answer;
    }
}