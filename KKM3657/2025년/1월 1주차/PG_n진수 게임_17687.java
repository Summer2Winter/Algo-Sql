class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int curr = 0, value = 0, cnt = 0;
        // 전체
        while(true) {
            // 숫자
            String number = Integer.toString(value, n);

            // 전체 개수 만큼 반복
            for(int i=0; i<number.length(); i++) {
                // 현재 시점
                if(curr == p-1) {
                    sb.append(Character.toString(number.charAt(i)).toUpperCase());
                    cnt++;
                }
                curr = (curr + 1) % m;
                if(cnt == t) {
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
            value++;
        }
        return sb.toString();
    }
}

/*
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder result = new StringBuilder();
        StringBuilder sequence = new StringBuilder(); // 전체 n진수 문자열
        int value = 0;

        // 필요한 길이: t * m (최소 이만큼 생성)
        while (sequence.length() < t * m) {
            sequence.append(Integer.toString(value++, n).toUpperCase());
        }

        // 튜브의 숫자만 추출
        for (int i = 0; i < t; i++) {
            result.append(sequence.charAt(i * m + (p - 1)));
        }

        return result.toString();
    }
}
 */