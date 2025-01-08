import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        // 배열 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        // 투 포인터 방식
        int aIdx = 0, bIdx = 0;
        while (aIdx < A.length && bIdx < B.length) {
            // A의 값보다 B의 값이 크다면 매칭
            if (A[aIdx] < B[bIdx]) {
                answer++;
                aIdx++;
            }
            bIdx++; // 항상 B의 포인터는 증가
        }

        return answer;
    }
}
