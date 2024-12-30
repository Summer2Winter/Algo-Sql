class Solution {
    public long solution(int[] arrayA, int[] arrayB) {
        long answer = 0;

        long gcdA = arrayA[0], gcdB = arrayB[0];

        // A의 최대 공약수 찾기
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }

        // B의 최대 공약수 찾기
        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }

        // 조건에 맞는지 확인
        if (isPossible(arrayB, gcdA)) {
            answer = Math.max(answer, gcdA);
        }
        if (isPossible(arrayA, gcdB)) {
            answer = Math.max(answer, gcdB);
        }

        return answer;
    }

    // 최대공약수 찾기
    public long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 조건을 만족하는지 확인
    public boolean isPossible(int[] arr, long gcd) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % gcd == 0) {
                return false;
            }
        }
        return true;
    }
}