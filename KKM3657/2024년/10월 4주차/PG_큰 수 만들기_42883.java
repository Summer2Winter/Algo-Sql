import java.util.ArrayDeque;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int N = number.length();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        // 앞에서부터 지우기
        for(int i=0; i<number.length(); i++) {
            char c = number.charAt(i);

            while(!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // 남은 k 처리
        while(k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}