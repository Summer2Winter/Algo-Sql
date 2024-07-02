// 마지막 비트 2개를 잡고 패턴을 보면
// ~10 -> ~11 로 변환
// ~01 -> ~10 로 변환 왜 11이 아닌가? 값이 제이 작아야 하므로
// ~00 -> ~01 로 변환
// ~11 -> 이게 문제인데 그냥 0인 부분을 찾아서 떠나면 된다.
// 예외 조건 전부 111 인경우 
// 이 경우는 1011 이렇게 맨앞만 01 -> 10으로 스왑 맨앞에 0이 있다고 생각하면 쉽다.
// 비트 연산자는 풀이 참고 중
 class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            if (num % 2 == 0) {
                
                // 10 -> 11
                // 00 -> 01 인 경우
                answer[i] = num + 1;
            } else {
                String binary = Long.toBinaryString(num);
                if (binary.contains("0")) {
                    // 01 -> 10 인 경우
                    int idx = binary.lastIndexOf("0");
                    binary = binary.substring(0, idx) + "10" + binary.substring(idx + 2);
                } else {
                    binary = "10" + binary.substring(1);
                }
                answer[i] = Long.parseLong(binary, 2);
            }
        }
        return answer;
    }
}