class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        // a^2 + b^2 구하기
        for(long i=0; i*k<=d; i++) {
            long a = i*k;
            long b = (long) Math.sqrt((long)d*d - (long)a*a);
            answer += (b/k + 1);
        }
        return answer;
    }
}