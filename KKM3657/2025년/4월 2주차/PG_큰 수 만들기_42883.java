import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";

        int keep = number.length() - k;
        Deque<Character> stack = new ArrayDeque<>();

        // 앞자리부터 탐색
        for (char c : number.toCharArray()) {
            // k가 남아 있고, 스택 탑이 지금 문자보다 작으면 꺼내기
            while (k > 0 && !stack.isEmpty() && stack.peek() < c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        // 아직 k가 남아 있으면 뒤에서부터 제거
        while (k-- > 0) {
            stack.removeLast();
        }

        // 결과 길이만큼 앞에서부터 꺼내서 문자열로
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keep; i++) {
            sb.append(stack.removeLast());
        }

        return sb.toString();
    }
}