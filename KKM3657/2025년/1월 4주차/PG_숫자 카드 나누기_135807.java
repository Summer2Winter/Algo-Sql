import java.util.Arrays;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        // 정렬
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        // arrayA, arrayB의 최대 공약수
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        for(int i=1; i<arrayA.length; i++) {
            gcdA = gcd(arrayA[i], gcdA);
            gcdB = gcd(arrayB[i], gcdB);
        }

        // 최대공약수A로 B를 나눌수 있는지
        boolean flagA = true;
        for(int value : arrayB) {
            if(value % gcdA == 0) {
                flagA = false;
                break;
            }
        }

        boolean flagB = true;
        for(int value : arrayA) {
            if(value % gcdB == 0) {
                flagB = false;
                break;
            }
        }
        if(flagA)
            answer = gcdA;
        if(flagB)
            answer = gcdB;
        if(flagA && flagB)
            answer = Math.max(gcdA,gcdB);
        return answer;
    }

    public int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }
}