class Solution {
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            String k = s.substring(0, i);  // 초기 비교 문자열
            int cnt = 1;  // 반복 횟수
            int j = i;  // 현재 위치
            StringBuilder sb = new StringBuilder();

            while (j < s.length()) {
                int endIdx = Math.min(j + i, s.length());
                String temp = s.substring(j, endIdx);
                // 동일한 경우
                if (k.equals(temp))
                    cnt++;
                else {
                    // 동일하지 않은 경우
                    if (cnt > 1)
                        sb.append(cnt);
                    sb.append(k);
                    k = temp;
                    cnt = 1;
                }
                j += i;
            }
            // 마지막 비교 문자열을 추가
            if (cnt > 1)
                sb.append(cnt);
            sb.append(k);
            answer = Math.min(answer, sb.toString().length());
        }
        return answer;
    }
}