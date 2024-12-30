class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int gca = arr[0];
        // 최대 공배수 구하기
        for(int i=1; i<arr.length; i++) {
            // 최대 공약수 배우기
            int max = Math.max(gca, arr[i]);
            int min = Math.min(gca, arr[i]);

            // 최대 공약수
            int gcd = makeGcd(max, min);
            gca = max * min / gcd;
        }
        answer = gca;
        return answer;
    }
    public int makeGcd(int A, int B) {
        while(A != 1) {
            if(A % B == 0)
                return B;
            else {
                int temp = B;
                B = A % B;
                A = temp;
            }
        }
        return 1;
    }
}