class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int N = sequence.length;
        // 1로 시작
        int[] plus = new int[N], minus = new int[N];
        for(int i=0; i<N; i++) {
            if(i % 2 == 0) {
                plus[i] = sequence[i];
                minus[i] = -sequence[i];
            }
            else {
                plus[i] = -sequence[i];
                minus[i] = sequence[i];
            }
        }
        // 구간합 최대
        long[] plusMax = new long[N], minusMax = new long[N];
        plusMax[0] = plus[0];
        minusMax[0] = minus[0];
        for(int i=1; i<N; i++) {
            plusMax[i] = Math.max(plusMax[i-1],0) + plus[i];
            minusMax[i] = Math.max(minusMax[i-1],0) + minus[i];
        }
        for(int i=0; i<N; i++) {
            answer = Math.max(answer, plusMax[i]);
            answer = Math.max(answer, minusMax[i]);
        }
        return answer;
    }
}