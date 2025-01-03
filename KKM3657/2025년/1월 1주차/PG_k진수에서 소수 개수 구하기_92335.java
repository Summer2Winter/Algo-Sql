class Solution {
    // 소수 판별 함수
    public boolean isPrime(long value) {
        if (value < 2) return false;
        if (value == 2) return true; // 2는 소수
        if (value % 2 == 0) return false; // 짝수는 소수가 아님
        for (long i = 3; i * i <= value; i += 2) { // 홀수만 검사
            if (value % i == 0) return false;
        }
        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;

        // n을 k진수 문자열로 변환
        String kBase = Integer.toString(n, k);

        for (String part : kBase.split("0")) {
            if (!part.isEmpty()) { // 빈 문자열은 건너뜀
                long value = Long.parseLong(part); // P를 10진수로 변환
                if (isPrime(value)) { // 소수 여부 판별
                    answer++;
                }
            }
        }

        return answer;
    }
}

/*
BigInteger 사용 방법
import java.math.BigInteger;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        // k진수
        String value = Integer.toString(n,k);
        // 투포인터
        for(int i=0; i<value.length(); i++) {
            // 0인 경우
            if(value.charAt(i) == '0')
                continue;
            // P 구성
            int j=i;
            StringBuilder sb = new StringBuilder();
            while(j<value.length() && value.charAt(j) != '0') {
                sb.append(value.charAt(j++));
            }
            BigInteger P = new BigInteger(sb.toString());

            // P가 소수인지 판별
            if(isPrime(P))
                answer++;
            i=j;
        }
        return answer;
    }
    public boolean isPrime(BigInteger number) {
        if (number.compareTo(BigInteger.ONE) <= 0) {
            return false; // 1 이하는 소수가 아님
        }
        BigInteger sqrt = number.sqrt(); // 제곱근 계산
        for (BigInteger i = BigInteger.TWO; i.compareTo(sqrt) <= 0; i = i.add(BigInteger.ONE)) {
            if (number.mod(i).equals(BigInteger.ZERO)) {
                return false; // 나눠떨어지면 소수가 아님
            }
        }
        return true;
    }
}
 */