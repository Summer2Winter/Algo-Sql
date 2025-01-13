class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];
            // 짝수의 경우 오른쪽 비트가 0으로 끝나기 떄문에 n+1만 해도 됨
            if ((n & 1) == 0)
                answer[i] = n + 1;
            else {
                // 홀수의 경우, 가장 낮은 0 비트를 1로 바꾸고 그 다음 비트를 조정
                long bit = 1;
                // 가장 낮은 0 비트를 찾음
                while ((n & bit) != 0) {
                    bit <<= 1;
                }
                // 해당 비트 (n | bit)로 1로 설정, ~(bit >> 1)로 다음 비트를 0으로 만듬
                answer[i] = (n | bit) & ~(bit >> 1); // 조건을 만족하는 숫자 계산
            }
        }
        return answer;
    }
}
